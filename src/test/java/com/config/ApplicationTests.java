package com.config;

import com.reserve.model.BUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/*
 * desc:
 *
 * @author zhoulk
 *         Date:  2018/7/23.


/*

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private RedisTemplate<String, BUser> redisTemplate;

    @Autowired
    private UserService userService;

    @Before
    public void before() {
        userService.save(new BUser("AAA", "123456"));
    }

    @Test
    public void test() throws Exception {

        // 保存对象
        List<BUser> userList = userService.userList();
        userList.forEach((user)->redisTemplate.opsForValue().set(user.getUserId().toString(), user));
        System.out.println("第一次查询！");
        // 保存对象
        userService.userList();
        System.out.println("第二次查询！");
        Assert.assertEquals("1001", redisTemplate.opsForValue().get("1001").getUserId().toString());
    }

    @Test
    public void test1() throws Exception {
        BUser u1 = userService.findByName("admin");
        System.out.println("第一次查询：" + u1.getUserName());

        BUser u2 = userService.findByName("admin");
        System.out.println("第二次查询：" + u2.getUserName());
    }

}

*/
