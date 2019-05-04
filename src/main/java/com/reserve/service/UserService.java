/*
package com.reserve.service;

import com.reserve.dao.UserDao;
import com.reserve.model.BUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * desc:
 *
 * @author zhoulk
 *         Date:  2018/7/18.
 *//*

@Service("userService")
public class UserService {

    @Autowired
    private RedisTemplate<String, BUser> redisTemplate;

    @Autowired
    private UserDao userDao;


    public List<BUser> userList() {
        return userDao.all();
    }

    public List<BUser> allUser() {
        return userDao.allUser();
    }

    public BUser findByName(String userName){
        Map<String, Object> paras = new HashMap<>(1);
        paras.put("userName", userName);
        return userDao.findByName(paras);
    }

    public void save(BUser user){
        Map<String, Object> paras = new HashMap<>(1);
        paras.put("userName", user.getUserName());
        paras.put("password", user.getPassword());
        userDao.save(paras);
    }

}*/
