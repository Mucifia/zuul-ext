package com.graduation.gateway.repo.dao.repository;

import com.graduation.gateway.repo.dao.model.ApiBasePO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public interface ApiBaseRepository extends JpaRepository<ApiBasePO,String>{

  public ApiBasePO findApiBasePOByName(String name);

}
