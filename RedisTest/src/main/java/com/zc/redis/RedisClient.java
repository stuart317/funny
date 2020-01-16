package com.zc.redis;

import java.util.List;

/**
 * @Description:redis客户端
 * @author: zhuchao
 * @date: 2020年1月15日 上午10:59:05
 */
public class RedisClient {
	
	/**
	 * 抽象 jedis客户端 ，根据环境自动切换 单机、集群
	 */
	private AbstarctJedis jedis;
	
	//私有构造方法
	private RedisClient() {}
	
	//公有获取实例方法
	private static RedisClient getInstance() {
		return Singleton.INSTANCE.getInstance();
	}
	
	//单例模式：静态枚举内部类
	public static enum Singleton {
		INSTANCE;
		private static RedisClient redisClient = new RedisClient();
		private RedisClient getInstance() {
			return redisClient;
		}
	}
	
	public void setJedis(AbstarctJedis jedis){
        this.jedis = jedis;
	}
	
	/**
	 * 初始化代码块，单例模式 只会执行一次
	 */
	{
		//初始化jedis,根据环境自动切换 单机、集群
		AbstarctJedis jedis = JedisConfig.initJedis();
		setJedis(jedis);
	}
	
	public String set(String key, String value) {
		return jedis.set(key, value);
	}

	/**
	 * 返回数据库中名称为key的string的value
	 */
	public String get(String key) {
		return jedis.get(key);
	}

	/**
	 * 确认一个key是否存在
	 */
	public Boolean exists(String key) {
		return jedis.exists(key);
	}

	/**
	 * 向库中添加string，设定过期时间seconds
	 */
	public String setex(String key, int seconds, String value) {
		return jedis.setex( key, seconds, value);
	}

	/**
	 * 删除一个key
	 */
	public Long del(String key) {
		return jedis.del(key);
	}

	/**
	 * 获得一个key的活动时间
	 */
	public Long ttl(String key) {
		return jedis.ttl(key);

	}

	/**
	 * 名称为key的string增1操作
	 * @param key
	 * @return
	 */
	public Long incr(String key) {
		return jedis.incr(key);

	}

	/*
	 * 向名称为key的hash中添加元素field
	 */
	public Long hset(String key, String field, String value) {
		return jedis.hset(key,field,value);

	}

	/*
	 * 返回名称为key的hash中field对应的value
	 */
	public String hget(String key, String field) {
		return jedis.hget(key,field);
	}

	/**
	 * 删除名称为key的hash中键为field的域
	 */
	public Long hdel(String key, String... field) {
		return jedis.hdel(key,field);
	}

	/**
	 * 名称为key的hash中是否存在键为field的域
	 */
	public Boolean hexists(String key, String field) {
		return jedis.hexists(key,field);

	}

	/**
	 * 返回名称为key的hash中所有键对应的value
	 */
	public List<String> hvals(String key) {
		return jedis.hvals(key);
	}


	public static void main(String[] args) {

		RedisClient redis = RedisClient.getInstance();

		System.out.println(redis.get("aaa"));
	}
}
