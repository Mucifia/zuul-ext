package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.UserServicePlanPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface UserServicePlanRepository extends JpaRepository<UserServicePlanPO,String> {

  public UserServicePlanPO findUserServicePlanPOByServicePlanId(String servicePlanId);
}
