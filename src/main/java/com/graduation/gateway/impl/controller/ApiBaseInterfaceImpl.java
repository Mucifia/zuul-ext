package com.graduation.gateway.impl.controller;

import com.google.common.base.Splitter;
import com.graduation.gateway.api.exception.GatewayServiceException;
import com.graduation.gateway.api.model.ApiBaseVO;
import com.graduation.gateway.api.model.ApiParamVO;
import com.graduation.gateway.api.model.ApiResourceDetailVO;
import com.graduation.gateway.api.model.ApiResourceVO;
import com.graduation.gateway.api.model.ApiResponseVO;
import com.graduation.gateway.api.model.ApiTransformVO;
import com.graduation.gateway.api.service.ApiBaseInterface;
import com.graduation.gateway.api.util.InterfaceConstrants;
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

  private final Splitter splitter = Splitter.on(InterfaceConstrants.STRING_SEPARATE_COMMA)
      .omitEmptyStrings();


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
    ApiBaseVO apiBaseVO = apiBaseService.getApiBaseByApiId(apiId);
    ApiResourceVO apiResourceVO = apiResourceService.getApiResourceByApiId(apiId);
    ApiResourceDetailVO apiResourceDetailVO = apiResourceDetailService.getApiResourceDetailByResourceID(apiResourceVO.getApiResourceId());
    List<ApiParamVO> apiParamVOS = apiParamService.getApiParamsByDetailId(apiResourceDetailVO.getApiResourceDetailId());
    List<ApiTransformVO> apiTransformVOS = apiTransformService.getApiTransformsByApiResourceDetailId(apiResourceDetailVO.getApiResourceDetailId());
    List<ApiResponseVO> apiResponseVOS = apiResponseService.getApiResponsesByApiResourceDetailId(apiResourceDetailVO.getApiResourceDetailId());
    apiResourceDetailVO.setApiParamVOS(apiParamVOS);
    apiResourceDetailVO.setApiTransformVOS(apiTransformVOS);
    apiResourceDetailVO.setApiResponseVOS(apiResponseVOS);
    apiResourceVO.setApiResourceDetailVO(apiResourceDetailVO);
    apiBaseVO.setApiResourceVO(apiResourceVO);
    return apiBaseVO;
  }

  @Override
  public List<ApiBaseVO> getApiBases() throws GatewayServiceException {
    List<ApiBaseVO> apiBaseVOS = apiBaseService.getAllApiBase();
    apiBaseVOS.stream().forEach( apiBaseVO -> {
      apiBaseVO.setKey(apiBaseVO.getApiId());
    });
    return apiBaseVOS;
  }

  @Override
  public void updateApiBase(@RequestBody  ApiBaseVO apiBaseVO) throws GatewayServiceException {
    //save apiBase
    String apiId = apiBaseService.save(apiBaseVO).getApiId();
    //save apiresource
    ApiResourceVO apiResourceVO = apiBaseVO.getApiResourceVO();
    apiResourceVO.setApiId(apiId);
    String apiResourceID = apiResourceService.getApiResourceByApiId(apiId).getApiResourceId();
    apiResourceVO.setApiResourceId(apiResourceID);
    apiResourceService.save(apiResourceVO);
    //save apiresourceDeteail
    ApiResourceDetailVO apiResourceDetailVO = apiResourceVO.getApiResourceDetailVO();
    apiResourceDetailVO.setApiResourceId(apiResourceID);
    String apiResourceDetailId = apiResourceDetailService.getApiResourceDetailByResourceID(apiResourceID).getApiResourceDetailId();
    apiResourceDetailVO.setApiResourceDetailId(apiResourceDetailId);
    apiResourceDetailService.save(apiResourceDetailVO);
    //save apiParams
    List<ApiParamVO> apiParamVOS = apiResourceDetailVO.getApiParamVOS();
    apiParamService.save(apiParamVOS);
    List<ApiTransformVO> apiTransformVOS = apiResourceDetailVO.getApiTransformVOS();
    apiTransformService.save(apiTransformVOS);
    List<ApiResponseVO> apiResponseVOS = apiResourceDetailVO.getApiResponseVOS();
    apiResponseService.save(apiResponseVOS);
  }

  @Override
  public void deleteApiBase(@PathVariable String apiId) throws GatewayServiceException {
    List<String> apiIds = splitter.splitToList(apiId);
    apiIds.stream().forEach(s -> {
      apiBaseService.deleteByApiId(s);
    });
  }
}
