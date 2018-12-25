package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.RoutePO;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface RouteRepository extends JpaRepository<RoutePO,String> {

}
