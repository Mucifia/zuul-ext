package com.graduation.gateway.repo.dao.redis;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServicePlanVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.service.RouteService;
import com.graduation.gateway.impl.service.ServicePlanService;
import com.graduation.gateway.impl.service.ServiceQualityService;
import com.graduation.gateway.repo.util.IGatewayConstant;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;


/**
 * @author: mmy
 * @date: 2018/12/25
 * @description:
 */

@Repository
public class RedisRepository {

	private static final String MAP_NAME_MANAGE = "MANAGE";
	private static final String OBJ_NAME_MANAGE = "MANAGE_OBJ";

	@Autowired
	RouteService routeService;

	@Autowired
	ServicePlanService servicePlanService;

	@Autowired
	ServiceQualityService serviceQualityService;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Value("${server.port}")
	private String serverPort;

	@Value("${server.context-path}")
	private String serverPath;

	@Resource(name = "redisTemplate")
	private HashOperations<String, String, Object> hashDict;

	public Map<String, Object> getAllRoutes() {
		return hashDict.entries(IGatewayConstant.MAP_NAME_ROUTE);
	}

	public Map<String, Object> getAllQos() {
		return hashDict.entries(IGatewayConstant.MAP_NAME_QOS);
	}

	public Object getQoSByRoutePath(String path) {
		return hashDict.get(IGatewayConstant.MAP_NAME_QOS, path);
	}


	/**
	 * gateway节点信息同步
	 * 若redis中已是最新信息，不予上传到redis
	 * @return
	 * @throws UnknownHostException
	 */
	private boolean beginRedisSync() throws UnknownHostException {

		Map<String, Object> manageMap = hashDict.entries(MAP_NAME_MANAGE);
		if (0 == manageMap.size()) {
			createManagementStamp(manageMap);

			return true;
		} else {
			RedisManagement redisManagement = (RedisManagement) manageMap.get(OBJ_NAME_MANAGE);
			if (null == redisManagement) {
				createManagementStamp(manageMap);
				return true;
			} else {
				long registeredTime = redisManagement.getBeginInitializeTime();
				long currentTime = System.currentTimeMillis();
				long offsetTime = currentTime - registeredTime;
				
				if (offsetTime < 0) {
					createManagementStamp(manageMap);
					return true;
				} else {
					// By default, any time length longer than 10 minutes,
					// should be judge as locked state
					if (offsetTime/IGatewayConstant.REDIS_SYN_TIME_LIMIT > 0) {
						createManagementStamp(manageMap);
						return true;
					}
				}

				return true;
			}
		}
	}

	/**
	 * gateway节点信息初始化并同步
	 * @param manageMap
	 * @return
	 * @throws UnknownHostException
	 */
	private RedisManagement createManagementStamp(Map<String, Object> manageMap) throws UnknownHostException {
		RedisManagement redisManagement = new RedisManagement();
		redisManagement.setBeginInitializeTime(System.currentTimeMillis());
		redisManagement.setInitializerIP(InetAddress.getLocalHost().getHostAddress());
		redisManagement.setInitializerPort(serverPort);
		manageMap.put(OBJ_NAME_MANAGE, redisManagement);
		hashDict.putAll(MAP_NAME_MANAGE, manageMap);

		return redisManagement;

	}

	/**
	 * Copy to Redis if necessary
	 * @throws UnknownHostException
	 */
	public synchronized void initializeRedis() throws UnknownHostException {

		Map<String, Object> redisRouteMap = new HashMap<String, Object>();
		Map<String, Object> redisRouteQoSMap = new HashMap<String, Object>();

		if (beginRedisSync()) {

			List<RouteVO> route = routeService.getAllRoutes();
			Map<String, ServicePlanVO> servicePlanMap = this.servicePlanService.getAllServicePlanMapById();
			Map<String, ServiceQualityVO> serviceQualityMapByRoute = this.serviceQualityService.getAllServiceQMapByRoute();
			Map<String, ServiceQualityVO> serviceQualityMapByPlan = this.serviceQualityService.getAllServiceQMapByPlan();

			// Begin the transaction to sync the redis repo
			// redisTemplate.getConnectionFactory().getConnection().openPipeline();

			route.stream().forEach(routeVO -> {
				redisRouteMap.put(routeVO.getRouteId(), routeVO);
				ServicePlanVO servicePlanVO = servicePlanMap.get(routeVO.getServicePlanId());
				if (routeVO.isQualityEnabled()) {
					ServiceQualityVO serviceQualityVO = serviceQualityMapByRoute.get(routeVO.getRouteId());
					redisRouteQoSMap.put(routeVO.getRouteId(), serviceQualityVO);
				} else {
					if (null == servicePlanVO || IGatewayConstant.AUTH_TYPE_API.equals(servicePlanVO.getAuthType())) {
						ServiceQualityVO serviceQualityVO = serviceQualityMapByPlan.get(routeVO.getServicePlanId());
						redisRouteQoSMap.put(routeVO.getPath(), serviceQualityVO);
					}
				}
			});

			}

			hashDict.putAll(IGatewayConstant.MAP_NAME_ROUTE, redisRouteMap);
			hashDict.putAll(IGatewayConstant.MAP_NAME_QOS, redisRouteQoSMap);
			// put local routes map to redis

		}


}
