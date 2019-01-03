package com.graduation.gateway.impl.gateway.context.chainhandler;


import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class APIResourceHandler extends AbstractRouteHandler {
	
	public final static Logger logger = LoggerFactory.getLogger(APIResourceHandler.class);



	@Override
	public void handle(RouteBuilderContext ctx) {
		logger.debug("enter handle");
		
		logger.debug("exit handle");

	}

	@Override
	protected void init() {


	}


}
