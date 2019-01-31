package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ApiParamPO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ApiParamRepository extends JpaRepository<ApiParamPO,String> {

  public ApiParamPO findApiParamPOByName(String name);

  @Query( "select o from ApiParamPO o where apiResourceDetailId in :ids" )
  public List<ApiParamPO> findAllByApiResourceDetailId(@Param("ids") List<String> apiResourceDetailIds);

  public List<ApiParamPO> findALlByApiResourceDetailId(String apiResourceDetailId);
}
