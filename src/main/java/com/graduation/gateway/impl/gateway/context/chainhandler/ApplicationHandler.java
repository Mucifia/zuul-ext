package com.graduation.gateway.impl.gateway.context.chainhandler;

import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
If the target is routed by serviceID or URL
 */

public class ApplicationHandler implements RouteHandler {
	public final static Logger logger = LoggerFactory.getLogger(ApplicationHandler.class);



    @Override
    public void handle(RouteBuilderContext ctx) {


    }

    @Override
    public List<RouteHandler> getChildrenHandlers() {

        return null;
    }
}
