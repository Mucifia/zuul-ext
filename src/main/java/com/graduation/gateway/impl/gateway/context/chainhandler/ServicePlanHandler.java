package com.graduation.gateway.impl.gateway.context.chainhandler;

import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServicePlanHandler extends AbstractRouteHandler {
	
	public final static Logger logger = LoggerFactory.getLogger(ServicePlanHandler.class);

    @Override
    protected void init() {
    	logger.debug("enter init");
        this.childrenHandlers.add(new APIHandler());
        this.childrenHandlers.add(new RateLimitHandler());
        this.childrenHandlers.add(new AuthorizationHandler());
        logger.debug("exit init");
    }

    @Override
    public void handle(RouteBuilderContext ctx) {
    	ctx.appendRoutePrefixPath(ctx.getServicePlan().getServicePlanId());
    }
    
    private void getRateLimitPolicy(){
    	//GetRatelimit by serviceplan
    }
}
