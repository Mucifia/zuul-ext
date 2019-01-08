package com.graduation.gateway.impl.gateway.context;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServicePlanVO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * cache
 */
public class RouteDictionary {

	Map<String, RouteVO> routesOfPath = new HashMap<String, RouteVO>();

	Map<ServicePlanVO, RouteVO> routesOfServicePlan = new HashMap<ServicePlanVO, RouteVO>();

	List<String> ipWhiteList = new ArrayList<>();

	List<String> ipBlackList = new ArrayList<>();




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

	public List<String> getIpWhiteList() {
		return ipWhiteList;
	}

	public void setIpWhiteList(List<String> ipWhiteList) {
		this.ipWhiteList = ipWhiteList;
	}

	public List<String> getIpBlackList() {
		return ipBlackList;
	}

	public void setIpBlackList(List<String> ipBlackList) {
		this.ipBlackList = ipBlackList;
	}
}
