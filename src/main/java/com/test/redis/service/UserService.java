package com.test.redis.service;

import com.test.redis.modal.User;

import java.util.List;
import java.util.Map;

/**
 * @author 上官炳强
 * @description
 * @since 2018-06-30 / 03:29:46
 */
public interface UserService {
    void add(User u);
    void delete(Integer id);
    void update(User u);
    User select(Integer id);
    List<User> getAll();
}
