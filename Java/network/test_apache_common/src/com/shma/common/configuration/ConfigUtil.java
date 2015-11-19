package com.shma.common.configuration;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;


/**
 * 读取配置文件工具类
 * @author shma
 *
 */
public class ConfigUtil {

	private static ConfigUtil configUtil;
	
	private static final CompositeConfiguration config = new CompositeConfiguration();
	
	static {
		try {
			config.addConfiguration(new PropertiesConfiguration("db.properties"));
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConfigUtil getInstance() {
		if(configUtil == null) {
			synchronized(ConfigUtil.class) {
				if(configUtil == null) {
					configUtil = new ConfigUtil();
				}
			}
		}
		
		return configUtil;
	}
	
	public static String get(String key) {
		return config.getString(key);
	}

}
