package com.shma.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestConvertProperty2Sql {

	public static void main(String[] arg) throws IOException {
		File file = new File("D:\\external.properties");
		File newFile = new File("D:\\1.sql");
		if(!newFile.exists()) {
			newFile.createNewFile();
		}
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(file));
			bw = new BufferedWriter(new FileWriter(newFile));
			String line = null;
			while((line = br.readLine()) != null) {
				if(line.equals("") || line.startsWith("#")) {
					continue;
				}
				
				String[] tmpArrs = line.split("=");
				String param1 = "";
				String param2 = "";
				if(tmpArrs.length == 2) {
					param1 = tmpArrs[0];
					param2 = tmpArrs[1];
				} else {
					param1 = tmpArrs[0];
				}
				String sql = "insert into t_config_record (config_key, config_value, isvalid) values ('" + param1 + "', '" + param2 + "', 1);";
		
				bw.write(sql);
				bw.newLine();
				bw.flush();
			} 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			br.close();
			bw.close();
		}
	}
}
