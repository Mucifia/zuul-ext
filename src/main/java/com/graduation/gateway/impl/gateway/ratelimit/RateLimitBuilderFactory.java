package com.graduation.gateway.impl.gateway.ratelimit;

import com.graduation.gateway.impl.gateway.redis.RedisRepository;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties.Repository;
import java.lang.reflect.Type;
import javax.persistence.Table;

/**
 *
 */
public class RateLimitBuilderFactory {


	public static IRateLimitBuilder generateBuilder(Repository repository){
		if(repository.equals(Repository.REDIS)){
			return new RedisRateLimitBuilder();
		}else if (repository.equals(Repository.JPA)){
			return new JpaRateLimitBuilder();
		}
		return null;
	}
	public static IRateLimitBuilder generateBuilder(Class clazz){
		Type type =clazz.getGenericSuperclass();
			if (type.getTypeName().equals(IRateLimitBuilder.class.getName())){
				try {
					return (IRateLimitBuilder) clazz.newInstance();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		return null;
	}

}
