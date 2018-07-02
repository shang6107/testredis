package com.test.redis.service.impl;

import com.test.redis.dao.UserDao;
import com.test.redis.modal.User;
import com.test.redis.service.UserService;
import com.test.redis.util.SerializeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 上官炳强
 * @description
 * @since 2018-06-30 / 03:30:25
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate<byte[], byte[]> redisTemplate;

    @Autowired
    private SerializeUtil<User> serializeUtil;

    @Override
    public void add(User u) {
        userDao.add(u);
        log.info("insert user {} success!", u.getName());
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
        log.info("delete user {} success!", id);
    }

    @Override
    public void update(User u) {
        userDao.update(u);
        log.info("update user {} success!", u.getName());
    }

    @Override
    public User select(Integer id) {
        User select = userDao.select(id);
        if (select == null) {
            log.info("get user : {}", select);
            return null;
        }
        log.info("get user : {}", select.getName());
        return select;
    }

    @Override
    public List<User> getAll() {
        ListOperations<byte[], byte[]> list = redisTemplate.opsForList();

        List<byte[]> range = list.range("all".getBytes(), 1, 10);
        if (range.size() > 0) {
            log.info("get users from redis : {}", range.size());
            List<User> cacheUsers = serializeUtil.unserializeList(range);
            return cacheUsers;
        }

        List<User> dbUsers = userDao.getAll();
        List<byte[]> usersByte = serializeUtil.serializeList(dbUsers);
        System.out.println(usersByte);
        list.leftPushAll("all".getBytes(), usersByte);
        log.info("get all from db : {}", dbUsers.size());
        return dbUsers;
    }
}
