package com.shma.protobuf;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.google.protobuf.InvalidProtocolBufferException;

public class TestProtobuf {

	public static void main(String[] args) {
		//���л����� 
		//FirstProtobufTest������������֣���proto�ļ��е�java_outer_classname 
		//TestBuf������ĳ�����е����֣���proto�ļ��е�message TestBuf 
		FirstProtobufTest.TestBuf.Builder builder=FirstProtobufTest.TestBuf.newBuilder(); 
		builder.setID(777); 
		builder.setUrl("shiqi"); 

		//TestBuf 
		FirstProtobufTest.TestBuf info=builder.build(); 

		byte[] result = info.toByteArray() ; 

		String driver = "oracle.jdbc.driver.OracleDriver"; 
		String url = "jdbc:oracle:thin:@10.64.59.12:1521/orcl"; 
		String user = "parkingsystem";  
		String password = "parkingsystem"; 
		try { 
		         Class.forName(driver); 
		        Connection conn = DriverManager.getConnection(url, user, password); 

		        if(!conn.isClosed()){ 
		         System.out.println("Succeeded connecting to the Database!"); 
		           
		         //�˴�ֻ��ʹ��prepareStatement 
		         PreparedStatement ps = conn.prepareStatement("insert into test(id,test) values (1,?)"); 
		         
		         //д�����ݿ⣬Ҫ������дΪ������ʽ 
		         ByteArrayInputStream stream =  new ByteArrayInputStream(result); 
		         ps.setBinaryStream(1,stream,stream.available()); 
		         Statement statement = conn.createStatement(); 
		           
		         Blob blob = null; 
		         ps.execute(); 
		         
		         ////////////////������ɽ�д�����ݿ�Ĳ��������ݿ��ж�Ӧ���ֶε�����Ҫ����ΪBlob          
		         
		         String sql = "select test from test"; 
		         ResultSet rs = statement.executeQuery(sql); 
		         if(rs.next()){ 
		         blob = rs.getBlob("test"); 
		         } 
		           
		         byte[] s = blob.getBytes(1,(int)blob.length()); 
		           
		         FirstProtobufTest.TestBuf TestBuf = FirstProtobufTest.TestBuf.parseFrom(s); 
		         System.out.println(TestBuf); 
		         conn.close(); 
		        } 
		         }catch(Exception e) { 
		          e.printStackTrace(); 
		         } 

		//�����л����� 
		try { 
		FirstProtobufTest.TestBuf TestBuf = FirstProtobufTest.TestBuf.parseFrom(result); 
		System.out.println(TestBuf); 
		} catch (InvalidProtocolBufferException e) { 
		e.printStackTrace(); 
		} 
	}
}
