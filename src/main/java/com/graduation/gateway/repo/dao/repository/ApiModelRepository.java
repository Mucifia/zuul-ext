package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ApiModelPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ApiModelRepository extends JpaRepository<ApiModelPO,String> {

  public ApiModelPO findApiModelPOByName(String name);

}
