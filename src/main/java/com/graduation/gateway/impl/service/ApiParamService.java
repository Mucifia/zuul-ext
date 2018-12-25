package com.graduation.gateway.impl.service;

import com.graduation.gateway.api.model.ApiParamVO;
import com.graduation.gateway.impl.utils.BeanTransformer;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.graduation.gateway.repo.dao.model.ApiParamPO;
import com.graduation.gateway.repo.dao.repository.ApiParamRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

}
