package com.graduation.gateway.impl.gateway.context.chainhandler;

import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class APIHandler extends AbstractRouteHandler  {
	
	public final static Logger logger = LoggerFactory.getLogger(APIHandler.class);
	
    @Override
    protected void init() {
    	logger.debug("enter init");

    	this.childrenHandlers.add(new APIResourceHandler());
        
        this.childrenHandlers.add(new RouteBuilderHandler());
        //this.childrenHandlers.add(new RequestMethodHandler());
        logger.debug("exit init");
    }

    @Override
    public void handle(RouteBuilderContext ctx) {
    	logger.debug("enter handle");
    	//Add the customized api name to the url path
    	ctx.appendRoutePrefixPath(ctx.getEosApi().getName());
    	logger.debug("exit handle");

    }
}
