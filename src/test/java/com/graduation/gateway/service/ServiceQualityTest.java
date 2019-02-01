package com.graduation.gateway.service;

import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.service.ServiceQualityService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: mmy
 * @date: 2018/12/23
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@EnableJpaAuditing
@FixMethodOrder(MethodSorters.JVM)
public class ServiceQualityTest {



  @Autowired
  ServiceQualityService serviceQualityService;



  @Test
  public void init(){

    for (int i =0;i<50;i++){
      ServiceQualityVO serviceQualityVO = new ServiceQualityVO();
      serviceQualityService.save(serviceQualityVO);
    }

    for (int i =0;i<50;i++){
      ServiceQualityVO serviceQualityVO = new ServiceQualityVO();
      serviceQualityService.save(serviceQualityVO);
    }

  }

  @Test
  public void testMap(){
    Map<String,ServiceQualityVO> map1 = serviceQualityService.getAllServiceQMapByPlan();
    Map<String,ServiceQualityVO> map2 = serviceQualityService.getAllServiceQMapByRoute();
  }


  @Test
  public void testGet(){
    List<String> routeIds = new ArrayList<>();
    routeIds.add("test-case");
    List<ServiceQualityVO> list1 = serviceQualityService.getSSOQualityByRouteId(routeIds,0,10);
    List<ServiceQualityVO> list2 = serviceQualityService.getSSOQualityByRouteId(routeIds,1,10);
    List<ServiceQualityVO> list3 = serviceQualityService.getSSOQualityByRouteId(routeIds,2,10);
    List<ServiceQualityVO> list4 = serviceQualityService.getSSOQualityByRouteId(routeIds,3,10);
    List<ServiceQualityVO> list5 = serviceQualityService.getSSOQualityByRouteId(routeIds,4,10);
  }











}
