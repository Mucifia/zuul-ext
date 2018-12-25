package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ApiModelDetailPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ApiModelDetailRepository extends JpaRepository<ApiModelDetailPO,String> {

  public ApiModelDetailPO findApiModelDetailPoByName(String name);
}
