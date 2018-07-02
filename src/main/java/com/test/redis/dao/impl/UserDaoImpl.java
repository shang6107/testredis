package com.test.redis.dao.impl;

import com.test.redis.dao.UserDao;
import com.test.redis.modal.User;
import com.test.redis.util.IDUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 上官炳强
 * @description
 * @since 2018-06-30 / 03:02:43
 */
@Repository
public class UserDaoImpl implements UserDao{

    private List<User> users = new ArrayList<User>(){{
        add(new User(1, "user1", true, "北京"));
        add(new User(2, "user2", true, "上海"));
        add(new User(3, "user3", false, "深圳"));
        add(new User(4, "user4", true, "广州"));
    }};

    @Override
    public void add(User u) {
        IDUtil.setId(users, u);
        users.add(u);
    }

    @Override
    public void delete(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public void update(User u) {
        delete(u.getId());
        users.add(u);
    }

    @Override
    public User select(Integer id) {
        for (User user : users) {
            if(user.getId().equals(id))
                return user;
        }
        return null;
    }

    @Override
    public List<User> getAll() {

        return users;
    }
}
