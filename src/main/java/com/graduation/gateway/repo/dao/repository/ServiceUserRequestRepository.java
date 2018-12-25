package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ServiceUserRequestPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ServiceUserRequestRepository extends JpaRepository<ServiceUserRequestPO,String> {

  public ServiceUserRequestPO findServiceUserRequestPOByUserId(String userId);
}
