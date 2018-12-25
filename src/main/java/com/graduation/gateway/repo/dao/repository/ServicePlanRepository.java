package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ServicePlanPO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ServicePlanRepository extends JpaRepository<ServicePlanPO,String> {

  public ServicePlanPO findServicePlanPOByName(String name);

  public ServicePlanPO findServicePlanPOByServicePlanIdAndStatusEquals(String servicePlanId,String status);

}
