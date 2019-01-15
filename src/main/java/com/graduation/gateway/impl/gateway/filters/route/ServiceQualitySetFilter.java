package com.graduation.gateway.impl.gateway.filters.route;

import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixCommandProperties.Setter;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.BeansException;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author: mmy
 * @date: 2019/01/05
 * @description:
 */
public class ServiceQualitySetFilter extends ZuulFilter implements ApplicationContextAware {

  private ApplicationContext applicationContext;


  @Override
  public String filterType() {
    return FilterConstants.ROUTE_TYPE;
  }

  @Override
  public int filterOrder() {
    return FilterConstants.RIBBON_ROUTING_FILTER_ORDER - 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext context = RequestContext.getCurrentContext();
    ServiceQualityVO serviceQualityVO = (ServiceQualityVO) context
        .get(GatewayImplConstants.SERVICE_QUALITY);

    SpringClientFactory springClientFactory = applicationContext.getBean(SpringClientFactory.class);

    //ribbon server list (don't use eureka)
    springClientFactory.getClientConfig(GatewayImplConstants.SERVICE_QUALITY).set(
        CommonClientConfigKey.ListOfServers, (String) context.get(GatewayImplConstants.SERVER_LIST));

    //hystrix properties config

    HystrixPlugins.getInstance().registerPropertiesStrategy(new HystrixPropertiesStrategy() {
      @Override
      public HystrixCommandProperties getCommandProperties(HystrixCommandKey commandKey,
          Setter builder) {
        HystrixCommandProperties.Setter setter = builder
            .withCircuitBreakerEnabled(serviceQualityVO.isCbEnable())
            .withCircuitBreakerErrorThresholdPercentage(Integer.valueOf(serviceQualityVO.getCbErrorPercentage()))
            .withCircuitBreakerRequestVolumeThreshold(Integer.valueOf(serviceQualityVO.getCbRequestVolumeThreshold()))
            .withExecutionTimeoutInMilliseconds(serviceQualityVO.getRequestTimeout())
            .withCircuitBreakerSleepWindowInMilliseconds(serviceQualityVO.getCbRecoverTime())
            .withExecutionIsolationSemaphoreMaxConcurrentRequests(Integer.valueOf(serviceQualityVO.getMaxConcurrency()));
        return super.getCommandProperties(commandKey, setter);
      }
    });

    return null;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }
}
