package com.graduation.gateway.impl.service;

import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.utils.BeanTransformer;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.graduation.gateway.repo.dao.model.ServiceQualityPO;
import com.graduation.gateway.repo.dao.repository.ServiceQualityRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
@Service
public class ServiceQualityService {

  @Autowired
  ServiceQualityRepository serviceQualityRepository;

  /**
   * map by routeId
   */
  public Map<String, ServiceQualityVO> getAllServiceQMapByRoute() {
    List<ServiceQualityPO> serviceQualityPOList = serviceQualityRepository.findAll();
    Map<String, ServiceQualityVO> map = new HashMap<>();
    serviceQualityPOList.stream().forEach(s -> {
      map.put(s.getRouteId(), BeanTransformer.convert(s, ServiceQualityVO.class));
    });
    return map;
  }


  /**
   * map by servicePlanId
   */
  public Map<String, ServiceQualityVO> getAllServiceQMapByPlan() {
    List<ServiceQualityPO> serviceQualityPOList = serviceQualityRepository.findAll();
    Map<String, ServiceQualityVO> map = new HashMap<>();
    serviceQualityPOList.stream().forEach(s -> {
      map.put(s.getServicePlanId(), BeanTransformer.convert(s, ServiceQualityVO.class));
    });
    return map;
  }

  public ServiceQualityVO getServiceQualityByPlanId(String planId) {
    ServiceQualityPO serviceQualityPO = serviceQualityRepository.findOne(planId);
    return BeanTransformer.convert(serviceQualityPO, ServiceQualityVO.class);
  }

  /**
   * 删除服务计划下的服务质量
   */
  public void updateDelFlagByPlanId(String servicePlanId) {
    ServiceQualityPO serviceQualityPO = serviceQualityRepository.findOne(servicePlanId);
    serviceQualityPO.setDelFlag(GatewayImplConstants.DELETE_FLAG_TRUE);
    serviceQualityRepository.save(serviceQualityPO);
  }

  /**
   * 根据routeId获取所有的服务质量
   */
  public List<ServiceQualityVO> getSSOQualityByRouteId(List<String> routeIds,int pageindex , int pageSize) {
    Pageable pageable = new PageRequest(pageindex,pageSize);
    List<ServiceQualityPO> serviceQualityPOList = serviceQualityRepository
        .findAllByRouteIdAndDelFlag(routeIds,pageable);
    return serviceQualityPOList.stream().map(s -> {
      return BeanTransformer.convert(s, ServiceQualityVO.class);
    }).collect(Collectors.toList());
  }

  public void save(List<ServiceQualityVO> serviceQualityVOS) {
    List<ServiceQualityPO> serviceQualityPOS = serviceQualityVOS.stream().map(s -> {
      return BeanTransformer.convert(s, ServiceQualityPO.class);
    }).collect(Collectors.toList());
    serviceQualityRepository.save(serviceQualityPOS);
  }

  public void save(ServiceQualityVO serviceQualityVO){
    serviceQualityRepository.save(BeanTransformer.convert(serviceQualityVO,ServiceQualityPO.class));
  }




}
