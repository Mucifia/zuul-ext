package com.graduation.gateway.impl.gateway.context.builder;


import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;

public abstract class RouteBuilder {
	protected RouteBuilderContext ctx;
	protected String routePath;
	protected String routeTarget;
	
	public RouteBuilder(RouteBuilderContext context){
		ctx = context;
	}
	

    protected void buildRoutePath(){
    	routePath = ctx.getRoutePrefixPath();
    }

    protected void buildTarget(){
    	routeTarget = ctx.getTargetServiceId();
    }
    
    public abstract RouteVO buildRoute ();

}
