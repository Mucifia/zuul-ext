package com.graduation.gateway.impl.service;

import com.graduation.gateway.api.model.ApiBaseVO;
import com.graduation.gateway.api.model.ServicePlanVO;
import com.graduation.gateway.impl.utils.BeanTransformer;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.graduation.gateway.repo.dao.model.ApiBasePO;
import com.graduation.gateway.repo.dao.repository.ApiBaseRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
@Service
public class ApiBaseService {

  private static final Logger logger = LoggerFactory.getLogger(ApiBaseService.class);


  @Autowired
  ApiBaseRepository apiBaseRepository;

  @Autowired
  ApiResourceDetailService apiResourceDetailService;

  @Autowired
  ApiResourceService apiResourceService;

  @Autowired
  ApiParamService apiParamService;

  @Autowired
  ApiResponseService apiResponseService;

  @Autowired
  ApiTransformService apiTransformService;

  @Autowired
  ServicePlanApiRelationService servicePlanApiRelationService;

  @Autowired
  ServicePlanService servicePlanService;
  /**
   * save entity
   * @param apiBaseVO
   */
  public void save(ApiBaseVO apiBaseVO){
    /// TODO: 2018-12-22 参数检验
    // name的检验，以及name的独立性
    ApiBasePO apiBasePO = BeanTransformer.convert(apiBaseVO,ApiBasePO.class);
    apiBaseRepository.save(apiBasePO);
  }
  /**
   * save entities
   * @param apiBaseVOS
   */
  public void save(List<ApiBaseVO> apiBaseVOS){
    /// TODO: 2018-12-22 参数检验
    // name的检验，以及name的独立性
    List<ApiBasePO> apiBasePOS = apiBaseVOS.stream().map(a->{
      return BeanTransformer.convert(a,ApiBasePO.class);
    }).collect(Collectors.toList());
    apiBaseRepository.save(apiBasePOS);
  }

  /**
   * find by api_name
   * @param name
   * @return
   */
  public ApiBaseVO findByName(String name){
    return BeanTransformer.convert(apiBaseRepository.findApiBasePOByName(name),ApiBaseVO.class);
  }

  /**
   * 根据Name对Api软删除
   */
  public void updateDelFlagByApiName(String name) {
    ApiBasePO apiBasePO = apiBaseRepository.findApiBasePOByName(name);
    apiBasePO.setDelFlag(GatewayImplConstants.DELETE_FLAG_TRUE);
    apiBaseRepository.save(apiBasePO);
  }

  /**
   * 根据apiId对Api软删除
   */
  public void updateDelFlagByApiId(String apiId) {
    ApiBasePO apiBasePO = apiBaseRepository.findOne(apiId);
    apiBasePO.setDelFlag(GatewayImplConstants.DELETE_FLAG_TRUE);
    apiBaseRepository.save(apiBasePO);
  }

  public void deleteByApiId(String apiId) {
    // api_base
    updateDelFlagByApiId(apiId);
    logger.info("ApiBaseDAO update api_base del_flag");

    // api_resource
    List<String> apiResourceIds = apiResourceService
        .updateDelFlagByApiIdAndGetApiResourceIds(apiId);
    logger.info("ApiBaseDAO update api_resource del_flag");

    // api_resource_detail
    List<String> apiResourceDetailIds = apiResourceDetailService
        .updateDelFlagByApiIdAndGetApiResourceDetailIds(apiResourceIds);
    logger.info("ApiBaseDAO update api_resource_detail del_flag");

    // api_response
    apiResponseService.updateDelFlagByApiId(apiResourceDetailIds);
    logger.info("ApiBaseDAO update api_response del_flag");

    //api_params
    apiParamService.updateDelFlagByApiId(apiResourceDetailIds);
    logger.info("ApiBaseDAO update api_param del_flag");

    //api_transform
    apiTransformService.updateDelFlagByApiId(apiResourceDetailIds);
    logger.info("ApiBaseDAO update api_transform del_flag");

    //servicePlanRelation
    servicePlanApiRelationService.deleteByApiId(apiId);
    logger.info("ApiBaseDAO delete servicePlanApiRelation");


  }


  public List<ApiBaseVO> getApiByServicePlanId(String servicePlanId, int pageIdex, int pageSize) {
    List<String> apiIds = servicePlanApiRelationService.getApiIdsByServiceId(servicePlanId,pageIdex,pageSize);
    return apiBaseRepository.findAll(apiIds).stream().map(apiBasePO -> {
      return BeanTransformer.convert(apiBasePO,ApiBaseVO.class);
    }).collect(Collectors.toList());
  }


  public List<ApiBaseVO> getApiByServicePlanId(String servicePlanId) {
    List<String> apiIds = servicePlanApiRelationService.getApiIdsByServiceId(servicePlanId);
    List<ApiBasePO> apiBasePOS = apiBaseRepository.findAll(apiIds);
    return apiBasePOS.stream().map(apiBasePO -> {
      return BeanTransformer.convert(apiBasePO, ApiBaseVO.class);
    }).collect(Collectors.toList());

  }

  public List<ApiBaseVO> getApiByServicePlanName(String name, int pageIdex, int pageSize) {
    String servicePlanId = servicePlanService.getByName(name).getServicePlanId();
    List<String> apiIds = servicePlanApiRelationService.getApiIdsByServiceId(servicePlanId,pageIdex,pageSize);
    return apiBaseRepository.findAll(apiIds).stream().map(apiBasePO -> {
      return BeanTransformer.convert(apiBasePO,ApiBaseVO.class);
    }).collect(Collectors.toList());
  }


  public List<ApiBaseVO> getApiByServicePlanName(String name) {

    ServicePlanVO servicePlanVO = servicePlanService.getByName(name);
    List<String> apiIds = servicePlanApiRelationService.getApiIdsByServiceId(servicePlanVO.getServicePlanId());
    List<ApiBasePO> apiBasePOS = apiBaseRepository.findAll(apiIds);
    return apiBasePOS.stream().map(apiBasePO -> {
      return BeanTransformer.convert(apiBasePO, ApiBaseVO.class);
    }).collect(Collectors.toList());
  }
}
