package com.graduation.gateway.service;

import com.graduation.gateway.api.model.ApiBaseVO;
import com.graduation.gateway.api.model.ApiParamVO;
import com.graduation.gateway.api.model.ApiResourceDetailVO;
import com.graduation.gateway.api.model.ApiResourceVO;
import com.graduation.gateway.api.model.ApiResponseVO;
import com.graduation.gateway.api.model.ApiTransformVO;
import com.graduation.gateway.api.model.ServicePlanVO;
import com.graduation.gateway.impl.service.ApiBaseService;
import com.graduation.gateway.impl.service.ApiParamService;
import com.graduation.gateway.impl.service.ApiResourceDetailService;
import com.graduation.gateway.impl.service.ApiResourceService;
import com.graduation.gateway.impl.service.ApiResponseService;
import com.graduation.gateway.impl.service.ApiTransformService;
import com.graduation.gateway.impl.service.ServicePlanApiRelationService;
import com.graduation.gateway.impl.service.ServicePlanService;
import com.graduation.gateway.repo.dao.model.ServicePlanApiRelationPO;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: mmy
 * @date: 2018/12/20
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@EnableJpaAuditing
public class ApiBaseTest {

  @Autowired
  ApiBaseService apiBaseService;

  @Autowired
  ApiResourceService apiResourceService;

  @Autowired
  ApiResourceDetailService apiResourceDetailService;

  @Autowired
  ApiResponseService apiResponseService;

  @Autowired
  ApiParamService apiParamService;

  @Autowired
  ApiTransformService apiTransformService;

  @Autowired
  ServicePlanService servicePlanService;

  @Autowired
  ServicePlanApiRelationService servicePlanApiRelationService;


  private static ApiBaseVO apiBaseVO;

  private static ServicePlanVO servicePlanVO;

  @BeforeClass
  public static void init() {

  }

  @Test
  public void CreateTest() {
    servicePlanVO = new ServicePlanVO();
    servicePlanVO.setServiceQualityId("11");
    servicePlanVO.setDescription("des");
    servicePlanVO.setName("test-case");
    servicePlanVO.setStatus("!1");
    servicePlanVO.setCommitBy("11");
    servicePlanVO.setEnable(true);
    servicePlanVO.setImgSrc("!1");
    servicePlanVO.setNeedReview(true);
    servicePlanVO.setSecurity("11");
    servicePlanVO.setStateId("11");
    servicePlanVO.setVersion("11");
    servicePlanService.save(servicePlanVO);
    for (int i = 0; i < 50; i++) {
      apiBaseVO = new ApiBaseVO();
      apiBaseVO.setBaseUri("1");
      apiBaseVO.setCorsId("1");
      apiBaseVO.setDescription("test-case");
      apiBaseVO.setEnable(true);
      apiBaseVO.setHost("127.0.0.1");
      apiBaseVO.setInboundType("s");
      apiBaseVO.setName("test-case");
      apiBaseVO.setOutboundType("s");
      apiBaseVO.setProtocal("s");
      apiBaseVO.setSecurity("ss");
      apiBaseVO.setStateId("s");
      apiBaseVO.setVersion("1");
      apiBaseVO.setName(String.format("%s%d", "test-case", i));
      apiBaseService.save(apiBaseVO);
      servicePlanApiRelationService.save(
          new ServicePlanApiRelationPO(apiBaseService.findByName(apiBaseVO.getName()).getApiId(),
              servicePlanService.getByName("test-case").getServicePlanId()));
    }
  }

  @Test
  public void DeleteTest() {
    String apiId = apiBaseService.findByName("test-case1").getApiId();
    ApiResourceVO apiResourceVO = new ApiResourceVO();
    apiResourceVO.setApiId(apiId);
    apiResourceVO.setDescription("des");
    apiResourceVO.setPathName("111");
    apiResourceVO.setServiceId("11");
    apiResourceVO.setTargetUri("aaa");
    apiResourceService.save(apiResourceVO);

    apiResourceVO = new ApiResourceVO();
    apiResourceVO.setApiId(apiId);
    apiResourceVO.setDescription("des");
    apiResourceVO.setPathName("111");
    apiResourceVO.setServiceId("11");
    apiResourceVO.setTargetUri("aaa");
    apiResourceService.save(apiResourceVO);

    List<String> apiResourceIds = apiResourceService.getResByApiId(apiId).stream().map(a -> {
      return a.getApiResourceId();
    }).collect(Collectors.toList());

    for (String apiResourceId : apiResourceIds) {
      for (int i = 0; i < 2; i++) {
        ApiResourceDetailVO apiResourceDetailVO = new ApiResourceDetailVO();
        apiResourceDetailVO.setApiResourceId(apiResourceId);
        apiResourceDetailService.save(apiResourceDetailVO);
      }
    }

    List<String> apiResourceDetailIds = apiResourceDetailService
        .getResDetailByResIds(apiResourceIds).stream().map(a -> {
          return a.getApiResourceDetailId();
        }).collect(Collectors.toList());

    for (String apiResourceDetailId : apiResourceDetailIds) {
      for (int i = 0; i < 2; i++) {
        ApiResponseVO apiResponseVO = new ApiResponseVO();
        apiResponseVO.setApiResourceDetailId(apiResourceDetailId);
        ApiTransformVO apiTransformVO = new ApiTransformVO();
        apiTransformVO.setApiResourceDetailId(apiResourceDetailId);
        ApiParamVO apiParamVO = new ApiParamVO();
        apiParamVO.setApiResourceDetailId(apiResourceDetailId);
        apiParamVO.setName("test-case");
        apiResponseService.save(apiResponseVO);
        apiTransformService.save(apiTransformVO);
        apiParamService.save(apiParamVO);
      }
    }

    apiBaseService.deleteByApiId(apiId);
  }

  @Test
  public void getApiByServicePlanName() {
    List<ApiBaseVO> apiBaseVOList = apiBaseService.getApiByServicePlanName("test-case");
    apiBaseVOList = apiBaseService.getApiByServicePlanName("test-case", 0, 10);
    apiBaseVOList = apiBaseService.getApiByServicePlanName("test-case", 1, 10);
    apiBaseVOList = apiBaseService.getApiByServicePlanName("test-case", 2, 10);
    apiBaseVOList = apiBaseService.getApiByServicePlanName("test-case", 3, 10);
    apiBaseVOList = apiBaseService.getApiByServicePlanName("test-case", 4, 10);
  }

}