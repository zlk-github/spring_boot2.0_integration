package com.reserve.dao;

import com.reserve.model.BUser;
//import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * desc:用户dao接口，继承BaseMapper接口
 *
 * @author zhoulk
 *         Date:  2018/7/18.
 */
/*@CacheConfig(cacheNames = "users")
public interface UserDao extends BaseMapper<BUser> {
    List<BUser> allUser();

    @Cacheable(key = "#p0")
    public BUser findByName(Map<String,Object> paras);

    @CachePut(key = "#p0.userId")
    public BUser save(Map<String,Object> paras);
}*/
