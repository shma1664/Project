package com.abc360.classes.util;

import org.htmlparser.Node;  
import org.htmlparser.NodeFilter;  
import org.htmlparser.Parser;  
import org.htmlparser.filters.TagNameFilter;  
import org.htmlparser.tags.TableTag;  
import org.htmlparser.util.NodeList;  
  
/** 
* 标题:利用htmlparser提取网页纯文本的例子 
*/  
public class TestHTMLParser {  
	
  public static void testHtml() {  
    try {  
        String sCurrentLine;  
        String sTotalString;  
        sCurrentLine = "";  
        sTotalString = "";  
        java.io.InputStream l_urlStream;  
        java.net.URL l_url = new java.net.URL("http://www.ideagrace.com/html/doc/2006/07/04/00929.html");  
        java.net.HttpURLConnection l_connection = (java.net.HttpURLConnection) l_url.openConnection();  
        l_connection.connect();  
        l_urlStream = l_connection.getInputStream();  
        java.io.BufferedReader l_reader = new java.io.BufferedReader(new java.io.InputStreamReader(l_urlStream));  
        while ((sCurrentLine = l_reader.readLine()) != null) {  
          sTotalString += sCurrentLine+"\r\n";  
        //  System.out.println(sTotalString);  
        }  
        String testText = extractText(sTotalString);  
        System.out.println( testText );  
  
    } catch (Exception e) {  
        e.printStackTrace();  
    }  
  
  }  
   
  public static String extractText(String inputHtml) throws Exception {  
    StringBuffer text = new StringBuffer();  
    Parser parser = Parser.createParser(new String(inputHtml.getBytes(),"GBK"), "GBK");  
    // 遍历所有的节点  
    NodeList nodes = parser.extractAllNodesThatMatch(new NodeFilter() {  
        public boolean accept(Node node) {  
          return true;  
        }  
    });  
  
    System.out.println(nodes.size()); //打印节点的数量  
    for (int i=0;i<nodes.size();i++){  
         Node nodet = nodes.elementAt(i);  
         //System.out.println(nodet.getText());   
        text.append(new String(nodet.toPlainTextString().getBytes("GBK"))+"\r\n");            
    }  
    return text.toString();  
  }  
   
  public static void test5(String resource) throws Exception {  
    Parser myParser = new Parser(resource);  
    myParser.setEncoding("GBK");  
    String filterStr = "table";  
    NodeFilter filter = new TagNameFilter(filterStr);  
    NodeList nodeList = myParser.extractAllNodesThatMatch(filter);  
    TableTag tabletag = (TableTag) nodeList.elementAt(11);  
       
  }  
  
  public static void main(String[] args) throws Exception {  
    // test5("http://www.ggdig.com");  
    testHtml();  
  }  
}
