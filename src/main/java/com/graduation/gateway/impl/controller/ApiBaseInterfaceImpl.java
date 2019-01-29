package com.graduation.gateway.impl.controller;

import com.graduation.gateway.api.exception.GatewayServiceException;
import com.graduation.gateway.api.model.ApiBaseVO;
import com.graduation.gateway.api.model.ApiParamVO;
import com.graduation.gateway.api.model.ApiResourceDetailVO;
import com.graduation.gateway.api.model.ApiResourceVO;
import com.graduation.gateway.api.model.ApiResponseVO;
import com.graduation.gateway.api.model.ApiTransformVO;
import com.graduation.gateway.api.service.ApiBaseInterface;
import com.graduation.gateway.impl.service.ApiBaseService;
import com.graduation.gateway.impl.service.ApiParamService;
import com.graduation.gateway.impl.service.ApiResourceDetailService;
import com.graduation.gateway.impl.service.ApiResourceService;
import com.graduation.gateway.impl.service.ApiResponseService;
import com.graduation.gateway.impl.service.ApiTransformService;
import java.util.List;
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
public class ApiBaseInterfaceImpl implements ApiBaseInterface {


  @Autowired
  ApiBaseService apiBaseService;

  @Autowired
  ApiResponseService apiResponseService;

  @Autowired
  ApiResourceDetailService apiResourceDetailService;

  @Autowired
  ApiParamService apiParamService;

  @Autowired
  ApiTransformService apiTransformService;

  @Autowired
  ApiResourceService apiResourceService;


  @Override
  public void saveApiBase(@RequestBody  ApiBaseVO apiBaseVO) throws GatewayServiceException {
    //save apiBase
    String apiId = apiBaseService.save(apiBaseVO).getApiId();
    ApiResourceVO apiResourceVO = apiBaseVO.getApiResourceVO();
    apiResourceVO.setApiId(apiId);
    //save apiresource
    String apiResourceId =apiResourceService.save(apiResourceVO).getApiResourceId();
    ApiResourceDetailVO apiResourceDetailVO = apiResourceVO.getApiResourceDetailVO();
    apiResourceDetailVO.setApiResourceId(apiResourceId);
    //save apiresourceDeteail
    String apiResourceDetailId = apiResourceDetailService.save(apiResourceDetailVO).getApiResourceDetailId();
    //save apiParams
    List<ApiParamVO> apiParamVOS = apiResourceDetailVO.getApiParamVOS();
    apiParamVOS.stream().forEach(apiParamVO -> {
      apiParamVO.setApiResourceDetailId(apiResourceDetailId);
    });
    apiParamService.save(apiParamVOS);
    //save apiTransfroms
    List<ApiTransformVO> apiTransformVOS = apiResourceDetailVO.getApiTransformVOS();
    apiTransformVOS.stream().forEach(apiTransformVO -> {
      apiTransformVO.setApiResourceDetailId(apiResourceDetailId);
    });
    apiTransformService.save(apiTransformVOS);
    //save apiResponses
    List<ApiResponseVO> apiResponseVOS = apiResourceDetailVO.getApiResponseVOS();
    apiResponseVOS.stream().forEach(apiResponseVO -> {
      apiResponseVO.setApiResourceDetailId(apiResourceDetailId);
    });
    apiResponseService.save(apiResponseVOS);
  }

  @Override
  public ApiBaseVO getApiBase(@PathVariable  String apiId) throws GatewayServiceException {
    return null;
  }

  @Override
  public List<ApiBaseVO> getApiBases() throws GatewayServiceException {
    return apiBaseService.getAllApiBase();
  }

  @Override
  public void updateApiBase(@RequestBody  ApiBaseVO apiBaseVO) throws GatewayServiceException {

  }

  @Override
  public void deleteApiBase(@PathVariable String apiId) throws GatewayServiceException {

  }
}
