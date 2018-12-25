package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ServiceQualityExtPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ServiceQualityExtRepository extends JpaRepository<ServiceQualityExtPO,String> {

  public ServiceQualityExtPO findServiceQualityExtPOByServiceQualityId(String serviceQualityId);
}
