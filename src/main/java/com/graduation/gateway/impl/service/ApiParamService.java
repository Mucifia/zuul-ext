package com.graduation.gateway.impl.service;

import com.graduation.gateway.api.model.ApiParamVO;
import com.graduation.gateway.impl.utils.BeanTransformer;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.graduation.gateway.repo.dao.model.ApiParamPO;
import com.graduation.gateway.repo.dao.repository.ApiParamRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
@Service
public class ApiParamService {

  @Autowired
  ApiParamRepository apiParamRepository;

  public void updateDelFlagByApiId(List<String> apiResourceDetailIds){
    List<ApiParamPO> apiParamPOS = apiParamRepository.findAllByApiResourceDetailId(apiResourceDetailIds);
    apiParamPOS.stream().forEach(apiParamPO -> {
      apiParamPO.setDelFlag(GatewayImplConstants.DELETE_FLAG_TRUE);
    });
    apiParamRepository.save(apiParamPOS);
  }

  public void save(ApiParamVO apiParamVO){
    apiParamRepository.save(BeanTransformer.convert(apiParamVO,ApiParamPO.class));
  }

  public void save(List<ApiParamVO> apiParamVOS){
    List<ApiParamPO> apiParamPOS = apiParamVOS.stream().map(apiParamVO -> {
      return BeanTransformer.convert(apiParamVO,ApiParamPO.class);
    }).collect(Collectors.toList());
    apiParamRepository.save(apiParamPOS);
  }

  public List<ApiParamVO> getApiParamsByDetailId(String resourceDetailId){
    List<ApiParamPO> apiParamPOS = apiParamRepository.findALlByApiResourceDetailId(resourceDetailId);
    return  apiParamPOS.stream().map(apiParamPO -> {
      ApiParamVO apiParamVO =  BeanTransformer.convert(apiParamPO,ApiParamVO.class);
      apiParamVO.setKey(apiParamVO.getApiParamId());
      return apiParamVO;
    }).collect(Collectors.toList());
  }

}
