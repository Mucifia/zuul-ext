package com.graduation.gateway.impl.service;

import com.graduation.gateway.repo.dao.model.ServicePlanApiRelationPO;
import com.graduation.gateway.repo.dao.model.ServicePlanPO;
import com.graduation.gateway.repo.dao.repository.ServicePlanApiRelationRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author: mmy
 * @date: 2018/12/22
 * @description:
 */
@Service
public class ServicePlanApiRelationService {

  @Autowired
  ServicePlanApiRelationRepository servicePlanApiRelationRepository;

  public List<String> getApiIdsByServiceId(String serviceId) {
    List<ServicePlanApiRelationPO> servicePlanApiRelationPOS = servicePlanApiRelationRepository
        .findAllByServiceplanId(serviceId);
    List<String> apiIds = servicePlanApiRelationPOS.stream().map(s -> {
      return s.getApiId();
    }).collect(Collectors.toList());
    return apiIds;
  }

  public List<String> getApiIdsByServiceId(String serviceId, int pageIndex, int pagesize) {
    Pageable pageable = new PageRequest(pageIndex, pagesize);
    return servicePlanApiRelationRepository.findAllByServiceplanId(serviceId, pageable).stream()
        .map(s -> {
          return s.getApiId();
        }).collect(Collectors.toList());
  }

  public void save(ServicePlanApiRelationPO servicePlanApiRelationPO) {
    servicePlanApiRelationRepository.save(servicePlanApiRelationPO);
  }

  public void delete(String id) {
    servicePlanApiRelationRepository.delete(id);
  }

  public void delete(List<ServicePlanApiRelationPO> servicePlanApiRelationPOS) {
    servicePlanApiRelationRepository.delete(servicePlanApiRelationPOS);
  }

  public void deleteByApiId(String apiId) {
    servicePlanApiRelationRepository.delete(servicePlanApiRelationRepository.findAllByApiId(apiId));
  }

  public void deleteByServiceplanId(String serviceplanId) {
    servicePlanApiRelationRepository.delete(servicePlanApiRelationRepository.findAllByServiceplanId(serviceplanId));
  }

  public List<ServicePlanApiRelationPO> findOneByApiId(String apiId) {
    return  servicePlanApiRelationRepository.findAllByApiId(apiId);
  }

  public ServicePlanApiRelationPO findByServicePlanIdandApiId(String servicePlanId,String apiId){
    return servicePlanApiRelationRepository.findServicePlanApiRelationPOByServiceplanIdAndApiId(servicePlanId,apiId);
  }
}
