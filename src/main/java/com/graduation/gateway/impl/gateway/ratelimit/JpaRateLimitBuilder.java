package com.graduation.gateway.impl.gateway.ratelimit;

import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.service.ServiceQualityService;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties.Policy;
import java.util.List;
import java.util.Map;


/**
 *
 */
public class JpaRateLimitBuilder extends IRateLimitBuilder {




  public Policy covertToPolicy(ServiceQualityVO serviceQualityVO) {
    ServiceQualityService serviceQualityService = new ServiceQualityService();
    return serviceQualityService.getRateLimitPolicy(serviceQualityVO);
  }


  @Override
  public Map<String, Policy> getPolicies(String routeId) {
    return null;
  }

  @Override
  public Map<String, Policy> getPolicies(List<String> routeId) {
    return null;
  }

  @Override
  public Map<String, Policy> getAllPolicies() {
    return null;
  }
}
