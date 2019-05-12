package com.mongondb.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


/**desc:MongoDBJDBC连接类
 * @author  zhoulk
 * date: 2019/5/7 0007
 * https://blog.csdn.net/qq_36760753/article/details/81149077#commentBox
 */
public class MongoDBJDBC {
    /**数据库*/
    private String dataBase;
    /**ip地址*/
    private String ip;
    /**端口*/
    private Integer port;

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    /**获奖对应数据库连接
     * @param mongo 连接信息
     * @return 连接信息
     */
    public static MongoDatabase getConnect(MongoDBJDBC mongo){
        MongoDatabase mongoDatabase = null;
        try{
            //连接mongon服务
            MongoClient mongoClient = new MongoClient(mongo.getIp(),mongo.getPort());
            //连接数据库
            mongoDatabase = mongoClient.getDatabase(mongo.getDataBase());
            System.out.println("连接数据库：\""+mongo.getDataBase()+"\"成功。");

            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功;集合如下。");

            for (String name : mongoDatabase.listCollectionNames()) {
                System.out.println("+++++++++++++++++");
                System.out.println(name);
                System.out.println("+++++++++++++++++");
            }

        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("连接数据库：\""+mongo.getDataBase()+"\"失败。");
        }
        return mongoDatabase;
    }

    public static void main(String[] args) {
        MongoDBJDBC mongo = new MongoDBJDBC();
        mongo.setIp("localhost");
        mongo.setPort(27017);
        mongo.setDataBase("myLocalhost");

        MongoDBJDBC.getConnect(mongo);
    }

}
