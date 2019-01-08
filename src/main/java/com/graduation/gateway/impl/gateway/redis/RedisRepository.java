package com.graduation.gateway.impl.gateway.redis;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServicePlanVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.service.RouteService;
import com.graduation.gateway.impl.service.ServicePlanService;
import com.graduation.gateway.impl.service.ServiceQualityService;
import com.graduation.gateway.repo.util.IGatewayConstant;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
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

	ServerProperties serverProperties;

	RedisTemplateUtil redisTemplateUtil;

	public Map<Object, Object> getAllRoutes() {
		return redisTemplateUtil.getRouteRedisTemplate().opsForHash().entries(IGatewayConstant.MAP_NAME_ROUTE);
	}

	public Map<Object, Object> getAllQos() {
		return redisTemplateUtil.getSqRedisTemplate().opsForHash().entries(IGatewayConstant.MAP_NAME_QOS);
	}

	public Object getQoSByRouteId(String routeId) {
		return redisTemplateUtil.getSqRedisTemplate().opsForHash().get(IGatewayConstant.MAP_NAME_QOS, routeId);
	}
	public Object getRouteByRouteId(String routeId) {
		return redisTemplateUtil.getRouteRedisTemplate().opsForHash().get(IGatewayConstant.MAP_NAME_ROUTE, routeId);
	}
	public List<Object> getRouteByRouteId(List<String> routeIds) {
		List<Object> objects = new ArrayList<>(routeIds);
		return redisTemplateUtil.getRouteRedisTemplate().opsForHash().multiGet(IGatewayConstant.MAP_NAME_ROUTE,
				objects);
	}

	public RedisRepository(ServerProperties serverProperties, JedisConnectionFactory jedisConnectionFactory) {
		this.serverProperties = serverProperties;
		this.redisTemplateUtil = new RedisTemplateUtil(jedisConnectionFactory);
	}

	/**
	 *
	 * @return
	 * @throws UnknownHostException
	 */
	private boolean beginRedisSync() throws UnknownHostException {

		Map<Object, Object> manageMap = redisTemplateUtil.getMngRedisTemplate().opsForHash().entries(MAP_NAME_MANAGE);
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
	 * create Management Stamp
	 *
	 * @param manageMap
	 * @return
	 * @throws UnknownHostException
	 */
	private RedisManagement createManagementStamp(Map<Object, Object> manageMap) throws UnknownHostException {
		RedisManagement redisManagement = new RedisManagement();
		redisManagement.setBeginInitializeTime(System.currentTimeMillis());
		redisManagement.setInitializerIP(InetAddress.getLocalHost().getHostAddress());
		redisManagement.setInitializerPort(String.valueOf(serverProperties.getPort()));
		manageMap.put(OBJ_NAME_MANAGE, redisManagement);
		redisTemplateUtil.getSqRedisTemplate().opsForHash().putAll(MAP_NAME_MANAGE, manageMap);

		return redisManagement;

	}

	/**
	 *
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

			route.stream().forEach(routeVO -> {
				redisRouteMap.put(routeVO.getRouteId(), routeVO);
				ServicePlanVO servicePlanVO = servicePlanMap.get(routeVO.getServicePlanId());
				if (routeVO.isQualityEnabled()) {
					ServiceQualityVO serviceQualityVO = serviceQualityMapByRoute.get(routeVO.getRouteId());
					redisRouteQoSMap.put(routeVO.getRouteId(), serviceQualityVO);
				} else {
					if (null == servicePlanVO || IGatewayConstant.AUTH_TYPE_API.equals(servicePlanVO.getAuthType())) {
						ServiceQualityVO serviceQualityVO = serviceQualityMapByPlan.get(routeVO.getServicePlanId());
						redisRouteQoSMap.put(routeVO.getRouteId(), serviceQualityVO);
					}
				}
			});

			}

		redisTemplateUtil.getRouteRedisTemplate().opsForHash().putAll(IGatewayConstant.MAP_NAME_ROUTE, redisRouteMap);
		redisTemplateUtil.getSqRedisTemplate().opsForHash().putAll(IGatewayConstant.MAP_NAME_QOS, redisRouteQoSMap);
			// put local routes map to redis

		}


}
