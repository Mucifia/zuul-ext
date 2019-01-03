package com.graduation.gateway.impl.gateway.context.chainhandler;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;
import com.graduation.gateway.repo.dao.model.ApiResourcePO;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RouteBuilderHandler extends AbstractRouteHandler {

	List<RouteVO> routes = new ArrayList<RouteVO>();
	
	public final static Logger logger = LoggerFactory.getLogger(RouteBuilderHandler.class);

	@Override
	protected void init() {

	}

	@Override
	public void handle(RouteBuilderContext ctx) {
		
		logger.debug("enter handle");
		
		//Generate all routes according to the ApiResources
		List<RouteVO> routes = new ArrayList<RouteVO>();
		for (int i = 0; i < ctx.getApiResources().size(); i++) {
			ApiResourcePO theRes = ctx.getApiResources().get(i);
			routes.add(generateRoute(ctx, theRes));
		}
		ctx.setRoute(routes);
		
		logger.debug("exit handle");

	}

	public RouteVO generateRoute(RouteBuilderContext ctx, ApiResourcePO apiRes) {
		
		logger.debug("enter generateRoute");
		RouteVO newRoute = new RouteVO();
		newRoute.setPath(ctx.getRoutePrefixPath() + apiRes.getPathName());
		newRoute.setTargetServiceId(apiRes.getServiceId());
		//API模式下，默认Qos由每个Plan来制定
		newRoute.setQualityEnabled(false);
		logger.debug("exit generateRoute");
		return newRoute;
		
	}
}
