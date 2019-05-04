package com.redis.service;

import com.DemoApplication;
import com.redis.model.po.BaseUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * desc:用户业务类测试
 *
 * @author zhoulk
 *         Date:  2018/7/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class BaseUserServiceTest {

    @Autowired
    private BaseUserService baseUserService;

    @Test
    public void queryUserListTest(){
        List<BaseUser> userList = baseUserService.queryUserList(null);
        Assert.notNull(userList,"null");
    }

    @Test
    public void insertUserTest(){
        BaseUser baseUser = new BaseUser();
        baseUser.setAccount("zlk");
        baseUser.setPassword("123456");
        baseUser.setUserName("zzz");
        baseUser.setCreateUser(1);
        baseUser.setUpdateUser(1);
        baseUserService.insertUser(baseUser);
    }

    @Test
    public void updateUserTest(){
        BaseUser baseUser = new BaseUser();
        baseUser.setId(5);
        baseUser.setAccount("zlk1111");
        baseUser.setPassword("1234563234t4");
        baseUser.setUserName("zzz");
        baseUser.setCreateUser(1);
        baseUser.setUpdateUser(1);
        baseUserService.updateUser(baseUser);
    }
}
