package com.shma.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.ShardedJedis;

public class RedisUtil {

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

	/**
	 * 存储到redis队列中，插入到表头
	 * 
	 * @param key
	 * @param value
	 */
	public void lpush(byte[] key, byte[] value) {
		ShardedJedis shardedJedis = null;

		try {
			shardedJedis = redisService.getShareJedisPoolConnection();
			shardedJedis.lpush(key, value);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			shardedJedis.close();
		}
	}

	/**
	 * 存储到redis队列中，插入到表尾
	 * 
	 * @param key
	 * @param value
	 */
	public void rpush(byte[] key, byte[] value) {
		ShardedJedis shardedJedis = null;

		try {
			shardedJedis = redisService.getShareJedisPoolConnection();
			shardedJedis.rpush(key, value);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			shardedJedis.close();
		}
	}

	public byte[] lpop(byte[] key) {

		ShardedJedis shardedJedis = null;

		try {
			shardedJedis = redisService.getShareJedisPoolConnection();
			return shardedJedis.lpop(key);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			shardedJedis.close();
		}

		return null;
	}

	public byte[] rpop(byte[] key) {

		ShardedJedis shardedJedis = null;

		try {
			shardedJedis = redisService.getShareJedisPoolConnection();
			return shardedJedis.rpop(key);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			shardedJedis.close();
		}

		return null;
	}
	
	public Long getLen(byte[] key) {
		ShardedJedis shardedJedis = null;

		try {
			shardedJedis = redisService.getShareJedisPoolConnection();
			return shardedJedis.llen(key);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			shardedJedis.close();
		}

		return 0L;
	}

	public List<byte[]> getRedisList(byte[] key) {
		ShardedJedis shardedJedis = null;

		try {
			shardedJedis = redisService.getShareJedisPoolConnection();
			return shardedJedis.lrange(key, 0, -1);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			shardedJedis.close();
		}

		return null;
	}

	public boolean isExistUpdate(final String... param) {

		ShardedJedis shardedJedis = null;

		try {
			
			shardedJedis = redisService.getShareJedisPoolConnection();
			
			String key = param[0];
			int expire = 20;
			if (param.length > 1) {
				expire = Integer.parseInt(param[1]);
			}
			long status = shardedJedis.setnx("redis_lock_" + key, "true");
			if (status > 0) {
				shardedJedis.expire("redis_lock_" + key, expire);
			}

			return status <= 0 ? true : false;
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			shardedJedis.close();
		}

		return false;

	}
	
	public Long unLockRedisKey(final String key) {
		
		ShardedJedis shardedJedis = null;

		try {
			shardedJedis = redisService.getShareJedisPoolConnection();
			return shardedJedis.del("redis_lock_" + key);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			shardedJedis.close();
		}
		
		return -1L;
    }
	
	public RedisHash getRedisHash(String key) {
		return new RedisHash(key);
	}
	
	/**
     * Redis 哈希
     */
    public class RedisHash {

        private String key;

        public RedisHash(String key) {
        	this.key = key;
        }

        /**
         * 获取指定属性值
         *
         * @param field 属性名
         *
         * @return 属性值
         */
        public String get(final String field) {
        	
        	ShardedJedis shardedJedis = null;

    		try {
    			shardedJedis = redisService.getShareJedisPoolConnection();
    			return shardedJedis.hget(key, field);
    		} catch (Throwable e) {
    			e.printStackTrace();
    		} finally {
    			shardedJedis.close();
    		}

    		return null;

        }

        /**
         * 获取指定属性值
         *
         * @param fields 属性名
         *
         * @return 属性值
         */
        public List<String> get(final String... fields) {
            
            ShardedJedis shardedJedis = null;

    		try {
    			shardedJedis = redisService.getShareJedisPoolConnection();
    			return shardedJedis.hmget(key, fields);
    		} catch (Throwable e) {
    			e.printStackTrace();
    		} finally {
    			shardedJedis.close();
    		}

    		return null;
        }

        /**
         * 设置属性
         *
         * @param field 属性名
         * @param value 属性值
         */
        public void put(final String field, final String value) {
            
            ShardedJedis shardedJedis = null;

    		try {
    			shardedJedis = redisService.getShareJedisPoolConnection();
    			shardedJedis.hset(key, field, value);
    		} catch (Throwable e) {
    			e.printStackTrace();
    		} finally {
    			shardedJedis.close();
    		}
        }

        /**
         * 仅当属性名不存在是设置属性
         *
         * @param field 属性名
         * @param value 属性值
         *
         * @return 0表示属性已存在
         */
        public int setOnlyIfNotExists(final String field, final String value) {
            
        	ShardedJedis shardedJedis = null;

    		try {
    			shardedJedis = redisService.getShareJedisPoolConnection();
    			return shardedJedis.hsetnx(key, field, value).intValue();
    		} catch (Throwable e) {
    			e.printStackTrace();
    		} finally {
    			shardedJedis.close();
    		}

    		return -1;
        }

        /**
         * 保存多个属性名和属性值
         *
         * @param map 属性
         */
        public void putAll(final Map<String, String> map) {
            
            ShardedJedis shardedJedis = null;

    		try {
    			shardedJedis = redisService.getShareJedisPoolConnection();
    			shardedJedis.hmset(key, map);
    		} catch (Throwable e) {
    			e.printStackTrace();
    		} finally {
    			shardedJedis.close();
    		}
        }

        /**
         * 删除一个或多个属性
         *
         * @param fields 属性名
         *
         * @return 被删除的属性数量
         */
        public int delete(final String... fields) {
        	
            ShardedJedis shardedJedis = null;

    		try {
    			shardedJedis = redisService.getShareJedisPoolConnection();
    			return shardedJedis.hdel(key, fields).intValue();
    		} catch (Throwable e) {
    			e.printStackTrace();
    		} finally {
    			shardedJedis.close();
    		}

    		return -1;
        }

        /**
         * 列出所有属性
         *
         * @return 所有属性名
         */
        public List<String> keys() {
            
            ShardedJedis shardedJedis = null;

    		try {
    			shardedJedis = redisService.getShareJedisPoolConnection();
    			return new ArrayList<String>(shardedJedis.hkeys(key));
    		} catch (Throwable e) {
    			e.printStackTrace();
    		} finally {
    			shardedJedis.close();
    		}

    		return null;
        }

        /**
         * 读取所有属性值并转换为 Map 对象
         *
         * @return 所有属性值
         */
        public Map<String, String> toMap() {
            
            ShardedJedis shardedJedis = null;

    		try {
    			shardedJedis = redisService.getShareJedisPoolConnection();
    			return shardedJedis.hgetAll(key);
    		} catch (Throwable e) {
    			e.printStackTrace();
    		} finally {
    			shardedJedis.close();
    		}

    		return null;
        }
        
        /**
         * 读取key的长度
         *
         * @return 所有属性值
         */
        public Long getLen() {
            ShardedJedis shardedJedis = null;

    		try {
    			shardedJedis = redisService.getShareJedisPoolConnection();
    			return shardedJedis.hlen(key);
    		} catch (Throwable e) {
    			e.printStackTrace();
    		} finally {
    			shardedJedis.close();
    		}

    		return 0L;
        }
        
        /**
         * 是否存在一个key
         *
         * @return 所有属性值
         */
        public Boolean isExist(final String field) {
            
            ShardedJedis shardedJedis = null;

    		try {
    			shardedJedis = redisService.getShareJedisPoolConnection();
    			return shardedJedis.hexists(key, field);
    		} catch (Throwable e) {
    			e.printStackTrace();
    		} finally {
    			shardedJedis.close();
    		}

    		return false;
        }
        
    }
	

	public RedisService getRedisService() {
		return redisService;
	}

	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}

}
