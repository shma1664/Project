package com.shma.redis;

import redis.clients.jedis.ShardedJedis;

public class RedisCache {

	private RedisService redisService;

	public void set(String key, String value) {
		ShardedJedis shardedJedis = null;
		
		try {
			shardedJedis = redisService.getShareJedisPoolConnection();
			shardedJedis.set(key, value);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			shardedJedis.close();
		}
	}
	
	public String get(String key) {
		ShardedJedis shardedJedis = null;
				
		try {
			shardedJedis = redisService.getShareJedisPoolConnection();
			
			return shardedJedis.get(key);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			shardedJedis.close();
		}
		
		return null;
	}
	
	public boolean del(String key) {
		ShardedJedis shardedJedis = null;
				
		try {
			shardedJedis = redisService.getShareJedisPoolConnection();
			return shardedJedis.del(key) > 0 ? true : false;
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			shardedJedis.close();
		}
		
		return false;
	}
	
	public RedisService getRedisService() {
		return redisService;
	}

	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}
	
	
}
