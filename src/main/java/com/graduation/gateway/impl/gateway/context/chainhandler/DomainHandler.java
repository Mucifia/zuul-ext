package com.graduation.gateway.impl.gateway.context.chainhandler;

import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DomainHandler extends AbstractRouteHandler{
	
	public final static Logger logger = LoggerFactory.getLogger(DomainHandler.class);



	@Override
	public void handle(RouteBuilderContext ctx) {
		// TODO 自动生成的方法存根
		// Do nothing here
		
	}

	@Override
	protected void init() {
		logger.debug("enter init");
		this.childrenHandlers.add(new AppSystemHandler());
		logger.debug("exit init");
		
	}
	
	private boolean isDomainPrefixEnabled(){
		return false;
	}

}
