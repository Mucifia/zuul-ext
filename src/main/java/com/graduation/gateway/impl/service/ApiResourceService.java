package com.graduation.gateway.impl.service;

import com.graduation.gateway.api.model.ApiResourceVO;
import com.graduation.gateway.impl.utils.BeanTransformer;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.graduation.gateway.repo.dao.model.ApiResourcePO;
import com.graduation.gateway.repo.dao.repository.ApiResourceRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: mmy
 * @date: 2018/12/18
 * @description:
 */
@Service
public class ApiResourceService {

  @Autowired
  ApiResourceRepository apiResourceRepository;

  public void updateDelFlagById(String resourceId) {
    ApiResourcePO apiResourcePO = apiResourceRepository.findOne(resourceId);
    apiResourcePO.setDelFlag(GatewayImplConstants.DELETE_FLAG_TRUE);
    apiResourceRepository.save(apiResourcePO);
  }

  public List<String> updateDelFlagByApiIdAndGetApiResourceIds(String apiId) {
    List<ApiResourcePO> apiResourcePOS = apiResourceRepository.findAllByApiId(apiId);
    List<String> apiResourceIds = new ArrayList<>();
    apiResourcePOS.stream().forEach(apiResourcePO -> {
      apiResourcePO.setDelFlag(GatewayImplConstants.DELETE_FLAG_TRUE);
      apiResourceIds.add(apiResourcePO.getApiResourceId());
    });
    apiResourceRepository.save(apiResourcePOS);
    return apiResourceIds;
  }

  public List<ApiResourceVO> getAllResources() {
    List<ApiResourcePO> apiResourcePOList = apiResourceRepository.findAll();
    return apiResourcePOList.stream().map(t -> {
      return BeanTransformer.convert(t, ApiResourceVO.class);
    }).collect(Collectors.toList());
  }

  public List<ApiResourceVO> getResByApiId(String apiId) {
    List<ApiResourcePO> apiResourcePOList = apiResourceRepository.findAllByApiId(apiId);
    return apiResourcePOList.stream().map(t ->{
      return BeanTransformer.convert(t,ApiResourceVO.class);
    }).collect(Collectors.toList());
  }

  public ApiResourcePO save(ApiResourceVO apiResourceVO){
    return apiResourceRepository.save(BeanTransformer.convert(apiResourceVO,ApiResourcePO.class));
  }

  public ApiResourceVO getApiResourceByApiId(String apiId){
    return BeanTransformer.convert(apiResourceRepository.findApiResourcePOByApiId(apiId),ApiResourceVO.class);
  }



}
