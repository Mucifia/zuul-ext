package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.CorsConfigPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface CorsConfigRepository extends JpaRepository<CorsConfigPO,String> {

  public CorsConfigPO findCorsConfigPOByCode(String code);
}
