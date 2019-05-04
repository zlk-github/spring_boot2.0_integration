package com.redis.mapper;

import com.redis.model.po.BaseUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**desc:用户dao接口
 * @author  zhoulk
 * date: 2019/4/25 0025
 * 注:或者不用@Mapper ，在启动类上加@MapperScan(basePackages ={"com.*.mapper"})
 */
@Mapper
public interface BaseUserMapper {
    /**
     * 查询用户信息列表
     * @CachePut(value = "user", key = "#root.targetClass + #result.username", unless = "#person eq null")
     * @param baseUser 查询条件
     * @return 用户信息列表
     */
     List<BaseUser> queryUserList(BaseUser baseUser);

    /**
     * 新增用户
     * @param baseUser 用户信息
     */
     void insertUser(BaseUser baseUser);

    /**
     * 修改用户
     * @param baseUser 用户信息
     */
    void updateUser(BaseUser baseUser);


    /**
     * oreInvocation属性
     清除操作默认是在对应方法成功执行之后触发的，即方法如果因为抛出异常而未能成功返回时也不会触发清除操作。使用beforeInvocation可以改变触发清除操作的时间，当我们指定该属性值为true时，Spring会在调用该方法之前清除缓存中的指定元素。
     * @param id
     */
    void deleteUser(Integer id);
}
