package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ApiResourcePO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ApiResourceRepository  extends JpaRepository<ApiResourcePO,String> {

  public List<ApiResourcePO> findAllByApiId(String apiId);

  public ApiResourcePO findApiResourcePOByApiId(String apiId);

}
