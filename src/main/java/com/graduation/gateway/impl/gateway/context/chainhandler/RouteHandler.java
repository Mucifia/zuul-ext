package com.graduation.gateway.impl.gateway.context.chainhandler;

import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;
import java.util.List;

public interface RouteHandler {


    public List<RouteHandler> getChildrenHandlers();

    public void handle(RouteBuilderContext ctx);

}
