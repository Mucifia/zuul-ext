package com.graduation.gateway.impl.service;


import com.graduation.gateway.api.model.ServiceLoadBalancerVO;
import com.graduation.gateway.api.model.ServicePlanVO;
import com.graduation.gateway.impl.utils.BeanTransformer;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.graduation.gateway.repo.dao.model.ServicePlanPO;
import com.graduation.gateway.repo.dao.repository.ServicePlanRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
@Service
public class ServicePlanService {

  @Autowired
  ServicePlanRepository servicePlanRepository;

  public void updateDelFlagById(String servicePlanId) {
    ServicePlanPO servicePlanPO = servicePlanRepository.findOne(servicePlanId);
    servicePlanPO.setDelFlag(GatewayImplConstants.DELETE_FLAG_TRUE);
    servicePlanRepository.save(servicePlanPO);
  }

  /**
   * 更新service plan 的名称、版本和描述
   */
  public void updatePlanBase(ServicePlanVO po) {
    ServicePlanPO servicePlanPO = BeanTransformer.convert(po, ServicePlanPO.class);
    servicePlanRepository.save(servicePlanPO);
  }

  public Map<String, ServicePlanVO> getAllServicePlanMapById() {
    List<ServicePlanPO> servicePlanPOS = servicePlanRepository.findAll();
    Map<String, ServicePlanVO> map = new HashMap<>();
    servicePlanPOS.stream().forEach(s -> {
      map.putIfAbsent(s.getServicePlanId(), BeanTransformer.convert(s, ServicePlanVO.class));
    });
    return map;
  }

  public ServicePlanVO getById(String servicePlanId) {
    ServicePlanPO servicePlanPO = servicePlanRepository.findOne(servicePlanId);
    return BeanTransformer.convert(servicePlanPO, ServicePlanVO.class);
  }

  public ServicePlanVO getByName(String name) {
    ServicePlanPO servicePlanPO = servicePlanRepository.findServicePlanPOByName(name);
    return BeanTransformer.convert(servicePlanPO, ServicePlanVO.class);
  }

  public ServicePlanPO save(ServicePlanVO servicePlanVO) {
    ServicePlanPO servicePlanPO = BeanTransformer.convert(servicePlanVO, ServicePlanPO.class);
    return servicePlanRepository.save(servicePlanPO);
  }

  public void save(List<ServicePlanVO> servicePlanVOS) {
    List<ServicePlanPO> servicePlanPOS = servicePlanVOS.stream().map(s -> {
      return BeanTransformer.convert(s, ServicePlanPO.class);
    }).collect(Collectors.toList());
    servicePlanRepository.save(servicePlanPOS);
  }

  public List<ServicePlanVO> getServicePlanVOByQualityId(String qualityId){
    return servicePlanRepository.findServicePlanPOSByServiceQualityId(qualityId).stream().map(servicePlanPO -> {
      return BeanTransformer.convert(servicePlanPO,ServicePlanVO.class);
    }).collect(Collectors.toList());
  }

  public List<ServicePlanVO> getAllServicePlans(){
    return servicePlanRepository.findALlByDelFlagIsFalse().stream().map(servicePlanPO -> {
     return BeanTransformer.convert(servicePlanPO,ServicePlanVO.class);
    }).collect(Collectors.toList());
  }


}
