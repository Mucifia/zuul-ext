package com.graduation.gateway.impl.gateway.ratelimit;

import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;
import com.graduation.gateway.impl.gateway.context.ZuulRouteBuilderContext;

public class RateLimitBuilderFactory {
	
	public IRateLimitBuilder generateBuilder(RouteBuilderContext ctx){
		if(ctx instanceof ZuulRouteBuilderContext){
			return new ZuulRateLimitBuilder();
		}
		return null;
	}

}
