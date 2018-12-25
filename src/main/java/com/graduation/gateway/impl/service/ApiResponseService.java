package com.graduation.gateway.impl.service;

import com.graduation.gateway.api.model.ApiResponseVO;
import com.graduation.gateway.impl.utils.BeanTransformer;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.graduation.gateway.repo.dao.model.ApiResponsePO;
import com.graduation.gateway.repo.dao.repository.ApiResponseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
@Service
public class ApiResponseService {

  @Autowired
  ApiResponseRepository apiResponseRepository;

  public void updateDelFlagByApiId(List<String> apiResourceDetailIds){
    List<ApiResponsePO> apiResponsePOS = apiResponseRepository.findAllByApiResourceDetailId(apiResourceDetailIds);
    apiResponsePOS.stream().forEach(apiResponsePO -> {
      apiResponsePO.setDelFlag(GatewayImplConstants.DELETE_FLAG_TRUE);
    });
    apiResponseRepository.save(apiResponsePOS);
  }

  public void save(ApiResponseVO apiResponseVO){
    apiResponseRepository.save(BeanTransformer.convert(apiResponseVO,ApiResponsePO.class));
  }
}
