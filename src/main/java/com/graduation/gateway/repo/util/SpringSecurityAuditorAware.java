package com.graduation.gateway.repo.util;

import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description:
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

  @Override
  public String getCurrentAuditor() {
    String user = null;
    if (RequestContextHolder.getRequestAttributes() != null) {
      HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
      user = request.getHeader("X-AUTH-ID");
    }
    return user == null ? "system" : user;
  }
}
