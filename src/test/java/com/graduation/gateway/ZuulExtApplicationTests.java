package com.graduation.gateway;

import com.graduation.gateway.repo.dao.model.ApiBasePO;
import com.graduation.gateway.repo.dao.model.ApiModelDetailPO;
import com.graduation.gateway.repo.dao.model.ApiModelPO;
import com.graduation.gateway.repo.dao.model.ApiParamPO;
import com.graduation.gateway.repo.dao.model.ApiResourceDetailPO;
import com.graduation.gateway.repo.dao.model.ApiResourcePO;
import com.graduation.gateway.repo.dao.model.ApiResponsePO;
import com.graduation.gateway.repo.dao.model.ApiTransformPO;
import com.graduation.gateway.repo.dao.model.CorsConfigPO;
import com.graduation.gateway.repo.dao.model.OperationHistoryPO;
import com.graduation.gateway.repo.dao.model.RoutePO;
import com.graduation.gateway.repo.dao.model.ServiceLoadBalancerPO;
import com.graduation.gateway.repo.dao.model.ServicePlanPO;
import com.graduation.gateway.repo.dao.model.ServicePublishRequestPO;
import com.graduation.gateway.repo.dao.model.ServiceQualityExtPO;
import com.graduation.gateway.repo.dao.model.ServiceQualityPO;
import com.graduation.gateway.repo.dao.model.ServiceUserRequestPO;
import com.graduation.gateway.repo.dao.model.UserServicePlanPO;
import com.graduation.gateway.repo.dao.repository.ApiBaseRepository;
import com.graduation.gateway.repo.dao.repository.ApiModelDetailRepository;
import com.graduation.gateway.repo.dao.repository.ApiModelRepository;
import com.graduation.gateway.repo.dao.repository.ApiParamRepository;
import com.graduation.gateway.repo.dao.repository.ApiResourceDetailRepository;
import com.graduation.gateway.repo.dao.repository.ApiResourceRepository;
import com.graduation.gateway.repo.dao.repository.ApiResponseRepository;
import com.graduation.gateway.repo.dao.repository.ApiTransformRepository;
import com.graduation.gateway.repo.dao.repository.CorsConfigRepository;
import com.graduation.gateway.repo.dao.repository.OperationHistoryRepository;
import com.graduation.gateway.repo.dao.repository.RouteRepository;
import com.graduation.gateway.repo.dao.repository.ServiceLoadBalancerRepository;
import com.graduation.gateway.repo.dao.repository.ServicePlanRepository;
import com.graduation.gateway.repo.dao.repository.ServicePublishRequestRepository;
import com.graduation.gateway.repo.dao.repository.ServiceQualityExtRepository;
import com.graduation.gateway.repo.dao.repository.ServiceQualityRepository;
import com.graduation.gateway.repo.dao.repository.ServiceUserRequestRepository;
import com.graduation.gateway.repo.dao.repository.UserServicePlanRepository;
import java.util.Set;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaAuditing
public class ZuulExtApplicationTests {

  @Autowired
  ApiBaseRepository apiBaseRepository;
  @Autowired
  ApiModelDetailRepository apiModelDetailRepository;
  @Autowired
  ApiModelRepository apiModelRepository;
  @Autowired
  ApiParamRepository apiParamRepository;
  @Autowired
  ApiResourceDetailRepository apiResourceDetailRepository;
  @Autowired
  ApiResourceRepository apiResourceRepository;
  @Autowired
  ApiResponseRepository apiResponseRepository;
  @Autowired
  ApiTransformRepository apiTransformRepository;
  @Autowired
  CorsConfigRepository corsConfigRepository;
  @Autowired
  OperationHistoryRepository operationHistoryRepository;
  @Autowired
  RouteRepository routeRepository;
  @Autowired
  ServiceLoadBalancerRepository serviceLoadBalancerRepository;
  @Autowired
  ServicePlanRepository servicePlanRepository;
  @Autowired
  ServicePublishRequestRepository servicePublishRequestRepository;
  @Autowired
  ServiceQualityRepository serviceQualityRepository;
  @Autowired
  ServiceQualityExtRepository serviceQualityExtRepository;
  @Autowired
  ServiceUserRequestRepository serviceUserRequestRepository;
  @Autowired
  UserServicePlanRepository userServicePlanRepository;


  private static ApiBasePO apiBasePO;
  private static ApiModelDetailPO apiModelDetailPO;
  private static ApiModelPO apiModelPO;
  private static ApiParamPO apiParamPO;
  private static ApiResourceDetailPO apiResourceDetailPO;
  private static ApiResourcePO apiResourcePO;
  private static ApiResponsePO apiResponsePO;
  private static ApiTransformPO apiTransformPO;
  private static CorsConfigPO corsConfigPO;
  private static OperationHistoryPO operationHistoryPO;
  private static RoutePO routePO;
  private static ServiceLoadBalancerPO serviceLoadBalancerPO;
  private static ServicePlanPO servicePlanPO;
  private static ServicePublishRequestPO servicePublishRequestPO;
  private static ServiceQualityPO serviceQualityPO;
  private static ServiceQualityExtPO serviceQualityExtPO;
  private static ServiceUserRequestPO serviceUserRequestPO;
  private static UserServicePlanPO userServicePlanPO;

  @BeforeClass
  public static void beforeClassInit() {

    //apibase test-case init
    apiBasePO = new ApiBasePO();
    apiBasePO.setBaseUri("1");
    apiBasePO.setCorsId("1");
    apiBasePO.setDescription("test-case");
    apiBasePO.setEnable(true);
    apiBasePO.setHost("127.0.0.1");
    apiBasePO.setInboundType("s");
    apiBasePO.setName("test-case");
    apiBasePO.setOutboundType("s");
    apiBasePO.setProtocal("s");
    apiBasePO.setSecurity("ss");
    apiBasePO.setStateId("s");
    apiBasePO.setVersion("1");

    //apiModelDetail test-case init
    apiModelDetailPO = new ApiModelDetailPO();
    apiModelDetailPO.setApiModelId("1");
    apiModelDetailPO.setDescription("des");
    apiModelDetailPO.setModelDetailType("1");
    apiModelDetailPO.setName("test-case");
    apiModelDetailPO.setRefModelId("1");
    apiModelDetailPO.setRequried(true);

    //apiModelPO test-case init
    apiModelPO = new ApiModelPO();
    apiModelPO.setName("test-case");

    //apiParamPO test-case init
    apiParamPO = new ApiParamPO();
    apiParamPO.setApiResourceDetailId("1");
    apiParamPO.setDescription("des");
    apiParamPO.setName("test-case");
    apiParamPO.setParamsType("1");
    apiParamPO.setRequired(true);
    apiParamPO.setStyle("1");
    apiParamPO.setValue("1");

    //apiResourceDetailPO test-case init
    apiResourceDetailPO = new ApiResourceDetailPO();
    apiResourceDetailPO.setApiResourceId("1");
    apiResourceDetailPO.setConnectionTimeout(100);
    apiResourceDetailPO.setIgnoredHeaders("ss");
    apiResourceDetailPO.setInboundType("ss");
    apiResourceDetailPO.setMaxAutoRetries(11);
    apiResourceDetailPO.setMethod("11");
    apiResourceDetailPO.setOperationId("11");
    apiResourceDetailPO.setOutboundType("11");
    apiResourceDetailPO.setPerserveHost(true);
    apiResourceDetailPO.setRetryable(true);
    apiResourceDetailPO.setReadTimeout(11);
    apiResourceDetailPO.setSensitiveHeaders("!1");
    apiResourceDetailPO.setServiceID("11");
    apiResourceDetailPO.setStripPrefix(true);
    apiResourceDetailPO.setUrl("!111");

    //apiResourcePO test-case init;
    apiResourcePO = new ApiResourcePO();
    apiResourcePO.setApiId("1");
    apiResourcePO.setDescription("des");
    apiResourcePO.setPathName("111");
    apiResourcePO.setServiceId("11");
    apiResourcePO.setTargetUri("aaa");

    //apiResponsePO test-case init;
    apiResponsePO = new ApiResponsePO();
    apiResponsePO.setApiResponseDetailId("11");
    apiResponsePO.setDescription("des");
    apiResponsePO.setResponseType("11");
    apiResponsePO.setStatus(1);
    apiResponsePO.setValue("11");
    apiResponsePO.setApiResourceDetailId("1");

    //apiTransformPO test-case init;
    apiTransformPO = new ApiTransformPO();
    apiTransformPO.setValue("11");
    apiTransformPO.setAction("11");
    apiTransformPO.setApiResourceDetailId("11");
    apiTransformPO.setCode("11");
    apiTransformPO.setMessageType("!1");
    apiTransformPO.setSeq(1);
    apiTransformPO.setStyle("!1");

    //corsConfigPO test-case init;
    corsConfigPO = new CorsConfigPO();
    corsConfigPO.setStyle("11");
    corsConfigPO.setSeq(1);
    corsConfigPO.setMessageType("11");
    corsConfigPO.setCode("11");
    corsConfigPO.setAction("11");
    corsConfigPO.setValue("！1");

    //operationHistoryPO test-case init;
    operationHistoryPO = new OperationHistoryPO();
    operationHistoryPO.setNewValue("11");
    operationHistoryPO.setOldValue("!1");
    operationHistoryPO.setOperationBy("11");
    operationHistoryPO.setOperationFieldName("11");
    operationHistoryPO.setOperationPk("11");
    operationHistoryPO.setOperationTargetName("!1");
    operationHistoryPO.setOperationType("11");

    //routePO test-case init;
    routePO = new RoutePO();
    routePO.setPath("11");
    routePO.setQualityEnabled(true);
    routePO.setRouteType("!1");
    routePO.setServicePlanId("11");
    routePO.setStripPrefix(true);
    routePO.setTargetServiceId("!1");
    routePO.setTargetUri("11");

    //serviceLoadBalancerPO test-case init;
    serviceLoadBalancerPO = new ServiceLoadBalancerPO();
    serviceLoadBalancerPO.setDescription("des");
    serviceLoadBalancerPO.setClassName("11");
    serviceLoadBalancerPO.setName("test-case");
    serviceLoadBalancerPO.setServiceQualityId("!1");

    //servicePlanPO test-case init;
    servicePlanPO = new ServicePlanPO();
    servicePlanPO.setServiceQualityId("11");
    servicePlanPO.setName("test-case");
    servicePlanPO.setDescription("des");
    servicePlanPO.setStatus("!1");
    servicePlanPO.setAuth_type("11");
    servicePlanPO.setCommitBy("11");
    servicePlanPO.setDomainCode("!1");
    servicePlanPO.setDomainId("11");
    servicePlanPO.setEnable(true);
    servicePlanPO.setImgSrc("!1");
    servicePlanPO.setNeedReview(true);
    servicePlanPO.setSecurity("11");
    servicePlanPO.setStateId("11");
    servicePlanPO.setVersion("11");

    //servicePublishRequestPO test-case init;
    servicePublishRequestPO = new ServicePublishRequestPO();
    servicePublishRequestPO.setStatus("11");
    servicePublishRequestPO.setServicePlanId("11");
    servicePublishRequestPO.setServicePlanName("11");
    servicePublishRequestPO.setServicePlanStatus("11");
    servicePublishRequestPO.setServicePlanVersion("!1");

    //serviceQualityPO test-case init;
    serviceQualityPO = new ServiceQualityPO();
    serviceQualityPO.setServicePlanId("!1");
    serviceQualityPO.setRouteId("11");
    serviceQualityPO.setCbEnable(true);
    serviceQualityPO.setCbErrorPercentage("11");
    serviceQualityPO.setCbRecoverTime(11);
    serviceQualityPO.setCbRequestVolumeThreshold("11");
    serviceQualityPO.setMaxConcurrency("11");
    serviceQualityPO.setRefreshInterval("11");
    serviceQualityPO.setRequestLimit("!1");
    serviceQualityPO.setRequestLimitQuota("11");
    serviceQualityPO.setRequestLimitType("11");
    serviceQualityPO.setRequestTimeout(11);
    serviceQualityPO.setRollingStatsTime(11);

    //serviceQualityExtPO test-case init;
    serviceQualityExtPO = new ServiceQualityExtPO();
    serviceQualityExtPO.setDescription("des");
    serviceQualityExtPO.setDisplayName("test-case");
    serviceQualityExtPO.setExtKey("11");
    serviceQualityExtPO.setExtValue("!1");
    serviceQualityExtPO.setMaxValue("11");
    serviceQualityExtPO.setMinValue("11");
    serviceQualityExtPO.setServiceQualityId("11");
    serviceQualityExtPO.setTimeUnits("11");

    //serviceUserRequestPO test-case init;
    serviceUserRequestPO = new ServiceUserRequestPO();
    serviceUserRequestPO.setServicePlanId("!1");
    serviceUserRequestPO.setServicePlanVersion("!1");
    serviceUserRequestPO.setServicePlanName("!1");
    serviceUserRequestPO.setStatus("11");
    serviceUserRequestPO.setAccessScope("!1");
    serviceUserRequestPO.setUserId("!1");

    //userServicePlanPO test-case init;
    userServicePlanPO = new UserServicePlanPO();
    userServicePlanPO.setAccessScope("!1");
    userServicePlanPO.setClientId("!1");
    userServicePlanPO.setServicePlanId("!1");
    userServicePlanPO.setServicePlanName("!1");
    userServicePlanPO.setServicePlanVersion("!1");
    userServicePlanPO.setStatus("!1");
    userServicePlanPO.setUserId("!1");

  }

  @Test
  public void ApiBaseTest() {
    apiBaseRepository.save(apiBasePO);
    ApiBasePO apiBase = apiBaseRepository.findApiBasePOByName("test-case");
    Assert.assertEquals(apiBase.getDescription(), "test-case");
    apiBasePO.setDelFlag(true);
    apiBaseRepository.save(apiBasePO);
    apiBase = apiBaseRepository.findApiBasePOByName("test-case");
    Assert.assertTrue(apiBase.isDelFlag());
  }

  @Test
  public void ApiModelDetailTest() {
    apiModelDetailRepository.save(apiModelDetailPO);
    ApiModelDetailPO apiModelDetail = apiModelDetailRepository
        .findApiModelDetailPoByName("test-case");
    Assert.assertEquals(apiModelDetail.getDescription(), "des");
    apiModelDetailPO.setDelFlag(true);
    apiModelDetailRepository.save(apiModelDetailPO);
    apiModelDetail = apiModelDetailRepository.findApiModelDetailPoByName("test-case");
    Assert.assertTrue(apiModelDetail.isDelFlag());
  }

  @Test
  public void ApiModelTest() {
    apiModelRepository.save(apiModelPO);
    ApiModelPO apimodel = apiModelRepository.findApiModelPOByName("test-case");
    Assert.assertFalse(apimodel.isDelFlag());
    apiModelPO.setDelFlag(true);
    apiModelRepository.save(apiModelPO);
    apimodel = apiModelRepository.findApiModelPOByName("test-case");
    Assert.assertTrue(apimodel.isDelFlag());
  }

  @Test
  public void ApiParamTest() {
    apiParamRepository.save(apiParamPO);
    ApiParamPO apiParam = apiParamRepository.findApiParamPOByName("test-case");
    Assert.assertEquals(apiParam.getDescription(), "des");
    apiParamPO.setDelFlag(true);
    apiParamRepository.save(apiParamPO);
    apiParam = apiParamRepository.findApiParamPOByName("test-case");
    Assert.assertTrue(apiParam.isDelFlag());
  }

  @Test
  public void ApiResourceDetailTest() {

    apiResourceDetailRepository.save(apiResourceDetailPO);
    ApiResourceDetailPO apiResourceDetail = apiResourceDetailRepository
        .findApiResourceDetailPOByApiResourceId("1");
    Assert.assertEquals(apiResourceDetail.getConnectionTimeout(), 100);
    apiResourceDetailPO.setDelFlag(true);
    apiResourceDetailRepository.save(apiResourceDetailPO);
    apiResourceDetail = apiResourceDetailRepository.findApiResourceDetailPOByApiResourceId("1");
    Assert.assertTrue(apiResourceDetail.isDelFlag());
  }

  @Test
  public void ApiResourceTest() {
    apiResourceRepository.save(apiResourcePO);
    ApiResourcePO apiResource = apiResourceRepository.findApiResourcePOByApiId("1");
    Assert.assertEquals(apiResource.getDescription(), "des");
    apiResourcePO.setDelFlag(true);
    apiResourceRepository.save(apiResourcePO);
    apiResource = apiResourceRepository.findApiResourcePOByApiId("1");
    Assert.assertTrue(apiResource.isDelFlag());
  }

  @Test
  public void ApiResponseTest() {
    apiResponseRepository.save(apiResponsePO);
    ApiResponsePO apiResponse = apiResponseRepository.findApiResponsePOByApiResourceDetailId("1");
    Assert.assertEquals(apiResponse.getDescription(), "des");
    apiResponsePO.setDelFlag(true);
    apiResponseRepository.save(apiResponsePO);
    apiResponse = apiResponseRepository.findApiResponsePOByApiResourceDetailId("1");
    Assert.assertTrue(apiResponse.isDelFlag());
  }

  @Test
  public void ApiTransformTest() {
    apiTransformRepository.save(apiTransformPO);
    ApiTransformPO apiTransform = apiTransformRepository
        .findApiTransformPOByApiResourceDetailId("11");
    Assert.assertEquals(apiTransform.getCode(), "11");
    apiTransformPO.setDelFlag(true);
    apiTransformRepository.save(apiTransformPO);
    apiTransform = apiTransformRepository.findApiTransformPOByApiResourceDetailId("11");
    Assert.assertTrue(apiTransform.isDelFlag());
  }

  @Test
  public void CorsConfigTest() {
    corsConfigRepository.save(corsConfigPO);
    CorsConfigPO corsConfig = corsConfigRepository.findCorsConfigPOByCode("11");
    Assert.assertEquals(corsConfig.getAction(), "11");
    corsConfigPO.setDelFlag(true);
    corsConfigRepository.save(corsConfigPO);
    corsConfig = corsConfigRepository.findCorsConfigPOByCode("11");
    Assert.assertTrue(corsConfig.isDelFlag());
  }

  @Test
  public void OperationHistoryTest() {
    operationHistoryRepository.save(operationHistoryPO);
    OperationHistoryPO operationHistory = operationHistoryRepository
        .findOperationHistoryPOByOperationType("11");
    Assert.assertEquals(operationHistory.getOperationBy(), "11");
    operationHistoryPO.setOperationBy("22");
    operationHistoryRepository.save(operationHistoryPO);
    operationHistory = operationHistoryRepository.findOperationHistoryPOByOperationType("11");
    Assert.assertEquals(operationHistory.getOperationBy(), "22");
  }

  @Test
  public void RouteTest() {
  }

  @Test
  public void ServiceLoadBalancerTest() {
    serviceLoadBalancerRepository.save(serviceLoadBalancerPO);
    ServiceLoadBalancerPO serviceLoadBalancer = serviceLoadBalancerRepository
        .findServiceLoadBalancerPOByName("test-case");
    Assert.assertEquals(serviceLoadBalancer.getDescription(), "des");
    serviceLoadBalancerPO.setDelFlag(true);
    serviceLoadBalancerRepository.save(serviceLoadBalancerPO);
    serviceLoadBalancer = serviceLoadBalancerRepository
        .findServiceLoadBalancerPOByName("test-case");
    Assert.assertTrue(serviceLoadBalancer.isDelFlag());
  }

  @Test
  public void ServicePlanApiRelationTest() {

  }

  @Test
  @Transactional
  public void ServicePlanTest() {
  }

  @Test
  public void ServicePublishRequestTest() {
    servicePublishRequestRepository.save(servicePublishRequestPO);
    ServicePublishRequestPO servicePublishRequest = servicePublishRequestRepository
        .findServicePublishRequestPOByServicePlanId("11");
    Assert.assertEquals(servicePublishRequest.getServicePlanName(), "11");
    servicePublishRequestPO.setDelFlag(true);
    servicePublishRequestRepository.save(servicePublishRequestPO);
    servicePublishRequest = servicePublishRequestRepository
        .findServicePublishRequestPOByServicePlanId("11");
    Assert.assertTrue(servicePublishRequest.isDelFlag());
  }

//  @Test
//  public void ServiceQualityTest() {
//    serviceQualityRepository.save(serviceQualityPO);
//    ServiceQualityPO serviceQuality = serviceQualityRepository.findServiceQualityPOByServicePlanId("!1");
//    Assert.assertEquals(serviceQuality.getRouteId(), "11");
//    serviceQualityPO.setRouteId("22");
//    serviceQualityRepository.save(serviceQualityPO);
//    serviceQuality = serviceQualityRepository.findServiceQualityPOByServicePlanId("!1");
//    Assert.assertEquals(serviceQuality.getRouteId(), "22");
//  }

  @Test
  public void ServiceQualityExtTest() {
    serviceQualityExtRepository.save(serviceQualityExtPO);
    ServiceQualityExtPO serviceQualityExt = serviceQualityExtRepository
        .findServiceQualityExtPOByServiceQualityId("11");
    Assert.assertEquals(serviceQualityExt.getDescription(), "des");
    serviceQualityExtPO.setDescription("des1");
    serviceQualityExtRepository.save(serviceQualityExtPO);
    serviceQualityExt = serviceQualityExtRepository.findServiceQualityExtPOByServiceQualityId("11");
    Assert.assertEquals(serviceQualityExt.getDescription(), "des1");
  }

  @Test
  public void ServiceUserRequestTest() {
    serviceUserRequestRepository.save(serviceUserRequestPO);
    ServiceUserRequestPO serviceUserRequest = serviceUserRequestRepository
        .findServiceUserRequestPOByUserId("!1");
    Assert.assertEquals(serviceUserRequest.getServicePlanName(), "!1");
    serviceUserRequestPO.setDelFlag(true);
    serviceUserRequestRepository.save(serviceUserRequestPO);
    serviceUserRequest = serviceUserRequestRepository.findServiceUserRequestPOByUserId("!1");
    Assert.assertTrue(serviceUserRequest.isDelFlag());
  }

  @Test
  public void UserServicePlan() {
    userServicePlanRepository.save(userServicePlanPO);
    UserServicePlanPO userServicePlan = userServicePlanRepository
        .findUserServicePlanPOByServicePlanId("!1");
    Assert.assertEquals(userServicePlan.getAccessScope(), "!1");
    userServicePlanPO.setDelFlag(true);
    userServicePlanRepository.save(userServicePlanPO);
    userServicePlan = userServicePlanRepository.findUserServicePlanPOByServicePlanId("!1");
    Assert.assertTrue(userServicePlan.isDelFlag());
  }
}
