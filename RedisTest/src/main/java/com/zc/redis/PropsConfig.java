package com.zc.redis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 读取配置文件工具类
 * @author lubang713
 *
 */
public class PropsConfig{

	private static Logger logger=Logger.getLogger(PropsConfig.class);
	
	private static Properties props = new Properties();
	
	static{
		load();
	}
	
	private static synchronized void load() {
		
		try {
			if(props==null || props.isEmpty()){

				InputStream is = PropsConfig.class.getClassLoader().getResourceAsStream("config.properties");
	
				props.load(is);

			}
			
		} catch (FileNotFoundException e) {
			logger.error("PropsConfig.load FileNotFoundException", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("PropsConfig.load IOException", e);
		}
			
	}

	public  static String getPropValue(String key) {
		if(props == null || props.isEmpty()){
			load();
		}
		return (String)props.get(key);
	}
	public static int getPropValue(String key,int defaultV) {
		return getPropValue(key)!=null?Integer.parseInt(getPropValue(key)):defaultV;
	}

	public static boolean getPropValue(String key,boolean defaultV) {
		return getPropValue(key)!=null?Boolean.parseBoolean(getPropValue(key)):defaultV;
	}
	public static long getPropValue(String key,long defaultV) {
		return getPropValue(key)!=null?Long.parseLong(getPropValue(key)):defaultV;
	}
	public static String getPropValue(String key,String defaultV) {
		return getPropValue(key)!=null?getPropValue(key):defaultV;
	}
	
	
	
	public static void main(String[] args){
		System.out.println(getPropValue("redis.address"));
		
	}
}
