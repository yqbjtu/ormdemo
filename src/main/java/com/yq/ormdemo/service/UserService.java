package com.yq.ormdemo.service;

/**
 * Created by EricYang on 2021/2/17.
 */

import com.yq.ormdemo.domain.User;
import io.ebean.EbeanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service
 */
@Service
public class UserService {

    @Autowired
    private EbeanServer ebeanServer;

    public List<User> getAll() {
        return ebeanServer.find(User.class).findList();
    }

    public User getById(Integer id) {
        return ebeanServer.find(User.class).where().eq("id", id).findOne();
    }

    /**
     * 删除用户
     * 对象不存在,删除失败,返回假.
     *
     * @param id
     * @return
     */
    public boolean delete(Integer id) {
        User user = getById(id);
        if (user != null) {
            return ebeanServer.delete(user);
        }
        return false;
    }
}
