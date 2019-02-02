package com.graduation.gateway.impl.controller;

import com.google.common.base.Splitter;
import com.graduation.gateway.api.model.ApiBaseVO;
import com.graduation.gateway.api.model.ServicePlanVO;
import com.graduation.gateway.api.service.ServicePlanInterface;
import com.graduation.gateway.api.util.InterfaceConstrants;
import com.graduation.gateway.impl.service.ApiBaseService;
import com.graduation.gateway.impl.service.ServicePlanApiRelationService;
import com.graduation.gateway.impl.service.ServicePlanService;
import com.graduation.gateway.repo.dao.model.ServicePlanApiRelationPO;
import com.graduation.gateway.repo.dao.model.ServicePlanPO;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mmy
 * @date: 2019/01/26
 * @description:
 */
@RestController
public class ServicePlanInterfaceImpl implements ServicePlanInterface {

  @Autowired
  ServicePlanApiRelationService servicePlanApiRelationService;

  @Autowired
  ServicePlanService servicePlanService;

  @Autowired
  ApiBaseService apiBaseService;


  private final Splitter splitter = Splitter.on(InterfaceConstrants.STRING_SEPARATE_COMMA)
      .omitEmptyStrings();

  @Override
  public void saveServicePlan(@RequestBody ServicePlanVO servicePlanVO) {
    ServicePlanPO servicePlanPO = servicePlanService.save(servicePlanVO);
    String servicePlanId = servicePlanPO.getServicePlanId();
    List<ApiBaseVO> apiBaseVOS = servicePlanVO.getApiBaseVOS();
    if (apiBaseVOS.size()>0){
      apiBaseVOS.stream().forEach(apiBaseVO -> {
        ServicePlanApiRelationPO servicePlanApiRelationPO = servicePlanApiRelationService.findByServicePlanIdandApiId(servicePlanId,apiBaseVO.getApiId());
        if (Objects.isNull(servicePlanApiRelationPO)){
          ServicePlanApiRelationPO po = new ServicePlanApiRelationPO();
          po.setApiId(apiBaseVO.getApiId());
          po.setServiceplanId(servicePlanId);
          servicePlanApiRelationService.save(po);
        }

      });
    }
  }

  @Override
  public ServicePlanVO getServicePlan(@PathVariable String servicePlanId) {
    ServicePlanVO servicePlanVO = servicePlanService.getById(servicePlanId);
    List<ApiBaseVO> apiBaseVOS = apiBaseService.getApiByServicePlanId(servicePlanId);
    apiBaseVOS.stream().forEach(apiBaseVO -> {
      apiBaseVO.setKey(apiBaseVO.getApiId());
    });
    servicePlanVO.setApiBaseVOS(apiBaseVOS);
    return servicePlanVO;
  }

  @Override
  public List<ServicePlanVO> getServicePlans() {
    List<ServicePlanVO> servicePlanVOS = servicePlanService.getAllServicePlans();
    servicePlanVOS.stream().forEach(servicePlanVO -> {
      servicePlanVO.setKey(servicePlanVO.getServicePlanId());
    });
    return servicePlanVOS;
  }

  @Override
  public void updateServicePlan(@RequestBody  ServicePlanVO servicePlanVO) {
    servicePlanService.save(servicePlanVO);
    String servicePlanId = servicePlanVO.getServicePlanId();
    List<ApiBaseVO> apiBaseVOS = servicePlanVO.getApiBaseVOS();
    if (apiBaseVOS.size()>0){
      apiBaseVOS.stream().forEach(apiBaseVO -> {
        ServicePlanApiRelationPO servicePlanApiRelationPO = new ServicePlanApiRelationPO();
        servicePlanApiRelationPO.setApiId(apiBaseVO.getApiId());
        servicePlanApiRelationPO.setServiceplanId(servicePlanId);
        servicePlanApiRelationService.save(servicePlanApiRelationPO);
      });
    }
  }

  @Override
  public void deleteServicePlan(@PathVariable  String servicePlanId) {
    List<String> ids = splitter.splitToList(servicePlanId);
    ids.stream().forEach(s -> {
      servicePlanService.updateDelFlagById(s);
      servicePlanApiRelationService.deleteByServiceplanId(s);
    });
  }
}
