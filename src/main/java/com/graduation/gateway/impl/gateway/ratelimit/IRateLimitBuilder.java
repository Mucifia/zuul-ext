package com.graduation.gateway.impl.gateway.ratelimit;

import com.graduation.gateway.impl.gateway.redis.RedisRepository;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties.Policy;
import java.util.List;
import java.util.Map;

public abstract class  IRateLimitBuilder {

	public RedisRepository redisRepository;


	public abstract Map<String,Policy> getPolicies(String routeId);


	public abstract Map<String,Policy> getPolicies(List<String> routeId);

	public abstract Map<String,Policy> getAllPolicies();

	public RedisRepository getRedisRepository() {
		return redisRepository;
	}

	public void setRedisRepository(RedisRepository redisRepository) {
		this.redisRepository = redisRepository;
	}
}
