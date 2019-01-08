package com.graduation.gateway.impl.gateway.context.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.context.ApplicationListener;

/**
 *
 */
public class RouteChangedEventListener implements ApplicationListener<RouteChangedEvent> {

	private static Logger logger = LoggerFactory.getLogger(RouteChangedEventListener.class);
	
	private ZuulHandlerMapping zuulHandlerMapping;

	public RouteChangedEventListener(ZuulHandlerMapping zuulHandlerMapping) {
		this.zuulHandlerMapping = zuulHandlerMapping;
	}

	@Override
	public void onApplicationEvent(RouteChangedEvent routeChangedEvent) {
		logger.info("Route changed, Operation {}, source {}", routeChangedEvent.getOperation(),
				routeChangedEvent.getSource());
		zuulHandlerMapping.setDirty(true);
	}
	
}
