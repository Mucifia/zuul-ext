package com.graduation.gateway;

import com.graduation.gateway.impl.gateway.configuration.ZuulConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableZuulProxy
public class ZuulExtApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZuulExtApplication.class, args);
  }



}
