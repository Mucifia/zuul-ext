package com.graduation.gateway.api.service;

import com.graduation.gateway.api.model.ServicePlanVO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author: mmy
 * @date: 2019/01/26
 * @description:
 */
public interface ServicePlanInterface {


  @PostMapping()
  public void saveServicePlan();

  @GetMapping()
  public ServicePlanVO getServicePlan();

  @GetMapping()
  public List<ServicePlanVO> getServicePlans();

  @PutMapping()
  public void updateServicePlan();

  @DeleteMapping()
  public void deleteServicePlan();



}

