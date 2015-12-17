package com.abc360.classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Header;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.abc360.classes.util.HttpTookit;

public class AboutClasses { 
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 */
	public boolean login(String username, String password) {
		password = DigestUtils.md5Hex(password).toLowerCase();
		
		String url = "http://www.abc360.com/Web/Index/login";
		Map<String, String> params = new HashMap<String, String>();
		params.put("login_name", username);
		params.put("password", password);
		params.put("verify", "");
		params.put("autolog", "0");
		params.put("jump", "MemberCenter/index/index");
		
		Map<String, Object> dataMap = HttpTookit.doPost(url, params, null);
		Header[] headers = (Header[]) dataMap.get("headers");
		if(dataMap.get("data").toString().toLowerCase().contains("true")) {
			return true;
		}
		
		return false;
	}

	public String chooseTeacher(String tid, Map<String, List<String>> tidMap) {
		String url = "http://www.abc360.com/MemberCenter/BookClass/chooseTeacher";
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 4);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date date = new Date(calendar.getTimeInMillis());
		long newDate = date.getTime() / 1000;
		Map<String, String> params = new HashMap<String, String>();
//		newDate = 1450540800;
		params.put("date", newDate+"");
		params.put("mid", "5357");
		params.put("catalog", "1");
		params.put("fave", "0");
		params.put("mock", "0");
		params.put("tid",  tid);
		params.put("gender", "0");
		params.put("sjd", "0");
//		params.put("marks[]", "1");
		
		String text = "";
		
		Map<String, Object> dataMap = HttpTookit.doPost(url, params, null);
		String htmlString = String.valueOf(dataMap.get("data"));
//		System.out.println(htmlString);
		Document doc = null;
		doc = Jsoup.parse(htmlString);
		Elements contents = doc.getElementsByClass("order-tab");
        Elements datas = contents.get(0).getElementsByTag("dd").get(0).getElementsByTag("ul");
        loop:
        for (Element data : datas) {
            Elements lis = data.getElementsByTag("li");
            boolean isHas = false;
            for (int i = 0; i<lis.size(); i++) 
            {
            	Elements elements333 = lis.get(i).getElementsByClass("on");
            	if(elements333 != null && elements333.size() > 0) {
            		Element tds = elements333.get(0);
                    if(tds.hasAttr("data-date") && tds.attr("data-date").equals(newDate+"")) {
                    	isHas = true;
                    	Elements elements = doc.getElementsByClass("table_wrap");
                    	for(Element element : elements) {
                    		Elements tElement = element.getElementsByTag("table").get(0).getElementsByTag("tr");
                    		
                    		for(Element element2 : tElement) {
                    			Elements elements2 = element2.getElementsByTag("td");
                    			for(Element element3 : elements2) {
                    				if(element3.hasClass("first") && tidMap.get(tid).contains(element3.text())) {
                    					Element element4 = element3.nextElementSibling();
                    					if(element4.hasClass("open")) {
                    						text += element4.getElementsByTag("a").attr("cid") + "-";
                    					} else {
                    						text = "end-";
                    						break loop;
                    					}
                    					
                    					
                    				}
                    			}
                    		}
                    		
                    	} 
                    }
            	}
                
             
            }
            
            if(!isHas) {
            	return "-1";
            }
        }
        
        if(text != null && text != "") {
        	text = text.substring(0, text.length() - 1);
        }
	        
		
		return text;
	}
	
	public String saveBook(String id) {
		String url = "http://www.abc360.com/MemberCenter/BookClass/saveBook";
		Map<String, String> params = new HashMap<String, String>();
		params.put("request", "");
		params.put("uf", "1");
		params.put("id", id);
		params.put("mid", "5357");
		params.put("mid", "5357");
		params.put("i2h", "0");
		params.put("mock", "0");
		params.put("use_tool", "2");
		params.put("teacher_video", "1");
		
		Map<String, Object> dataMap = HttpTookit.doPost(url, params, null);
		
		
		return (String) dataMap.get("data");
	}
	
	public static void main(String[] args) {
		AboutClasses classes = new AboutClasses();
		boolean login = classes.login("18301423090", "0553qjj");
		
		if(login) {
			Map<String, List<String>> dataMap = new HashMap<String, List<String>>();
			List<String> dataList = new ArrayList<String>();
			dataList.add("07:00");
			dataList.add("07:20");
			
			List<String> dataList2 = new ArrayList<String>();
			dataList2.add("07:00");
			dataList2.add("07:20");
			dataMap.put("1568", dataList);
			dataMap.put("2139", dataList2);
			String tids = "1568,2139";
			boolean isTure = false;
			loop:
			for(String tid : tids.split(",")) {
				String text = "-1";
				while("-1".equals(text)) {
					
					text = classes.chooseTeacher(tid, dataMap);
					if("end".equals(text)) {
						break;
					}
					
					if("-1".equals(text)) {
						System.err.println("课程还未开始");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						continue;
					}
					String jsonData = classes.saveBook(text);
					System.out.println(jsonData);
					isTure = true;
					break loop;
				}
			}
			
			if(isTure) {
				System.out.println("订课成功");
			} else {
				System.out.println("您的老师课程都已经被预定");
			}
			
		} else {
			System.out.println("登录失败");
		}
	}
}
