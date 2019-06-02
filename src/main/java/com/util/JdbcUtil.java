package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**数据库连接类
 * @author  zhoulk
 * date: 2019/5/31 0031
 */
public class JdbcUtil {
    private static final String DRIVER = getValue("jdbc.driver");
    private static final String URL = getValue("jdbc.url");
    private static final String USER = getValue("jdbc.username");
    private static final String PASSWORD = getValue("jdbc.password");

    static{
        // 加载驱动
        try {
            //oracle.jdbc.driver.OracleDriver; com.mysql.jdbc.Driver
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败！"+e.getMessage());
        }
    }

    /**
     * 连接数据库对象
     * @return Connection 连接对象
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            //jdbc:oracle:thin:@localhost:1521:ORCL; jdbc:mysql://@localhost:3306/dbName
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("数据库连接失败！"+e.getMessage());
        }
        return conn;
    }

    /**获取文件中的数据库连接配置信息
     * @param key 键
     * @return 值
     */
    private static String getValue(String key){
        //方式一：
        //ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        //return bundle.getString(key);
        InputStream in = JdbcUtil.class.getResourceAsStream("/jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

    /**
     * 关闭连接
     * @param conn 连接对象
     * @param stmt 创建sql语句对象
     * @param rs 执行sql语句对象
     */
    public static void close(Connection conn , Statement stmt, ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("关闭资源失败！"+e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
