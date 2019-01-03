package com.graduation.gateway.impl.gateway.context;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServicePlanVO;
import java.util.HashMap;
import java.util.Map;


public class RouteDictionary {

	Map<String, RouteVO> routesOfPath = new HashMap<String, RouteVO>();

	Map<ServicePlanVO, RouteVO> routesOfServicePlan = new HashMap<ServicePlanVO, RouteVO>();
	

	

	private static RouteDictionary instance;

	private RouteDictionary() {
		loadRepository();
	}

	public static synchronized RouteDictionary getIntance() {
		if (null == instance) {
			instance = new RouteDictionary();
		}
		return instance;
	}

	private void loadRepository() {

	}

	public Map<String, RouteVO> getRoutesOfPath() {
		return routesOfPath;
	}

	public void setRoutesOfPath(Map<String, RouteVO> routesOfPath) {
		this.routesOfPath = routesOfPath;
	}

	public Map<ServicePlanVO, RouteVO> getRoutesOfServicePlan() {
		return routesOfServicePlan;
	}

	public void setRoutesOfServicePlan(Map<ServicePlanVO, RouteVO> routesOfServicePlan) {
		this.routesOfServicePlan = routesOfServicePlan;
	}

}
