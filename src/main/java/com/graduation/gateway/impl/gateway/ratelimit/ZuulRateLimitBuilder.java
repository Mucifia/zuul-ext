package com.graduation.gateway.impl.gateway.ratelimit;

import com.graduation.gateway.api.model.RouteVO;


public class ZuulRateLimitBuilder implements IRateLimitBuilder {

	@Override
	public void build(RouteVO route) {
		
		
	}


//    private RateLimitProperties properties() {
//        RateLimitProperties.Policy policy = new RateLimitProperties.Policy();
//        Map<String, List<RateLimitProperties.Policy>> policies = new HashMap<>();
//        PocRoute pocRoute = PocRoute.FACTORY.create();
//        //List<PocRoute> routeList = pocRouteDAO.findByTemplate(pocRoute);
//        
//        
//        for(PocRoute route : routeList){
//        	policy.setLimit(Long.parseLong(route.getRequestLimit()));
//        	policy.setQuota(Long.parseLong(route.getRequestQuota()));
//        	policy.setRefreshInterval(Long.parseLong(route.getRefreshInterval()));
//        	policy.setType(asList(RateLimitProperties.Policy.Type.ORIGIN, RateLimitProperties.Policy.Type.URL, RateLimitProperties.Policy.Type.USER));
//        	policies.put(route.getApiId(), Lists.newArrayList(policy));
//        }
//        RateLimitProperties properties = new RateLimitProperties();
//        properties.setEnabled(true);
//        properties.setBehindProxy(true);
//        properties.setPolicyList(policies);
        //properties.setDefaultPolicy(policy);

//        return properties;
//    }


}
