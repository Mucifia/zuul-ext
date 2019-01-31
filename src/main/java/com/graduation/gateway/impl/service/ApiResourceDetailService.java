package com.graduation.gateway.impl.service;

import com.graduation.gateway.api.model.ApiResourceDetailVO;
import com.graduation.gateway.impl.utils.BeanTransformer;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.graduation.gateway.repo.dao.model.ApiResourceDetailPO;
import com.graduation.gateway.repo.dao.repository.ApiResourceDetailRepository;
import com.graduation.gateway.repo.dao.repository.ApiResourceRepository;
import java.util.ArrayList;
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
public class ApiResourceDetailService {

  private static final Logger logger = LoggerFactory.getLogger(ApiResourceDetailService.class);

  @Autowired
  ApiResourceDetailRepository apiResourceDetailRepository;

  @Autowired
  ApiResourceRepository apiResourceRepository;

  public List<String> updateDelFlagByApiIdAndGetApiResourceDetailIds(List<String> apiResourceIds) {
    List<ApiResourceDetailPO> apiResourceDetailPOS = apiResourceDetailRepository
        .findAllByApiResourceDetailIdIn(apiResourceIds);
    List<String> apiResourceDetailIds = new ArrayList<>();
    apiResourceDetailPOS.stream().forEach(apiResourceDetailPO -> {
      apiResourceDetailPO.setDelFlag(GatewayImplConstants.DELETE_FLAG_TRUE);
      apiResourceDetailIds.add(apiResourceDetailPO.getApiResourceDetailId());
    });
    apiResourceDetailRepository.save(apiResourceDetailPOS);
    return apiResourceDetailIds;
  }

  public List<ApiResourceDetailVO> getResDetailByResIds(List<String> resIds) {

    List<ApiResourceDetailPO> apiResourceDetailPOList = apiResourceDetailRepository
        .findAllByApiResourceDetailIdIn(resIds);
    return  apiResourceDetailPOList.stream().map(t ->{
      return BeanTransformer.convert(t,ApiResourceDetailVO.class);
    }).collect(Collectors.toList());

  }

  public ApiResourceDetailPO save(ApiResourceDetailVO apiResourceDetailVO){
    return apiResourceDetailRepository.save(BeanTransformer.convert(apiResourceDetailVO,ApiResourceDetailPO.class));
  }
  public ApiResourceDetailVO getApiResourceDetailByResourceID(String resourceId){
    return BeanTransformer.convert(apiResourceDetailRepository.findApiResourceDetailPOByApiResourceId(resourceId),ApiResourceDetailVO.class);
  }

}
