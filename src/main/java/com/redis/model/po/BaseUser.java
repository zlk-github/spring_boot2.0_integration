package com.redis.model.po;

import java.io.Serializable;

/**用户实体
 * @author  zhoulk
 * date: 2019/4/25 0025
 */
public class BaseUser implements Serializable{
     /**编号id*/
    private Integer id;
    /**账号*/
    private String  account;
    /**密码*/
    private String password;
    /**用户姓名*/
     private String userName;
    /**性别，1男，2女*/
    private Integer sex;
    /**描述*/
    private String remark;
    /**创建人*/
    private Integer createUser;
    /**创建时间 */
    private String createTime;
    /**修改人*/
    private Integer updateUser;
    /**修改时间*/
    private String updateTime;

    public BaseUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BaseUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", remark='" + remark + '\'' +
                ", createUser=" + createUser +
                ", createTime='" + createTime + '\'' +
                ", updateUser=" + updateUser +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
