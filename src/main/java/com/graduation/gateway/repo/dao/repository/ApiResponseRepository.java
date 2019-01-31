package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ApiResponsePO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ApiResponseRepository extends JpaRepository<ApiResponsePO,String > {

  @Query( "select o from ApiResponsePO o where apiResourceDetailId in :ids" )
  public List<ApiResponsePO> findAllByApiResourceDetailId(@Param("ids") List<String> apiResourceDetailIds);

  public ApiResponsePO findApiResponsePOByApiResourceDetailId(String apiResourceId);

  public List<ApiResponsePO> findApiResponsePOSByApiResourceDetailId(String apiResourceId);
}
