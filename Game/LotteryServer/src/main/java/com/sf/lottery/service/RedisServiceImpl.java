package com.sf.lottery.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements IRedisService {
	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}
	
	@Override
	public void delete(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public void set(String key, Object value, long timeout) {
		redisTemplate.opsForValue().set(key, value);
		if(timeout > 0){
			expire(key, timeout);
		}
	}

	@Override
	public Object get(String key) {
		Object obj = redisTemplate.opsForValue().get(key);
		return obj;
	}

	@Override
	public <T> void setList(String key, List<T> list, long timeout) {
		redisTemplate.opsForList().leftPush(key, list);
		if(timeout > 0){
			expire(key, timeout);
		}
	}

	@Override
	public Object getList(String key) {
		Object obj = redisTemplate.opsForList().leftPop(key);
		return obj;
	}
	
	@Override
	public void setSet(String key, Object value, long timeout) {
		redisTemplate.opsForSet().add(key, value);
		if(timeout > 0){
			expire(key, timeout);
		}
	}
	
	@Override
	public Set<Object> getSet(String key) {
		Set<Object> set = redisTemplate.opsForSet().members(key);
		return set;
	}
	
	@Override
	public void setHash(String key, Map<? extends Object, ? extends Object> m, long timeout) {
		redisTemplate.opsForHash().putAll(key, m);
		if(timeout > 0){
			expire(key, timeout);
		}
	}
	
	@Override
	public Map<Object, Object> getHash(String key) {
		Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
		return map;
	}
	
	private boolean expire(String key, long timeout) {
		boolean result = redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
		return result;
	}

}
