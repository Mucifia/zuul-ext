package com.graduation.gateway.impl.gateway.context.builder;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;

public class ZuulRouteBuilder extends RouteBuilder {

	public ZuulRouteBuilder(RouteBuilderContext context) {
		super(context);

	}

	@Override
	public RouteVO buildRoute() {
		ZuulRoute zuulRoute = new ZuulRoute();

		zuulRoute.setId(ctx.getRoutePrefixPath());
		zuulRoute.setServiceId(ctx.getTargetServiceId());
		RouteVO route = new RouteVO();
		//route.setRoute(zuulRoute);

		return route;
	}

}
