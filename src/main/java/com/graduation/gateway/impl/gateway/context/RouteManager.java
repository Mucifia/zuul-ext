package com.graduation.gateway.impl.gateway.context;

import com.graduation.gateway.api.model.ApiBaseVO;
import com.graduation.gateway.api.model.ApiResourceVO;
import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServicePlanVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.api.util.GatewayServiceException;
import com.graduation.gateway.impl.gateway.redis.RedisRepository;
import com.graduation.gateway.impl.gateway.redis.RedisService;
import com.graduation.gateway.impl.service.ApiBaseService;
import com.graduation.gateway.impl.service.ApiResourceService;
import com.graduation.gateway.impl.service.RouteService;
import com.graduation.gateway.impl.service.ServicePlanService;
import com.graduation.gateway.impl.service.ServiceQualityService;
import com.graduation.gateway.repo.dao.model.ApiBasePO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RouteManager {
	@Autowired
	ApiBaseService ApiBaseService;

	@Autowired
	ServicePlanService servicePlanService;

	@Autowired
	ServiceQualityService serviceQualityService;

	@Autowired
	ApiResourceService apiResourceService;

	@Autowired
	RedisService redisService;

	RouteBuilderChain builderChain;

	public final static Logger logger = LoggerFactory.getLogger(RouteManager.class);

	public RouteManager() {

	}

	/**
	 * Publish the service plan's related routes
	 * 
	 * @param servicePlanId
	 * @throws GatewayServiceException
	 */
	public void generateRoutesByServicePlan(String servicePlanId) throws GatewayServiceException {
		logger.debug("enter generateRoutesByServicePlan");

		List<ApiBaseVO> relatedAPIs = ApiBaseService.getApiByServicePlanId(servicePlanId);
		ServicePlanVO servicePlan = servicePlanService.getById(servicePlanId);
		ServiceQualityVO serviceQualityVO = serviceQualityService.getServiceQualityByPlanId(servicePlanId);
		List<RouteVO> generatedRoutes = new ArrayList<RouteVO>();

		RouteBuilderContext ctx = null;

		for (int i = 0; i < relatedAPIs.size(); i++) {
			ApiBaseVO apiBaseVO = relatedAPIs.get(i);
			List<ApiResourceVO> apiResources = apiResourceService.getResByApiId(apiBaseVO.getApiId());
			ctx = decideRouteBuilderContext(servicePlan, serviceQualityVO, apiBaseVO, apiResources);

			List<RouteVO> routesPerAPI = ctx.getBuildChain().startToProcess();
			generatedRoutes.addAll(routesPerAPI);
		}

		redisService.saveRouteBatch(generatedRoutes, serviceQualityVO);
		logger.debug("exit generateRoutesByServicePlan");

	}

	/**
	 * 获取路由处理上下文
	 * @param servicePlan
	 * @param qos
	 * @param api
	 * @param apiRes
	 * @return
	 */
	private RouteBuilderContext decideRouteBuilderContext(ServicePlanVO servicePlan, ServiceQualityVO qos, ApiBaseVO api,
			List apiRes) {
		// 目前提供Zuul方式
		RouteBuilderContext ctx = new ZuulRouteBuilderContext(servicePlan, qos, api, apiRes);
		return ctx;

	}

}
