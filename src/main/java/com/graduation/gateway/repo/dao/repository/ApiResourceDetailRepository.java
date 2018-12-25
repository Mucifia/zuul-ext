package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ApiResourceDetailPO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ApiResourceDetailRepository extends JpaRepository<ApiResourceDetailPO,String> {
  @Query( "select o from ApiResourceDetailPO o where apiResourceId in :ids" )
  public List<ApiResourceDetailPO> findAllByApiResourceDetailIdIn(@Param("ids") List<String> ids);

  public ApiResourceDetailPO findApiResourceDetailPOByApiResourceId(String apiResourceId);



}
