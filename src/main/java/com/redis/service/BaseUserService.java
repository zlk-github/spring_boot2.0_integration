package com.redis.service;

import com.redis.mapper.BaseUserMapper;
import com.redis.model.po.BaseUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**desc:用户业务层
 * @author  zhoulk
 * date: 2019/4/25 0025
 */
@Service
//@CacheConfig(cacheNames = "baseUser")
public class BaseUserService {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private BaseUserMapper baseUserMapper;
    /**
     * 查询用户信息列表
     * @param baseUser 查询条件
     * @return 用户信息列表
     */
    @Cacheable( value = "baseUser",key = "'#p0'")
    public  List<BaseUser> queryUserList(BaseUser baseUser){
        logger.info("查询数据库数据：");
        return baseUserMapper.queryUserList(baseUser);
    }

    /**
     * 新增用户
     * @param baseUser 用户信息
     */
    @CachePut(value = "baseUser",key = "'#p0'")
    public void insertUser(BaseUser baseUser){
        baseUserMapper.insertUser(baseUser);
        logger.info("新增成功！");
    }

    /**
     * 修改用户
     * @param baseUser 用户信息
     */
    @CachePut(value = "baseUser",key = "'#p0'")
    public void updateUser(BaseUser baseUser)
    {
        baseUserMapper.updateUser(baseUser);
        logger.info("更新成功！");
    }

    /**
     * 删除用户
     * @param baseUser 用户id
     *
     */
    @CacheEvict(value="baseUser",allEntries=true)
    public void deleteUser(BaseUser baseUser){
        baseUserMapper.deleteUser(baseUser.getId());
        logger.info("删除成功！");
    }

    /**
     * 清空缓存
     * allEntries是boolean类型，表示是否需要清除缓存中的所有元素。默认为false，表示不需要。当指定了allEntries为true时，Spring Cache将忽略指定的key。有的时候我们需要Cache一下清除所有的元素，这比一个一个清除元素更有效率。
     * condition做筛选
     * key为键
     * value对应的cache
     *oreInvocation属性清除操作默认是在对应方法成功执行之后触发的，即方法如果因为抛出异常而未能成功返回时也不会触发清除操作。使用beforeInvocation可以改变触发清除操作的时间，当我们指定该属性值为true时，Spring会在调用该方法之前清除缓存中的指定元素。
     */
    @CacheEvict(value="baseUser",allEntries=true)
    //指定多个@Caching(evict={@CacheEvict(“a1”),@CacheEvict(“a2”,allEntries=true)})；
    // @CacheEvict(value="users", beforeInvocation=true,key = "'#p0'")
    public void cleanCache(BaseUser baseUser){
        logger.info("清空缓存！！！！！！");
    }

}
