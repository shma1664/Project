package com.shma.hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性hash算法实现
 * @author admin
 *
 */
public class ConsistencyHash {

	/**
	 * 数据库表节点集合
	 */
	private List<String> shards = new ArrayList<String>();
	
	private TreeMap<Long, String> nodes = new TreeMap<Long, String>();
	
	private Map<String, String> virtualToRealTable = new HashMap<String, String>();
	
	//虚拟节点数目
	private int virtualNum = 50;
	
	private int tableNum = 10;
	
	private String tableName;
	
	public ConsistencyHash(String tableName, int tableNum) {
		this.tableName = tableName;
		this.tableNum = tableNum;
	}
	
	public void init() {
		
		for(int i=0; i<tableNum; ++i) {
			for(int j=0; j < virtualNum; ++j) {
				String newTableName = tableName + i;
				String virtualTableName = newTableName + "_" + j;
				shards.add(virtualTableName);
				virtualToRealTable.put(virtualTableName, newTableName);
			}
		}
		
		for(String shard : shards) {
			nodes.put(hash(shard), shard);
		}
	}
	
	public String getTableName(String did) {
		long currDid = hash(did);
		SortedMap<Long, String> sortedMap = nodes.tailMap(currDid);
		long node = 0L;
		if(sortedMap == null || sortedMap.size() == 0) {
			node = nodes.firstKey();
		} else {
			node = sortedMap.firstKey();
		}
		
		return virtualToRealTable.get(nodes.get(node));
	}
	
	 /** 
     *  MurMurHash算法，是非加密HASH算法，性能很高， 
     *  比传统的CRC32,MD5，SHA-1（这两个算法都是加密HASH算法，复杂度本身就很高，带来的性能上的损害也不可避免） 
     *  等HASH算法要快很多，而且据说这个算法的碰撞率很低. 
     *  http://murmurhash.googlepages.com/ 
     */  
    private Long hash(String key) {  
          
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());  
        int seed = 0x1234ABCD;  
          
        ByteOrder byteOrder = buf.order();  
        buf.order(ByteOrder.LITTLE_ENDIAN);  
  
        long m = 0xc6a4a7935bd1e995L;  
        int r = 47;  
  
        long h = seed ^ (buf.remaining() * m);  
  
        long k;  
        while (buf.remaining() >= 8) {  
            k = buf.getLong();  
  
            k *= m;  
            k ^= k >>> r;  
            k *= m;  
  
            h ^= k;  
            h *= m;  
        }  
  
        if (buf.remaining() > 0) {  
            ByteBuffer finish = ByteBuffer.allocate(8).order(  
                    ByteOrder.LITTLE_ENDIAN);  
            // for big-endian version, do this first:   
            // finish.position(8-buf.remaining());   
            finish.put(buf).rewind();  
            h ^= finish.getLong();  
            h *= m;  
        }  
  
        h ^= h >>> r;  
        h *= m;  
        h ^= h >>> r;  
  
        buf.order(byteOrder);  
        return h;  
    }  
	
	private long md5HashingAlg(String key) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		md5.reset();
		md5.update(key.getBytes());
		byte[] bKey = md5.digest();
		long res = ((long) (bKey[3] & 0xFF) << 24) | ((long) (bKey[2] & 0xFF) << 16) | ((long) (bKey[1] & 0xFF) << 8)| (long) (bKey[0] & 0xFF);
		return res;
	}
}
