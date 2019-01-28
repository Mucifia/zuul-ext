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
    String apiId = apiBaseService.save(apiBaseVO).getApiId();
    ApiResourceVO apiResourceVO = apiBaseVO.getApiResourceVO();
    apiResourceVO.setApiId(apiId);
    String apiResourceId =apiResourceService.save(apiResourceVO).getApiResourceId();
    ApiResourceDetailVO apiResourceDetailVO = apiResourceVO.getApiResourceDetailVO();
    apiResourceDetailVO.setApiResourceId(apiResourceId);
    String apiResourceDetailId = apiResourceDetailService.save(apiResourceDetailVO).getApiResourceDetailId();
//    ApiParamVO apiParamVO = apiResourceDetailVO.getApiParamVO();
//    apiParamVO.setApiResourceDetailId(apiResourceDetailId);
//    ApiResponseVO apiResponseVO = apiResourceDetailVO.getApiResponseVO();
//    apiResponseVO.setApiResourceDetailId(apiResourceDetailId);
//    ApiTransformVO apiTransformVO = apiResourceDetailVO.getApiTransformVO();
//    apiTransformVO.setApiResourceDetailId(apiResourceDetailId);
  }

  @Override
  public ApiBaseVO getApiBase(@PathVariable  String apiId) throws GatewayServiceException {
    return null;
  }

  @Override
  public List<ApiBaseVO> getApiBases() throws GatewayServiceException {
    return null;
  }

  @Override
  public void updateApiBase(@RequestBody  ApiBaseVO apiBaseVO) throws GatewayServiceException {

  }

  @Override
  public void deleteApiBase(@PathVariable String apiId) throws GatewayServiceException {

  }
}
