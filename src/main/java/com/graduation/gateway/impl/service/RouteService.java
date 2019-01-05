package com.graduation.gateway.impl.service;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.utils.BeanTransformer;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.graduation.gateway.repo.dao.model.RoutePO;
import com.graduation.gateway.repo.dao.repository.RouteRepository;
import com.graduation.gateway.repo.dao.repository.ServiceQualityRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
@Service
public class RouteService {

  private final static Logger logger = LoggerFactory.getLogger(RouteService.class);


  @Autowired
  RouteRepository routeRepository;



  public List<RouteVO> getAllRoutes(){
    List<RoutePO> routeList = new ArrayList<>();
    routeList =routeRepository.findAll();
    return routeList.stream().map(r->{
      return BeanTransformer.convert(r,RouteVO.class);
    }).collect(Collectors.toList());
  }

  public RouteVO getRouteByRouteId(String routeId){
    return BeanTransformer.convert(routeRepository.findOne(routeId),RouteVO.class);
  }

  public void saveSSORoute(RouteVO route){
    routeRepository.save(BeanTransformer.convert(route,RoutePO.class));
  }

  public void saveRouteBatch(List<RouteVO> lstRoutes){
    List<RoutePO> routePOS = lstRoutes.stream().map(routeVO -> {
      return BeanTransformer.convert(routeVO,RoutePO.class);
    }).collect(Collectors.toList());
    routeRepository.save(routePOS);
  }

  public void deleteSSORoute(RouteVO route){
    RoutePO routePO = BeanTransformer.convert(route,RoutePO.class);
    routePO.setDelFlag(GatewayImplConstants.DELETE_FLAG_TRUE);
    routeRepository.save(routePO);
  }
  public void updateSSORoute(RouteVO route){
    RoutePO routePO = BeanTransformer.convert(route,RoutePO.class);
    routeRepository.save(routePO);
  }

  public void deleteRouteBatch(List<RouteVO> lstRoutes){
    List<RoutePO> routePOS = lstRoutes.stream().map(routeVO -> {
      return BeanTransformer.convert(routeVO,RoutePO.class);
    }).collect(Collectors.toList());
    routePOS.stream().forEach(routePO -> {
      routePO.setDelFlag(GatewayImplConstants.DELETE_FLAG_TRUE);
    });
    routeRepository.save(routePOS);
  }
}
