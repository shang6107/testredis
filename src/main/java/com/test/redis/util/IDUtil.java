package com.test.redis.util;

import com.test.redis.modal.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 上官炳强
 * @description
 * @since 2018-06-30 / 03:20:11
 */
public class IDUtil {
    private static Integer getMaxIdFromList(List<User> list){
        List<Integer> ids = new ArrayList<>();
        for (User user : list) {
            ids.add(user.getId());
        }
        Collections.sort(ids);
        return ids.get(0);
    }
    public static void setId(List<User> list, User u){
        u.setId(getMaxIdFromList(list));
    }
}
