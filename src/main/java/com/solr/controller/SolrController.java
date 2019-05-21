package com.solr.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.solr.bean.Foo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**solr操作层
 * @author  zhoulk
 * date: 2019/5/21 0021
 */
@RestController
@RequestMapping("/solr")
public class SolrController {

    @Autowired
    private SolrClient solrClient;

    private static final String SOLR_COLLECTION_USER = "foo";

    @RequestMapping("/addFoo")
    public void addFoo() {
        List<Foo> list = new ArrayList<>();
        list.add(new Foo("1001","第一标题"));
        list.add(new Foo("1002","第二标题"));
        try {
            solrClient.addBeans(list);
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryFoo")
    public  List<Foo> queryFoo() throws Exception {
        SolrQuery query = new SolrQuery();
        query.set("q", "id:1001");
       // QueryResponse response = solrClient.query(SOLR_COLLECTION_USER, query);
        QueryResponse response = solrClient.query(query);
        List<Foo> beans = response.getBeans(Foo.class);
        System.out.println("");
        return beans;
    }
}
