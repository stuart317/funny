package com.zc.redis;

import java.util.List;

/**
 * 策略模式
 * @Description:抽象jedis类
 * @author: zhuchao
 * @date: 2020年1月15日 下午1:55:49
 */
public interface AbstarctJedis {

	/**
	 * 给数据库中名称为key的string赋予值value
	 * @param key
	 * @param value
	 * @return
	 */
	String set(String key, String value);
	
	/**
	 * 返回数据库中名称为key的string的value
	 */
	String get(String key);
	
	/**
	 * 确认一个key是否存在
	 */
	Boolean exists(String key);
	
	/**
	 * 向库中添加string，设定过期时间seconds
	 */
	String setex(String key, int seconds, String value);
	
	
	/**
	 * 删除一个key
	 */
	Long del(String key);
	
	/**
	 * 获得一个key的活动时间
	 */
	Long ttl(String key);
	
	/**
	 * 名称为key的string增1操作
	 * @param key
	 * @return
	 */
	Long incr(String key);
	
	/*
	 * 向名称为key的hash中添加元素field
	 */
	Long hset(String key, String field, String value);
	
	/*
	 * 返回名称为key的hash中field对应的value
	 */
	String hget(String key, String field);
	
	/**
	 * 删除名称为key的hash中键为field的域
	 */
	Long hdel(String key, String... field);
	
	/**
	 * 名称为key的hash中是否存在键为field的域
	 */
	Boolean hexists(String key, String field);
	
	/**
	 * 返回名称为key的hash中所有键对应的value
	 */
	List<String> hvals(String key);
}
