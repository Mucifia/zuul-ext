package com.graduation.gateway.impl.gateway.context;

import com.graduation.gateway.api.model.ApiBaseVO;
import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServicePlanVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.graduation.gateway.repo.dao.model.ApiResourcePO;
import java.util.List;


public class RouteBuilderContext {

	protected ServicePlanVO servicePlan;
	protected ApiBaseVO apiBase;
	protected List<RouteVO> routes;
	protected List<ApiResourcePO> resources;
	private String serverPrefix;
	private StringBuilder routePrefixPath = new StringBuilder();
	private RouteBuilderChain buildChain;
	private String targetServiceId;
	private List<ApiResourcePO> apiResources;
	private ServiceQualityVO planQos;

	public ServiceQualityVO getPlanQos() {
		return planQos;
	}

	public void setPlanQos(ServiceQualityVO planQos) {
		this.planQos = planQos;
	}

	public List<ApiResourcePO> getApiResources() {
		return apiResources;
	}

	public void setApiResources(List<ApiResourcePO> apiResources) {
		this.apiResources = apiResources;
	}

	public void appendRoutePrefixPath(String name) {
		routePrefixPath.append(GatewayImplConstants.CONST_SLASH + name);

	}

	public RouteBuilderContext(ServicePlanVO servicePlan, ServiceQualityVO qos, ApiBaseVO apiBase, List apiRes) {

		this.servicePlan = servicePlan;
		this.apiBase = apiBase;
		this.planQos = qos;
		apiResources = apiRes;

		this.buildChain = new RouteBuilderChain(this);

	}

	public List<RouteVO> getRoute() {
		return routes;
	}

	public void setRoute(List<RouteVO> eosRoute) {
		this.routes = eosRoute;
	}

	public String getTargetServiceId() {
		return targetServiceId;
	}

	public void setTargetServiceId(String targetServiceId) {
		this.targetServiceId = targetServiceId;
	}

	public ServicePlanVO getServicePlan() {
		return servicePlan;
	}

	public void setServicePlan(ServicePlanVO servicePlan) {
		this.servicePlan = servicePlan;
	}

	public ApiBaseVO getEosApi() {
		return apiBase;
	}

	public void setEosApi(ApiBaseVO apiBase) {
		this.apiBase = apiBase;
	}

	public String getServerPrefix() {
		return serverPrefix;
	}

	public String getRoutePrefixPath() {
		return routePrefixPath.toString();
	}

	public RouteBuilderChain getBuildChain() {
		return buildChain;
	}

}
