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
		//序列化过程 
		//FirstProtobufTest是生成类的名字，即proto文件中的java_outer_classname 
		//TestBuf是里面某个序列的名字，即proto文件中的message TestBuf 
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
		           
		         //此处只能使用prepareStatement 
		         PreparedStatement ps = conn.prepareStatement("insert into test(id,test) values (1,?)"); 
		         
		         //写入数据库，要把它改写为流的形式 
		         ByteArrayInputStream stream =  new ByteArrayInputStream(result); 
		         ps.setBinaryStream(1,stream,stream.available()); 
		         Statement statement = conn.createStatement(); 
		           
		         Blob blob = null; 
		         ps.execute(); 
		         
		         ////////////////上述完成将写入数据库的操作，数据库中对应的字段的属性要设置为Blob          
		         
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

		//反序列化过程 
		try { 
		FirstProtobufTest.TestBuf TestBuf = FirstProtobufTest.TestBuf.parseFrom(result); 
		System.out.println(TestBuf); 
		} catch (InvalidProtocolBufferException e) { 
		e.printStackTrace(); 
		} 
	}
}
