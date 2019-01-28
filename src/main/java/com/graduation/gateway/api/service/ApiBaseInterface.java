package com.graduation.gateway.api.service;

import com.graduation.gateway.api.exception.GatewayServiceException;
import com.graduation.gateway.api.model.ApiBaseVO;
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
public interface ApiBaseInterface {

  @PostMapping(value = InterfaceConstrants.PATH_API_INFO_SAVE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void saveApiBase(@RequestBody ApiBaseVO apiBaseVO) throws GatewayServiceException;

  @GetMapping(value = InterfaceConstrants.PATH_API_INFO, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ApiBaseVO getApiBase(
      @PathVariable(name = InterfaceConstrants.PATH_VAR_NAME_API_ID) String apiId)throws GatewayServiceException;

  @GetMapping(value = InterfaceConstrants.PATH_API_INFOS, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<ApiBaseVO> getApiBases()throws GatewayServiceException;

  @PutMapping(value = InterfaceConstrants.PATH_API_INFO_UPDATE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void updateApiBase(@RequestBody ApiBaseVO apiBaseVO)throws GatewayServiceException;

  @DeleteMapping(value =InterfaceConstrants.PATH_API_INFO_DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteApiBase(@PathVariable(name = InterfaceConstrants.PATH_VAR_NAME_API_ID) String apiId)throws GatewayServiceException;


}
