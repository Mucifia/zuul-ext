package com.graduation.gateway.impl.service;

import com.graduation.gateway.api.model.ApiTransformVO;
import com.graduation.gateway.impl.utils.BeanTransformer;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.graduation.gateway.repo.dao.model.ApiTransformPO;
import com.graduation.gateway.repo.dao.repository.ApiTransformRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
@Service
public class ApiTransformService {

  @Autowired
  ApiTransformRepository apiTransformRepository;

  public void updateDelFlagByApiId(List<String> apiResourceDetailIds){
    List<ApiTransformPO> apiTransformPOS = apiTransformRepository.findAllByApiResourceDetailId(apiResourceDetailIds);
    apiTransformPOS.stream().forEach(apiTransformPO -> {
      apiTransformPO.setDelFlag(GatewayImplConstants.DELETE_FLAG_TRUE);
    });
    apiTransformRepository.save(apiTransformPOS);
  }


  public void save(ApiTransformVO apiTransformVO){
    apiTransformRepository.save(BeanTransformer.convert(apiTransformVO,ApiTransformPO.class));
  }

  public void save(List<ApiTransformVO> apiTransformVOS){
    List<ApiTransformPO> apiTransformPOS = apiTransformVOS.stream().map(apiTransformVO -> {
      return BeanTransformer.convert(apiTransformVO,ApiTransformPO.class);
    }).collect(Collectors.toList());
    apiTransformRepository.save(apiTransformPOS);
  }
}
