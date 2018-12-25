package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ServicePublishRequestPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ServicePublishRequestRepository extends JpaRepository<ServicePublishRequestPO,String> {

  public ServicePublishRequestPO findServicePublishRequestPOByServicePlanId(String servicePlanId);
}
