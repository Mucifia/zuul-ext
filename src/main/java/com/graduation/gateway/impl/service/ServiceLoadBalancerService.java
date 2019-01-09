package com.graduation.gateway.impl.service;

import com.graduation.gateway.api.model.ServiceLoadBalancerVO;
import com.graduation.gateway.impl.utils.BeanTransformer;
import com.graduation.gateway.repo.dao.repository.ServiceLoadBalancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
@Service
public class ServiceLoadBalancerService {

  @Autowired
  ServiceLoadBalancerRepository serviceLoadBalancerRepository;


  public ServiceLoadBalancerVO getServiceLoadBalancerByServiceQualityId(String serviceQualityId){
    return BeanTransformer.convert(serviceLoadBalancerRepository.findServiceLoadBalancerPOByServiceQualityId(serviceQualityId),ServiceLoadBalancerVO.class);
  }
}
