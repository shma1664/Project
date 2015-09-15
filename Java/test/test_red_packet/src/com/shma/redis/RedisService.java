package com.shma.redis;

import java.util.List;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisService {

	private GenericObjectPoolConfig jedisPoolConfig;
	private List<JedisShardInfo> jedisShardInfos;
	
	private ShardedJedisPool shareJedisPool;
	
	public void init() {
		shareJedisPool =new ShardedJedisPool(jedisPoolConfig, jedisShardInfos);
	}
	
	public ShardedJedis getShareJedisPoolConnection() {
		ShardedJedis shardedJedis = shareJedisPool.getResource();
		return shardedJedis;
	}

	public GenericObjectPoolConfig getJedisPoolConfig() {
		return jedisPoolConfig;
	}

	public void setJedisPoolConfig(GenericObjectPoolConfig jedisPoolConfig) {
		this.jedisPoolConfig = jedisPoolConfig;
	}

	public List<JedisShardInfo> getJedisShardInfos() {
		return jedisShardInfos;
	}

	public void setJedisShardInfos(List<JedisShardInfo> jedisShardInfos) {
		this.jedisShardInfos = jedisShardInfos;
	}

	public ShardedJedisPool getShareJedisPool() {
		return shareJedisPool;
	}

	public void setShareJedisPool(ShardedJedisPool shareJedisPool) {
		this.shareJedisPool = shareJedisPool;
	}

}
