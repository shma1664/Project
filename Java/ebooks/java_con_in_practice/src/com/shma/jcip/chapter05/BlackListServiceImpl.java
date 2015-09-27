package com.shma.jcip.chapter05;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * ºÚÃûµ¥
 * @author admin
 *
 */
public class BlackListServiceImpl {

	private static CopyOnWriteArraySet<String> blackSet = 
								new CopyOnWriteArraySet<String>();
	
	public static boolean isBlackIp(String ip) {
		return blackSet.contains(ip);
	}
	
	public static void addBlackIp(String ip) {
		blackSet.add(ip);
	}
	
	public static void addBatchBlackIp(Set<String> ips) {
		blackSet.addAll(ips);
	}

}
