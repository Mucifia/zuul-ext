package com.graduation.gateway.impl.gateway;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.impl.gateway.redis.RedisService;
import com.graduation.gateway.impl.service.RouteService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;

/**
 * @author: mmy
 * @date: 2018/12/25
 * @description:
 */

public class ZuulRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {


  private RouteService routeService;

  private RedisService redisService;

  /**
   * cache
   * prevent the redis and db is down
   */
  private Map<String, ZuulRoute> cachedRoutes = new HashMap<>();

  public ZuulRouteLocator(String servletPath,
      ZuulProperties properties, RouteService routeService, RedisService redisService) {
    super(servletPath, properties);
    this.routeService = routeService;
    this.redisService = redisService;
  }


  /**
   * two options , 1 use redis 2 use localDB
   */
  @Override
  protected Map<String, ZuulRoute> locateRoutes() {
    Map<String, ZuulRoute> map = new LinkedHashMap<>();
    map.putAll(loadRoutesFromRedis());
    return map;
  }

  private Map<String, ZuulRoute> loadRoutesFromRedis() {
    Map<String, ZuulRoute> map = new LinkedHashMap<>();
    Map<String, Object> objectMap = redisService.getAllRoutes();
    if (Objects.isNull(objectMap) || objectMap.isEmpty()) {
      redisService.initRedis();
      objectMap = redisService.getAllRoutes();
    }

    List<Object> list = new ArrayList<>(objectMap.values());
    map = convert(list);
    if (0 == map.size()) {
      map = cachedRoutes;
    } else {
      cachedRoutes = map;
    }

    return map;

  }


  private Map<String, ZuulRoute> loadRoutesFromDb() {
    List<RouteVO> routeVOS = routeService.getAllRoutes();
    return convert2(routeVOS);

  }

  private Map<String, ZuulRoute> convert2(List<RouteVO> routeVOS) {
    Map<String, ZuulRoute> map = new LinkedHashMap<>();
    if (Objects.isNull(routeVOS) || routeVOS.isEmpty()) {
      return map;
    }
    routeVOS.stream().forEach(routeVO -> {
      ZuulRoute zuulRoute = new ZuulRoute();
      zuulRoute.setId(routeVO.getRouteId());
      zuulRoute.setPath(routeVO.getPath());
      zuulRoute.setStripPrefix(routeVO.isStripPrefix());
      if (routeVO.isPreferURL()) {
        zuulRoute.setUrl(routeVO.getTargetUri());
      } else {
        zuulRoute.setServiceId(routeVO.getTargetServiceId());
      }
      map.put(routeVO.getPath(), zuulRoute);
    });
    return map;
  }

  private Map<String, ZuulRoute> convert(List<Object> routeVOS) {
    Map<String, ZuulRoute> map = new LinkedHashMap<>();
    if (Objects.isNull(routeVOS) || routeVOS.isEmpty()) {
      return map;
    }
    Object obj = routeVOS.get(routeVOS.size());
    if (obj instanceof RouteVO) {
      routeVOS.stream().forEach(o -> {
        RouteVO routeVO = (RouteVO) o;
        ZuulRoute zuulRoute = new ZuulRoute();
        zuulRoute.setId(routeVO.getRouteId());
        zuulRoute.setPath(routeVO.getPath());
        zuulRoute.setStripPrefix(routeVO.isStripPrefix());
        if (routeVO.isPreferURL()) {
          zuulRoute.setUrl(routeVO.getTargetUri());
        } else {
          zuulRoute.setServiceId(routeVO.getTargetServiceId());
        }
        map.put(routeVO.getPath(), zuulRoute);
      });
    }
    return map;
  }


  @Override
  public void refresh() {
    doRefresh();
  }
}
