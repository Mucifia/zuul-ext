package com.graduation.gateway.api.service;

import com.graduation.gateway.api.model.ServiceQualityVO;
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
public interface ServiceQualityService {


  @PostMapping()
  public void saveServiceQuality();

  @GetMapping()
  public ServiceQualityVO getServiceQuality();

  @GetMapping()
  public List<ServiceQualityVO> getServiceQualitys();

  @PutMapping()
  public void updateServiceQuality();

  @DeleteMapping()
  public void deleteServiceQuality();
}
