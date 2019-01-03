package com.graduation.gateway.impl.gateway.ratelimit;

import com.graduation.gateway.api.model.RouteVO;

public interface IRateLimitBuilder {
	
	public void build(RouteVO route);

}
