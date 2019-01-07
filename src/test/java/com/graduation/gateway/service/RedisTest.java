package com.graduation.gateway.service;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.gateway.redis.RedisManagement;
import com.graduation.gateway.impl.gateway.redis.RedisTemplateUtil;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: mmy
 * @date: 2019/01/07
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@EnableJpaAuditing
@FixMethodOrder(MethodSorters.JVM)
public class RedisTest {


  @Autowired
  private JedisConnectionFactory jedisConnectionFactory;

  private RedisTemplateUtil redisTemplateUtil;

  @Before
  public void setUp() throws Exception {
    redisTemplateUtil=new RedisTemplateUtil(jedisConnectionFactory);
  }

  @Test
  public void test1(){
    redisTemplateUtil.getMngRedisTemplate().opsForHash().put("manageTest","1",new RedisManagement("1","1",1L,2L));
    RouteVO routeVO = new RouteVO();
    routeVO.setTargetServiceId("adsad");
    redisTemplateUtil.getRouteRedisTemplate().opsForHash().put("routeTest","1",routeVO);
    ServiceQualityVO serviceQualityVO = new ServiceQualityVO();
    serviceQualityVO.setRouteId("SArsarsa");
    redisTemplateUtil.getSqRedisTemplate().opsForHash().put("serviceQTest","1",serviceQualityVO);



    redisTemplateUtil.getMngRedisTemplate().opsForHash().entries("manageTest");
    redisTemplateUtil.getRouteRedisTemplate().opsForHash().entries("routeTest");
    redisTemplateUtil.getSqRedisTemplate().opsForHash().entries("serviceQTest");




  }


}
