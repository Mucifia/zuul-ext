package com.graduation.gateway.impl.gateway.context;


import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.impl.gateway.context.chainhandler.AbstractRouteHandler;
import com.graduation.gateway.impl.gateway.context.chainhandler.AppSystemHandler;
import com.graduation.gateway.impl.gateway.context.chainhandler.RouteHandler;
import java.util.ArrayList;
import java.util.List;

public class RouteBuilderChain {
	
	private RouteBuilderContext ctx;

    private List<RouteHandler> handlers = new ArrayList<RouteHandler>();
    
    
    public RouteBuilderChain(RouteBuilderContext ctx){
    	this.ctx = ctx;
    }

    public List<RouteVO> startToProcess() {

        internalProcess(ctx,getHeadHandler());

        return ctx.getRoute();

    }

    private void internalProcess(RouteBuilderContext ctx, RouteHandler routeHandler) {

        routeHandler.handle(ctx);
        internalProcessChildren(ctx, routeHandler);

    }

    private void internalProcessChildren(RouteBuilderContext ctx, RouteHandler routeHandler) {
        List<RouteHandler> childrenHandlers = routeHandler.getChildrenHandlers();
        for (int i = 0; i < childrenHandlers.size(); i++) {
            internalProcess(ctx, childrenHandlers.get(i));
        }
    }

    private AbstractRouteHandler getHeadHandler(){
        return new AppSystemHandler();
    }


}
