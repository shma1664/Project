package com.shma.guava;

import java.net.InetAddress;

import org.junit.Test;

import com.google.common.net.HostAndPort;
import com.google.common.net.HttpHeaders;
import com.google.common.net.InetAddresses;

/**
 * 网络编程
 * @author admin
 *
 */
public class NetTest {

	/**
	 * 定义头信息常量
	 */
	@Test
	public void testHttpHeaders() {
		System.out.println(HttpHeaders.X_FORWARDED_FOR); //X-Forwarded-For
		System.out.println(HttpHeaders.COOKIE); //Cookie
	}
	
	@Test
	public void testHostAndPort() {
		HostAndPort hostAndPort = HostAndPort.fromString("192.168.28.133:8080");
		System.out.println("host:" + hostAndPort.getHostText()); //host:192.168.28.133
		System.out.println("port:" + hostAndPort.getPort()); //port:8080
	}
	
	@Test
	public void testInetAddresses() {
		InetAddress inetAddress = InetAddresses.forUriString("192.168.28.133");
		System.out.println(inetAddress);
	}
}
