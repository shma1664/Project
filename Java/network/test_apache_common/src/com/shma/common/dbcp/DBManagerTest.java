package com.shma.common.dbcp;

import java.sql.Connection;

import org.junit.Test;

public class DBManagerTest {

	@Test
	public void test() {

		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			Connection conn = DBManager.getConnection();
			System.out.print(i + "   ");
			DBManager.closeConnection(conn);
		}
		long end = System.currentTimeMillis();
		System.out.println("用时：" + (end - begin));
	}

}
