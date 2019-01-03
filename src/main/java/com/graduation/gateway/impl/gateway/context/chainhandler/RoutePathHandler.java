package com.graduation.gateway.impl.gateway.context.chainhandler;


import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;

public class RoutePathHandler extends AbstractRouteHandler {

	private void generateRouetPath(RouteBuilderContext ctx) {
		StringBuilder sb = new StringBuilder();

		// ctx.setRoutePath(sb.toString());

		// Should add some rules as * or **
		//ctx.appendRoutePrefixPath(IEOSGatewayConstant.CONST_WILDCARD);

	}

	@Override
	public void handle(RouteBuilderContext ctx) {

		generateRouetPath(ctx);

	}

	@Override
	protected void init() {

	}
}
