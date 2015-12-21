package com.shma;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
 
public class SolrJUtils {
 
	
    public static void search() {
    	SolrClient solr = new HttpSolrClient("http://121.201.62.60:8083/solr/mycore");  
        SolrQuery params = new SolrQuery();
        // 查询关键词，*:*代表所有属性、所有值，即所有index
        // params.set("q", "*:*");
        params.set("q", "*:*");// 查询nickname是已chm开头的数据
 
        // 分页，start=0就是从0开始，，rows=5当前返回5条记录，第二页就是变化start这个值为5就可以了。
        params.set("start", 0);
        params.set("rows", Integer.MAX_VALUE);
 
        // 按nickname排序，asc升序 desc降序
//        params.set("sort", "nickname asc");
 
        try {
            QueryResponse rsp = solr.query(params);
            SolrDocumentList docs = rsp.getResults();
            System.out.println("文档个数：" + docs.getNumFound());
            System.out.println("查询时间：" + rsp.getQTime());
            for (SolrDocument doc : docs) {
                System.out.println(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
    public static void main(String[] args) {
        SolrJUtils.search();//实际应用过程中可以根据自身需要传参
    }
}
