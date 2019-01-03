package com.graduation.gateway.impl.gateway.context;

import com.graduation.gateway.api.model.ApiBaseVO;
import com.graduation.gateway.api.model.ServicePlanVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import java.util.List;

public class ZuulRouteBuilderContext extends RouteBuilderContext {

	public ZuulRouteBuilderContext(ServicePlanVO servicePlan, ServiceQualityVO qos, ApiBaseVO apiBase, List apiRes) {
		super(servicePlan, qos, apiBase, apiRes);

	}

}
