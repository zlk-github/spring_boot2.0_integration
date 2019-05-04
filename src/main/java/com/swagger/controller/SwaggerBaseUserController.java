package com.swagger.controller;

import com.redis.model.po.BaseUser;
import com.redis.service.BaseUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**desc:用户业务层
 * @author  zhoulk
 * date: 2019/4/25 0025
 */
@Api(value = "BaseUserController|一个用来测试swagger注解的控制器")
@RestController
@RequestMapping("/swaggerBaseUser")
public class SwaggerBaseUserController {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private BaseUserService baseUserService;

    /**
     * 查询用户信息列表
     * @param baseUser 查询条件
     * @return 用户信息列表
     */
    @RequestMapping(value ="/queryUserList", method= RequestMethod.POST)
    @ApiOperation(value="查询用户列表，支持账号模糊查询。", notes="test: list")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "account", value = "账号",  dataType = "String")
    })
    public  List<BaseUser> queryUserList(BaseUser baseUser)
    {
        List<BaseUser> list = baseUserService.queryUserList(baseUser);
        return list;
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
