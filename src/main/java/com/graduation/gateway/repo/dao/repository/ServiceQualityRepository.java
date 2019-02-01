package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ServiceQualityPO;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ServiceQualityRepository extends JpaRepository<ServiceQualityPO,String> {

  public List<ServiceQualityPO> findAllByServicePlanIdAndDelFlagIsFalse(String servicePlanId);



  @Query( "select o from ServiceQualityPO o where routeId in :ids and delFlag = 0" )
  public List<ServiceQualityPO> findAllByRouteIdAndDelFlag(@Param("ids") List<String> routeIds,
      Pageable pageable);

  public ServiceQualityPO findServiceQualityPOByRouteId(String routeId);

  public List<ServiceQualityPO> findAllByDelFlagIsFalse();
}
