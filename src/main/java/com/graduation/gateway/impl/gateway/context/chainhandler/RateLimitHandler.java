package com.graduation.gateway.impl.gateway.context.chainhandler;

import com.graduation.gateway.impl.gateway.context.RouteBuilderContext;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties.Policy;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties.Policy.MatchType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RateLimitHandler extends AbstractRouteHandler {

  @Override
  protected void init() {

  }

  @Override
  public void handle(RouteBuilderContext ctx) {

  }


  private RateLimitProperties properties(RouteBuilderContext ctx) {
    RateLimitProperties.Policy policy = new RateLimitProperties.Policy();
    Map<String, List<Policy>> policies = new HashMap<>();

    policy.setLimit(2L);
    policy.setQuota(2L);
    policy.setRefreshInterval(2L);
    policy.setType(Arrays
        .asList(new MatchType(RateLimitProperties.Policy.Type.ORIGIN, null),
            new MatchType(RateLimitProperties.Policy.Type.URL, null),
            new MatchType(RateLimitProperties.Policy.Type.USER, null)
        ));
    RateLimitProperties properties = new RateLimitProperties();
    properties.setEnabled(true);
    properties.setBehindProxy(true);

    policies.put(ctx.getRoutePrefixPath(), Arrays.asList(policy));
    properties.setPolicyList(policies);

    //properties.setDefaultPolicy(policy);

    return properties;
  }
}
