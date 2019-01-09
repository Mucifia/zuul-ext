package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.api.model.ServiceLoadBalancerVO;
import com.graduation.gateway.repo.dao.model.ServiceLoadBalancerPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ServiceLoadBalancerRepository extends JpaRepository<ServiceLoadBalancerPO,String> {

  public ServiceLoadBalancerPO findServiceLoadBalancerPOByName(String name);

  public ServiceLoadBalancerPO findServiceLoadBalancerPOByServiceQualityId(String serviceQualityId);
}
