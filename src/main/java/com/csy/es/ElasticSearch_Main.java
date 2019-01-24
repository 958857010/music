package com.csy.es;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;

/**
 * //
 * //                       _oo0oo_
 * //                      o8888888o
 * //                      88" . "88
 * //                      (| -_- |)
 * //                      0\  =  /0
 * //                    ___/`---'\___
 * //                  .' \\|     |// '.
 * //                 / \\|||  :  |||// \
 * //                / _||||| -:- |||||- \
 * //               |   | \\\  -  /// |   |
 * //               | \_|  ''\---/''  |_/ |
 * //               \  .-\__  '-'  ___/-. /
 * //             ___'. .'  /--.--\  `. .'___
 * //          ."" '<  `.___\_<|>_/___.' >' "".
 * //         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * //         \  \ `_.   \_ __\ /__ _/   .-` /  /
 * //     =====`-.____`.___ \_____/___.-`___.-'=====
 * //                       `=---='
 * //
 * //
 * //     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * //
 * //               佛祖保佑         永无BUG
 * //
 */
public class ElasticSearch_Main {
    public static String host="39.105.189.141";
    public static void main(String[] args) throws UnknownHostException {
        //1.创建配置对象
        Settings settings = Settings.builder().put("cluster.name","qfjava").build();
        //2.创建客户端对象
        Client client = new PreBuiltTransportClient(settings).addTransportAddress(new TransportAddress(InetAddress.getByName(host),9300));
        //3.新增索引
        User user1 = new User();
        user1.setId(11);
        user1.setPhone("13333333333");
        user1.setFlag(1);
        //新增数据 如果对应的ID存在就是修改数据  参数说明：1。索引名称 唯一 2。数据对应的类型名称 3。对应数据的唯一标记 id
        //setSource 设置需要添加的数据源  参数说明：1。对应的json格式的数据内容 2。添加的数据格式
        IndexResponse indexResponse = client.prepareIndex("1806users","user",user1.getId()+"").setSource(JSON.toJSONString(user1), XContentType.JSON).get();
        System.out.println("新增数据："+indexResponse.status().toString());

        //修改
        User user2 = new User();
        user2.setId(11);
        user2.setPhone("13333336666");
        user2.setFlag(1);
        UpdateResponse updateResponse = client.prepareUpdate("1806users","user",user2.getId()+"").setDoc(JSON.toJSONString(user2), XContentType.JSON).get();
        System.out.println("修改数据："+updateResponse.status().toString());

        //删除
        DeleteResponse deleteResponse = client.prepareDelete("1806users","user","1001").get();
        System.out.println("删除数据："+deleteResponse.status().toString());

        //查询
        GetResponse getResponse = client.prepareGet("1806users","user","1").get();
        System.out.println("查询数据："+getResponse.getSourceAsString());

        //复杂查询
        SearchResponse searchResponse = client.prepareSearch("1806users").setQuery(QueryBuilders.matchAllQuery()).addSort("id", SortOrder.DESC).get();
        //获取查询的结果集
        SearchHits searchHits = searchResponse.getHits();
        System.out.println("数量："+searchHits.totalHits);
        Iterator<SearchHit> hitsIterator = searchHits.iterator();
        while (hitsIterator.hasNext()){
            SearchHit searchHit = hitsIterator.next();
            System.out.println("结果："+searchHit.getSourceAsString());
        }

        //相似度查询 fuzzyQuery
        SearchResponse searchResponse1 = client.prepareSearch("1806users").setQuery(QueryBuilders.fuzzyQuery("phone","6")).addSort("id", SortOrder.DESC).get();
        //获取查询的结果集
        SearchHits searchHits1 = searchResponse1.getHits();
        System.out.println("数量："+searchHits1.totalHits);
        Iterator<SearchHit> hitsIterator1 = searchHits1.iterator();
        while (hitsIterator1.hasNext()){
            SearchHit searchHit = hitsIterator1.next();
            System.out.println("结果："+searchHit.getSourceAsString());
        }

        //模糊查询 wildcardQuery
        //matchQuery 支持中文分词
        //rangeQuery 范围查询
        SearchResponse searchResponse2 = client.prepareSearch("1806users").setQuery(QueryBuilders.wildcardQuery("phone","*6*")).addSort("id", SortOrder.DESC).get();
        //获取查询的结果集
        SearchHits searchHits2 = searchResponse2.getHits();
        System.out.println("数量："+searchHits2.totalHits);
        Iterator<SearchHit> hitsIterator2 = searchHits2.iterator();
        while (hitsIterator2.hasNext()){
            SearchHit searchHit = hitsIterator2.next();
            System.out.println("结果："+searchHit.getSourceAsString());
        }

    }
}
