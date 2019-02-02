package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ServicePlanApiRelationPO;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mmy
 * @date: 2018/12/22
 * @description:
 */
public interface ServicePlanApiRelationRepository extends JpaRepository<ServicePlanApiRelationPO,String> {

  List<ServicePlanApiRelationPO> findAllByApiId(String string);

  List<ServicePlanApiRelationPO> findAllByServiceplanId(String serviceplanId);

  List<ServicePlanApiRelationPO> findAllByServiceplanId(String serviceplanId, Pageable pageable);

  ServicePlanApiRelationPO findServicePlanApiRelationPOByServiceplanIdAndApiId(String serviceplanId,String apiId);
}
