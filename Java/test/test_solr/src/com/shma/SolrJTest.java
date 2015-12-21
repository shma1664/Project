package com.shma;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.FieldAnalysisRequest;
import org.apache.solr.client.solrj.response.AnalysisResponseBase.AnalysisPhase;
import org.apache.solr.client.solrj.response.AnalysisResponseBase.TokenInfo;
import org.apache.solr.client.solrj.response.FieldAnalysisResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SolrPingResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse.Suggestion;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.junit.Test;

public class SolrJTest {
	
	/**
     * 给指定的语句分词。
     * 
     * @param sentence 被分词的语句
     * @return 分词结果
     */
	@Test
    public void getAnalysis() {
      
		SolrClient solr = new HttpSolrClient("http://121.201.62.60:8083/solr/mycore");  
		
		FieldAnalysisRequest request = new FieldAnalysisRequest(
                "/analysis/field");
        request.addFieldName("autocomplete");// 字段名，随便指定一个支持中文分词的字段
        request.setFieldValue("");// 字段值，可以为空字符串，但是需要显式指定此参数
        request.setQuery("我是中国人");
       
        FieldAnalysisResponse response = null;
        try {
            response = request.process(solr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> results = new ArrayList<String>();
        Iterator<AnalysisPhase> it = response.getFieldNameAnalysis("autocomplete")
                .getQueryPhases().iterator();
        while(it.hasNext()) {
          AnalysisPhase pharse = (AnalysisPhase)it.next();
          List<TokenInfo> list = pharse.getTokens();
          for (TokenInfo info : list) {
              results.add(info.getText());
          }

        }
        System.out.println(results);
    }


	@Test
	public void createSolrClient() {
		try {  
            SolrClient solr = new HttpSolrClient("http://localhost/solr/searchanc");  
            SolrPingResponse  response = solr.ping();  
            //打印执行时间  
            System.out.println(response.getElapsedTime());  
            solr.close();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
	
	/** 
     * 增加bean索引,该bean中的字段需要匹配schema中的fields,(可以用@Field注解来关联相关字段) 
     * 否者抛出org.apache.solr.client.solrj.beans.BindingException: class: class com.ccy.solr.Blog does not define any fields. 
     * @throws Exception  
     */  
   @Test  
   public void addBeanIndex() throws Exception{  
       SolrClient solr = new HttpSolrClient("http://localhost/solr/searchanc");  
       Bean bean = new Bean();
       bean.setId(12312);
       bean.setContent("我是中国人");
       bean.setOnline(1);
       bean.setType(1);
       bean.setWeight(29);
       UpdateResponse response = solr.addBean(bean);  
       System.out.println(response.getElapsedTime());  
       solr.commit();  
       solr.close();  
   }
   
   /** 
    * 增加索引 
    *  
    * @throws Exception 
    */  
   @Test  
   public void addIndex() throws Exception{  
       SolrClient solr = new HttpSolrClient("http://121.201.62.60:8083/solr/mycore");  
       SolrInputDocument document = new SolrInputDocument();  
       document.addField("id",994788);  
       document.addField("content", "成就");  
       document.addField("type", 2);
       document.addField("weight", 80);
       document.addField("online", 1);
       UpdateResponse response = solr.add(document);  
       System.out.println(response.getElapsedTime());  
       solr.commit();  
       solr.close();  
   }  
      
     
     
   /** 
    * 删除索引 
    */  
   @Test  
   public void delIndex() throws Exception{  
       SolrClient solr = new HttpSolrClient("http://localhost/solr/mycore");  
       UpdateResponse response = solr.deleteById("123");  
       System.out.println(response.getElapsedTime());  
       solr.commit();  
       solr.close();  
   }  
     
   /** 
    * 简单查询 
    * @throws IOException  
    * @throws SolrServerException  
    */  
   @Test  
   public void query() throws Exception{  
       SolrClient solr = new HttpSolrClient("http://121.201.62.60:8083/solr/mycore");  
       Map<String, String> map = new HashMap<String, String>();  
       map.put("q", "autocomplete:402021");  
       SolrParams params = new MapSolrParams(map);  
       QueryResponse resp = solr.query(params);
       //以下是第二种方法  
       //String queryString="content:test";  
       //MultiMapSolrParams mParams = SolrRequestParsers.parseQueryString("queryString");  
       //QueryResponse resp = solr.query(mParams);  
       SolrDocumentList docsList = resp.getResults();  
       System.out.println(docsList.size());  
       for (SolrDocument doc : docsList) {  
            System.out.println(doc);  
       }  
       solr.close();  
   }
   
   @Test
   public void suggest() throws Exception {
	   SolrClient solr = new HttpSolrClient("http://localhost/solr/mycore");  
	   SolrQuery query = new SolrQuery();
		String token = "*";
		query.set("qt", "/suggest");
		query.set("q", token);
		query.set("spellcheck.build", "true");
		QueryResponse response = null;

		try {
			response = solr.query(query);
			System.out.println("查询耗时：" + response.getQTime());
		} catch (SolrServerException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
		}

		SpellCheckResponse spellCheckResponse = response.getSpellCheckResponse();
		if (spellCheckResponse != null) {
			List<Suggestion> suggestionList = spellCheckResponse.getSuggestions();
			for (Suggestion suggestion : suggestionList) {
				System.out.println("Suggestions NumFound: "
						+ suggestion.getNumFound());
				System.out.println("Token: " + suggestion.getToken());
				System.out.print("Suggested: ");
				List<String> suggestedWordList = suggestion.getAlternatives();
				for (String word : suggestedWordList) {
					System.out.println(word + ", ");
				}
				System.out.println();
			}
		}
   }

}
