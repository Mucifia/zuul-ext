package com.graduation.gateway.impl.gateway;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.impl.gateway.filters.pre.BlackWhiteListFilter;
import com.graduation.gateway.impl.gateway.filters.pre.ServiceQualityLoadFilter;
import com.graduation.gateway.impl.gateway.filters.route.ServiceQualitySetFilter;
import com.graduation.gateway.impl.gateway.ratelimit.IRateLimitBuilder;
import com.graduation.gateway.impl.gateway.ratelimit.RateLimitBuilderFactory;
import com.graduation.gateway.impl.gateway.redis.RedisRepository;
import com.graduation.gateway.impl.gateway.redis.RedisService;
import com.graduation.gateway.impl.service.RouteService;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.RateLimitAutoConfiguration;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties.Policy;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @author: mmy
 * @date: 2018/12/25
 * @description:
 */
@Configuration
public class ZuulConfiguration {

  @Autowired
  ServerProperties serverProperties;

  @Bean
  public ZuulRouteLocator zuulRouteLocator(ZuulProperties zuulProperties, RouteService routeService,
      RedisService redisService) {
      return new ZuulRouteLocator(this.serverProperties.getServletPath(), zuulProperties,
          routeService,redisService);
  }

  @Bean
  public JedisConnectionFactory jedisConnectionFactory(){
    return new JedisConnectionFactory();
  }


  @Bean
  public BlackWhiteListFilter blackWhiteListFilter(){
    return new BlackWhiteListFilter();
  }

  @Bean
  public ServiceQualityLoadFilter serviceQualityLoadFilter(){
    return new ServiceQualityLoadFilter();
  }

  @Bean
  public ServiceQualitySetFilter serviceQualitySetFilter(){
    return new ServiceQualitySetFilter();
  }



  @Configuration
  @AutoConfigureAfter(RateLimitAutoConfiguration.class)
  public class RateLimitPropertiesSetter{

    private RateLimitProperties rateLimitProperties;

    private RedisRepository redisRepository;

    public RateLimitPropertiesSetter(
        RateLimitProperties rateLimitProperties,
        RedisRepository redisRepository) {
      this.rateLimitProperties = rateLimitProperties;
      this.redisRepository = redisRepository;
    }

    @PostConstruct
    public void init(){
      IRateLimitBuilder rateLimitBuilder = RateLimitBuilderFactory.generateBuilder(rateLimitProperties.getRepository());
      rateLimitBuilder.setRedisRepository(redisRepository);
      Map<String,Policy> policies = rateLimitBuilder.getAllPolicies();
      if (!policies.isEmpty()){
        rateLimitProperties.getPolicies().putAll(policies);
      }
    }


}
}
