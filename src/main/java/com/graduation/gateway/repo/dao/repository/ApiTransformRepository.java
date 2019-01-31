package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ApiTransformPO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ApiTransformRepository extends JpaRepository<ApiTransformPO,String> {


  @Query( "select o from ApiTransformPO o where apiResourceDetailId in :ids" )
  public List<ApiTransformPO> findAllByApiResourceDetailId(@Param("ids") List<String> apiResourceDetailId);

  public ApiTransformPO findApiTransformPOByApiResourceDetailId(String apiResourceId);

  public List<ApiTransformPO> findApiTransformPOSByApiResourceDetailId(String apiResourceDetailId);
}
