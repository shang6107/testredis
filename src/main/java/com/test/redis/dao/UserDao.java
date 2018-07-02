package com.test.redis.dao;

import com.test.redis.modal.User;

import java.util.List;

/**
 * @author 上官炳强
 * @description
 * @since 2018-06-30 / 03:12:59
 */
public interface UserDao {
    void add(User u);
    void delete(Integer id);
    void update(User u);
    User select(Integer id);
    List<User> getAll();
}
