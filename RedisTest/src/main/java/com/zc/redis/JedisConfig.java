package com.zc.redis;

import org.apache.log4j.Logger;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:redis配置类
 * @author: zhuchao
 * @date: 2020年1月15日 下午3:08:06
 */
public class JedisConfig {

	private static Logger logger=Logger.getLogger(JedisConfig.class);
	
	// 添加集群的服务节点Set集合
    private static Set<HostAndPort> hostAndPortsSet = new HashSet<HostAndPort>();
	private static JedisCluster jedisCluster;
	private static JedisPool  jedisPool ;
	
	/**
	 * 初始化 redis集群
	 * @return
	 */
	public static AbstarctJedis initJedis() {
		AbstarctJedis jedisImpl = null;
		try {
			//redis地址
			String redisAddrCfg = PropsConfig.getPropValue("redis.address", null);
			logger.info("******redis地址******："+redisAddrCfg);
			System.out.println("*****redis地址******："+redisAddrCfg);
			//获取redis初始配置
			JedisPoolConfig jedisPoolConfig = initJedisPoolConfig();
			
			//测试 、生产 redis集群
			if (redisAddrCfg == null) {
			    throw new Exception("redis集群配置redis.address属性有误");
			}
			
			//开发环境  使用单机redis 
			if (redisAddrCfg.indexOf(",")< 0) {
				String[] ipAndPort = redisAddrCfg.split(":");
		        if (ipAndPort == null) {
		            throw new Exception("redis单机版配置redis.address属性有误");
		        }
		        jedisPool = new JedisPool(jedisPoolConfig ,ipAndPort[0],Integer.parseInt(ipAndPort[1]));
		        jedisImpl = new JedisAloneImpl(jedisPool);
			} else {
				
				String[] addrs = redisAddrCfg.split(",");
				for (String addr : addrs) {
				    String[] ipAndPort = addr.split(":");
				    hostAndPortsSet.add(new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1])));
				}
				jedisCluster = new JedisCluster(hostAndPortsSet, jedisPoolConfig);
				jedisImpl = new JedisClusterImpl(jedisCluster);
			}
			return jedisImpl;
		} catch (Exception e) {
			logger.error("[initJedis]初始化jedis方法异常："+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 初始化jedis配置
	 * @return
	 */
	public static JedisPoolConfig initJedisPoolConfig() {
		
		String maxTotal = PropsConfig.getPropValue("redis.maxTotal", null);
		String maxIdle = PropsConfig.getPropValue("redis.maxIdle", null);
		String maxWaitMillis = PropsConfig.getPropValue("redis.maxWaitMillis", null);
		
		 // Jedis连接池配置
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig(); // 最大空闲连接数, 默认8个
        // 最大连接数, 默认8个
        jedisPoolConfig.setMaxTotal(Integer.parseInt(maxTotal));
		// 最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxIdle(Integer.parseInt(maxIdle));
		//获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间, 默认-1
		jedisPoolConfig.setMaxWaitMillis(Integer.parseInt(maxWaitMillis)); // 设置2秒
		//对拿到的connection进行validateObject校验
		jedisPoolConfig.setTestOnBorrow(true);
		return jedisPoolConfig;
	}
}
