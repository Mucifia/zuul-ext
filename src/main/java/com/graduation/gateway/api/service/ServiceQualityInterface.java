package com.graduation.gateway.api.service;

import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.api.util.InterfaceConstrants;
import com.graduation.gateway.impl.service.ServiceQualityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public interface ServiceQualityInterface {

  @PostMapping(value = InterfaceConstrants.PATH_QUALITY_INFO_SAVE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void saveServiceQuality(@RequestBody ServiceQualityVO serviceQualityVO);

  @GetMapping(value = InterfaceConstrants.PATH_QUALITY_INFO,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ServiceQualityVO getServiceQuality(@PathVariable String qualityId);

  @GetMapping(value = InterfaceConstrants.PATH_QUALITY_INFOS,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<ServiceQualityVO> getServiceQualitys();

  @PutMapping(value = InterfaceConstrants.PATH_QUALITY_INFO_UPDATE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void updateServiceQuality(@RequestBody ServiceQualityVO serviceQualityVO);

  @DeleteMapping(value = InterfaceConstrants.PATH_QUALITY_INFO_DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteServiceQuality(@PathVariable String qualityId);
}
