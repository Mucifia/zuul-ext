package com.graduation.gateway.impl.gateway.context.chainhandler;


import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;

/*

The route rule is that   [ip/hostname]:[port]/{serverPrefix}/{appSystemKey}/{servicePlanKey}/{apiKey}

 */
public class AppSystemHandler extends AbstractRouteHandler {


    @Override
    public void handle(RouteBuilderContext ctx) {
    	//ctx.appendRoutePath(ctx.getApplicationSystem().getCode());
    }

    @Override
    protected void init() {

        this.childrenHandlers.add(new ServicePlanHandler());

    }
}

