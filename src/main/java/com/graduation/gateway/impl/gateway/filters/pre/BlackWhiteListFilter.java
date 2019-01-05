package com.graduation.gateway.impl.gateway.filters.pre;

import com.netflix.zuul.ZuulFilter;

/**
 * @author: mmy
 * @date: 2019/01/05
 * @description:
 */
public class BlackWhiteListFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return null;
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return false;
  }

  @Override
  public Object run() {
    return null;
  }
}
