package com.datastorage.oracle;

import com.util.JdbcUtil;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**不使用线程的情况下入库（100w）
 * @author  zhoulk
 * date: 2019/5/31 0031
 */
public class singleThread {

    /**
     * 批量提交的方式入库。
     */
    public static void batchSubmit(){
        long start = System.currentTimeMillis();
        Connection conn = JdbcUtil.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("insert into student (id,s_name,birthday,sex,s_desc) ");
        sql.append(" values");
        sql.append(" (stu_squ.nextval,?,?,?,?)");
        try {
            PreparedStatement pst = conn.prepareStatement(sql.toString());
            //conn.setAutoCommit(false);使用事务手动提交
            for (int i = 0; i <300000; i++) {
                String s_name = "李四"+i;
                pst.setObject(1, s_name);
                pst.setObject(2, new java.sql.Date(getDate().getTime()));
                pst.setObject(3, 1);
                pst.setObject(4, "描述");
                pst.addBatch();
                /*if(i%1000==0){
                   pst.addBatch();
                }*/
            }
            pst.executeBatch();
            long end = System.currentTimeMillis();
            System.out.println("批量插入需要时间:"+(end - start)+"ms");
            //批量插入需要时间:30W-42551ms
        }  catch (ParseException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtil.close(conn,null,null);
        }
    }

    private static Date getDate() throws ParseException {
        StringBuffer birthday = new StringBuffer("199");
        birthday.append((int)Math.random()*9);
        birthday.append("-0"+(1+(int)Math.random()*8));
        birthday.append("-"+(10+(int)Math.random()*20));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birthday.toString());
        return date;
    }

    /**
     * 单条提交。
     */
    public static void singleSubmit(){
        long start = System.currentTimeMillis();
        Connection conn = JdbcUtil.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("insert into student (id,s_name,birthday,sex,s_desc) ");
        sql.append(" values");
        sql.append(" (stu_squ.nextval,?,?,?,?)");
        try {
            PreparedStatement pst = conn.prepareStatement(sql.toString());
            //conn.setAutoCommit(false);使用事务手动提交
            for (int i = 0; i <300000; i++) {
                String s_name = "李四"+i;
                StringBuffer birthday = new StringBuffer("199");
                birthday.append((int)Math.random()*9);
                birthday.append("-0"+(1+(int)Math.random()*8));
                birthday.append("-"+(10+(int)Math.random()*20));
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(birthday.toString());

                pst.setObject(1, s_name);
                pst.setObject(2, new java.sql.Date(date.getTime()));
                pst.setObject(3, 1);
                pst.setObject(4, "描述");
                pst.execute();
            }

            long end = System.currentTimeMillis();
            System.out.println("单个插入需要时间:"+(end - start)+"ms");
            //插入需要时间:10W-10892ms,30w-263039ms
        }  catch (ParseException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtil.close(conn,null,null);
        }
    }

    /**
     * 单条提交。
     */
    public static void storedProcedureSubmit(){

    }

    public static void main(String[] args) {
        batchSubmit();
        //singleSubmit();
    }
}

