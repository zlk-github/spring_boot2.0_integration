package com.redis.controller;

import com.redis.model.po.BaseUser;
import com.redis.service.BaseUserService;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**desc:用户业务层
 * @author  zhoulk
 * date: 2019/4/25 0025
 */
@RestController
@RequestMapping("/baseUser")
public class BaseUserController {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private BaseUserService baseUserService;

    @Value("${server.port}")
    private  String port;

    /**
     * 查询用户信息列表
     * @CachePut(value = "user", key = "#root.targetClass + #result.username", unless = "#person eq null")
     * @param baseUser 查询条件
     * @return 用户信息列表
     */
    @RequestMapping("/queryUserList")
    public  String  queryUserList(BaseUser baseUser, HttpServletResponse response, HttpServletRequest request)
    {
        response.setHeader("Access-Control-Allow-Origin",  request.getHeader("Origin"));
        response.addHeader("Access-Control-Allow-Credentials", "true");

        List<BaseUser> list = baseUserService.queryUserList(baseUser);
        return "端口"+port+"；"+list.toString();
    }

    /**
     * 新增用户
     * @param baseUser 用户信息
     */
    @RequestMapping("/insertUser")
    public String insertUser(BaseUser baseUser){
        baseUserService.insertUser(baseUser);
        return "新增成功";
    }

    /**
     * 修改用户
     * @param baseUser 用户信息
     */
    @RequestMapping("/updateUser")
    public String updateUser(BaseUser baseUser){
        baseUserService.updateUser(baseUser);
        return "修改成功";
    }

    /**
     * 删除用户
     * @param baseUser 用户
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(BaseUser baseUser){
        baseUserService.deleteUser(baseUser);
        return "删除成功";
    }

    /**
     * 清除缓存
     */
    @RequestMapping("/cleanCache")
    public String cleanCache(BaseUser baseUser){
        baseUserService.cleanCache( baseUser);
        return "缓存清除成功！";
    }
}
