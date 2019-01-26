package com.graduation.gateway.api.service;

import com.graduation.gateway.api.model.ApiBaseVO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author: mmy
 * @date: 2019/01/26
 * @description:
 */
public interface ApiBaseService {

  @PostMapping()
  public void saveApiBase();

  @GetMapping()
  public ApiBaseVO getApiBase();

  @GetMapping()
  public List<ApiBaseVO> getApiBases();

  @PutMapping()
  public void updateApiBase();

  @DeleteMapping()
  public void deleteApiBase();



}
