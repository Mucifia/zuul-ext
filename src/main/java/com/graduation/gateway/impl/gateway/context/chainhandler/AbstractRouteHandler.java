package com.graduation.gateway.impl.gateway.context.chainhandler;

import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRouteHandler implements RouteHandler {
    RouteBuilderContext ctx = null;
    List<RouteHandler> childrenHandlers = new ArrayList<RouteHandler>();

    protected abstract void init();

    protected AbstractRouteHandler(){
        init();
    }

    @Override
    public List<RouteHandler> getChildrenHandlers() {

        return childrenHandlers;
    }
}
