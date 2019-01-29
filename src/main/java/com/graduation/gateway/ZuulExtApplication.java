package com.graduation.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableZuulProxy
@EnableJpaAuditing
public class ZuulExtApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZuulExtApplication.class, args);
  }



}
