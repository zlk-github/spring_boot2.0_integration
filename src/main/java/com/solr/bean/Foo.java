package com.solr.bean;

import lombok.Getter;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**SolrJ实体接收Bean
 * @author  zhoulk
 * date: 2019/5/21 0021
 */
@Getter
@Setter
public class Foo implements Serializable{
    //必须实现可序列化接口，要在网络上传输
    @Field("id")
    private String id;

    @Field("title")
    private String title;

    public Foo(String id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
