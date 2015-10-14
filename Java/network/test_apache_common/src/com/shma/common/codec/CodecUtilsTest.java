package com.shma.common.codec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class CodecUtilsTest {

	@Test
	public void testMd5() {
		String key = "123456";
		
		System.out.println(DigestUtils.md5(key));
		System.out.println(DigestUtils.md5(key.getBytes()));
		
		System.out.println(DigestUtils.md5Hex(key));
		System.out.println(DigestUtils.md5Hex(key.getBytes()));
		
		
	}
	
	@Test
	public void testSHA() {
		String key = "123456";
		
		System.out.println(DigestUtils.shaHex(key));
		System.out.println(DigestUtils.shaHex(key.getBytes()));
		
		System.out.println(DigestUtils.sha(key));
		System.out.println(DigestUtils.sha(key.getBytes()));
	}
	
	/**
	 * 加密解密算法：BASE64
	 */
	@Test
	public void base64() {
		String key = "abc";
		byte[] bytes = Base64.encodeBase64(key.getBytes(), true);
		
		String newKey = new String(bytes);
		System.out.println(newKey);
		
		byte[] currKey = Base64.decodeBase64(newKey.getBytes());
		System.out.println(new String(currKey));

	}

}
