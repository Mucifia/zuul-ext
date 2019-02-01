package com.graduation.gateway.impl.controller;

import com.google.common.base.Splitter;
import com.graduation.gateway.api.model.ApiBaseVO;
import com.graduation.gateway.api.model.ServicePlanVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.api.service.ServiceQualityInterface;
import com.graduation.gateway.api.util.InterfaceConstrants;
import com.graduation.gateway.impl.service.ApiBaseService;
import com.graduation.gateway.impl.service.ServicePlanService;
import com.graduation.gateway.impl.service.ServiceQualityService;
import com.netflix.discovery.converters.Auto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mmy
 * @date: 2019/01/26
 * @description:
 */
@RestController
public class ServiceQualityInterfaceImpl implements ServiceQualityInterface {

  @Autowired
  ServiceQualityService serviceQualityService;

  @Autowired
  ApiBaseService apiBaseService;

  @Autowired
  ServicePlanService servicePlanService;

  private final Splitter splitter = Splitter.on(InterfaceConstrants.STRING_SEPARATE_COMMA)
      .omitEmptyStrings();

  @Override
  public void saveServiceQuality(@RequestBody  ServiceQualityVO serviceQualityVO) {
    serviceQualityService.save(serviceQualityVO);
  }

  @Override
  public ServiceQualityVO getServiceQuality(@PathVariable  String qualityId) {
    ServiceQualityVO serviceQualityVO = serviceQualityService.getServiceQualityByQualityId(qualityId);
    List<ApiBaseVO> apiBaseVOS = apiBaseService.getApiBaseByQualityId(qualityId);
    List<ServicePlanVO> servicePlanVOS = servicePlanService.getServicePlanVOByQualityId(qualityId);
    serviceQualityVO.setApiBaseVOS(apiBaseVOS);
    serviceQualityVO.setServicePlanVOS(servicePlanVOS);
    return serviceQualityVO;
  }

  @Override
  public List<ServiceQualityVO> getServiceQualitys() {
    List<ServiceQualityVO> serviceQualityVOS =  serviceQualityService.getAllServiceQuality();
    serviceQualityVOS.stream().forEach(serviceQualityVO -> {
      serviceQualityVO.setKey(serviceQualityVO.getServiceQualityId());
    });
    return serviceQualityVOS;
  }

  @Override
  public void updateServiceQuality(@RequestBody  ServiceQualityVO serviceQualityVO) {
    serviceQualityService.save(serviceQualityVO);
  }

  @Override
  public void deleteServiceQuality(@PathVariable  String qualityId) {
    List<String> qualityIds = splitter.splitToList(qualityId);
    qualityIds.stream().forEach(s -> {
      serviceQualityService.deleteById(s);
    });
  }
}
