package com.zc.redis;

import java.util.List;

import redis.clients.jedis.JedisCluster;

/**
 * @Description:jedis集群
 * @author: zhuchao
 * @date: 2020年1月15日 下午2:04:16
 */
public class JedisClusterImpl implements AbstarctJedis{
	
	private JedisCluster jedisCluster;

	public JedisClusterImpl(JedisCluster jedisCluster) {
		this.jedisCluster = jedisCluster;
	}
	
	@Override
	public String set(String key, String value) {
		return jedisCluster.set(key, value);
	}

	@Override
	public String get(String key) {
		return jedisCluster.get(key);
	}

	@Override
	public Boolean exists(String key) {
		return jedisCluster.exists(key);
	}

	@Override
	public String setex(String key, int seconds, String value) {
		return jedisCluster.setex( key, seconds, value);
	}

	@Override
	public Long del(String key) {
		return jedisCluster.del(key);
	}

	@Override
	public Long ttl(String key) {
		return jedisCluster.ttl(key);

	}

	@Override
	public Long incr(String key) {
		return jedisCluster.incr(key);

	}

	@Override
	public Long hset(String key, String field, String value) {
		return jedisCluster.hset(key,field,value);

	}

	@Override
	public String hget(String key, String field) {
		return jedisCluster.hget(key,field);
	}

	@Override
	public Long hdel(String key, String... field) {
		return jedisCluster.hdel(key,field);
	}

	@Override
	public Boolean hexists(String key, String field) {
		return jedisCluster.hexists(key,field);

	}

	@Override
	public List<String> hvals(String key) {
		return jedisCluster.hvals(key);
	}

}
