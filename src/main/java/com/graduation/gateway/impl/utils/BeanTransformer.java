package com.graduation.gateway.impl.utils;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.beans.BeanUtils;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
public class BeanTransformer {



  public static <T> T convert(Object source, Class<T> targetClass) {
    T targetObj = BeanUtils.instantiate(targetClass);
    return convert(source, targetObj);
  }

  public static <T> T convert(Object source, T target) {
    BeanUtils.copyProperties(source, target);
    return target;
  }

  public static <T> List<T> copyList(List<Object> sources,Class<T> targetClass)
      throws IllegalAccessException, InstantiationException {
    T targetObj =  BeanUtils.instantiate(targetClass);
    List<T> target = sources.getClass().newInstance();
    for (Object o : sources){
      BeanUtils.copyProperties(o,targetObj);
      target.add(targetObj);
    }
    return target;
  }

  public static <T> Set<T> copySet(Set<?> sources,Class<T> targetClass)
      throws IllegalAccessException, InstantiationException {
    Set<T> target = sources.getClass().newInstance();
    for (Object o : sources){
      T targetObj =  BeanUtils.instantiate(targetClass);
      BeanUtils.copyProperties(o,targetObj);
      target.add(targetObj);
    }
    return target;
  }



}
