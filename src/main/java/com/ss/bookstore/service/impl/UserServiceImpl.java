package com.ss.bookstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ss.bookstore.entity.User;
import com.ss.bookstore.mapper.UserMapper;
import com.ss.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private UserMapper um;
    @Override
    public String getRole(String username) {
        return um.selectOne(new QueryWrapper<User>().eq("user_name",username)).getUserRole();
    }
    @Override
    public User getUser(User user) {
        return um.selectOne(
                new QueryWrapper<User>()
                        .eq("user_name",user.getUserName())
                    .eq("user_password",user.getUserPassword())
        );
    }
    @Cacheable(value = "user", key ="#id", unless = "#result==null")
    public String getUser(int id) {
        return stringRedisTemplate.opsForValue().get("goal");
    }
}