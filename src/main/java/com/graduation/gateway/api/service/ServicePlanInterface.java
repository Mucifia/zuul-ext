package com.graduation.gateway.api.service;

import com.graduation.gateway.api.model.ServicePlanVO;
import com.graduation.gateway.api.util.InterfaceConstrants;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: mmy
 * @date: 2019/01/26
 * @description:
 */
public interface ServicePlanInterface {


  @PostMapping(value = InterfaceConstrants.PATH_SERVICE_PLAN_SAVE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void saveServicePlan(@RequestBody ServicePlanVO servicePlanVO);

  @GetMapping(value = InterfaceConstrants.PATH_SERVICE_PLAN,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ServicePlanVO getServicePlan(@PathVariable String servicePlanId);

  @GetMapping(value = InterfaceConstrants.PATH_SERVICE_PLAN_INFOS,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<ServicePlanVO> getServicePlans();

  @PutMapping(value = InterfaceConstrants.PATH_SERVICE_PLAN_UPDATE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void updateServicePlan(@RequestBody ServicePlanVO servicePlanVO);

  @DeleteMapping(value = InterfaceConstrants.PATH_SERVICE_PLAN_DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteServicePlan(@PathVariable String serivcePlanIds);



}

