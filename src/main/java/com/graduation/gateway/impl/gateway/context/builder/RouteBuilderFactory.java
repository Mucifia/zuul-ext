package com.graduation.gateway.impl.gateway.context.builder;


import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;
import com.graduation.gateway.impl.gateway.context.ZuulRouteBuilderContext;

public class RouteBuilderFactory {
	
	public RouteBuilder generateBuilder(RouteBuilderContext ctx){
		
		if(ctx instanceof ZuulRouteBuilderContext){
			return new ZuulRouteBuilder(ctx);
		}
		return null;
	}

}
