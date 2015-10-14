package com.shma.common.codec;

import org.apache.commons.codec.digest.DigestUtils;

public class CodecUtils {

	/**
	 * md5加密
	 * @param key
	 * @return
	 */
	public static String md5Hex(String key) {
		return DigestUtils.md5Hex(key).toUpperCase();
	}
	
	public static byte[] md5(String key) {
		return DigestUtils.md5(key);
	}
	
	public static String md5Hex(byte[] key) {
		return DigestUtils.md5Hex(key).toUpperCase();
	}
	
	public static byte[] md5(byte[] key) {
		return DigestUtils.md5(key);
	}
	
	public static byte[] sha1(String data) {
		return DigestUtils.sha(data);
	}
	
	public static byte[] sha1(byte[] data) {
		return DigestUtils.sha(data);
	}
	
}
