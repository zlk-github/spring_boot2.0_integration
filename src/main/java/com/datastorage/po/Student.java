package com.datastorage.po;

import java.sql.Date;

/**学生实体类
 * @author  zhoulk
 * date: 2019/5/31 0031
 */
public class Student {

    /**学号*/
    private Integer id;
    /**姓名**/
    private String sName;
    /**生日**/
    private Date birthday;
    /**性别**/
    private Integer sex;
    /**描述**/
    private String s_desc;

    public Student(Integer id, String sName, Date birthday, Integer sex, String s_desc) {
        this.id = id;
        this.sName = sName;
        this.birthday = birthday;
        this.sex = sex;
        this.s_desc = s_desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getS_desc() {
        return s_desc;
    }

    public void setS_desc(String s_desc) {
        this.s_desc = s_desc;
    }
}
