package com.reserve.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**用户实体类,类名称与字段名称要与数据库表名一致。也可以自定义xml取别名使用
 * @author zhoulk
 *         Date:  2018/4/4.
 */
@Getter @Setter @ToString
public class BUser implements Serializable {
    /**用户编号*/
    private Long userId;
    /**用户名*/
    private String userName;
    /**密码*/
    private String password;
    /**联系电话*/
    private String phone;

    public BUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}