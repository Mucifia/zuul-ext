package com.graduation.gateway.impl.gateway.locator;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.impl.service.RouteService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

  public ZuulRouteLocator(String servletPath,
      ZuulProperties properties, RouteService routeService) {
    super(servletPath, properties);
    this.routeService = routeService;
  }


  /**
   * 覆盖掉了父类的locateRoutes，故zuulProperties配置的不算数了
   */
  @Override
  protected Map<String, ZuulRoute> locateRoutes() {
    Map<String,ZuulRoute> map = new LinkedHashMap<>();
    List<RouteVO> routeVOS = routeService.getAllRoutes();
    routeVOS.stream().forEach(routeVO -> {
      ZuulRoute zuulRoute = new ZuulRoute();
      zuulRoute.setId(routeVO.getRouteId());
      zuulRoute.setPath(routeVO.getPath());
      zuulRoute.setStripPrefix(routeVO.isStripPrefix());
      if (routeVO.isPreferURL()){
        zuulRoute.setUrl(routeVO.getTargetUri());
      }else {
        zuulRoute.setServiceId(routeVO.getTargetServiceId());
      }
      map.put(routeVO.getPath(),zuulRoute);
    });
    return map;
  }


  @Override
  public void refresh() {
    doRefresh();
  }
}
