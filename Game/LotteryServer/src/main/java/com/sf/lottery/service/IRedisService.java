package com.sf.lottery.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IRedisService {
	
	boolean exists(String key);
	
	void delete(String key);
	
	void set(String key, Object value, long timeout);

	Object get(String key);

	<T> void setList(String key, List<T> list, long timeout);

	Object getList(String key);
	
	void setSet(String key, Object value, long timeout);
	
	Set<Object> getSet(String key);
	
	void setHash(String key, Map<? extends Object, ? extends Object> m, long timeout);
	
	Map<Object, Object> getHash(String key);
}
