package com.suray.wcsgui.dbopr.service;

import com.suray.wcsgui.dbopr.dao.UserDao;
import com.suray.wcsgui.dbopr.entity.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Charles on 2018/7/27.
 */
@Service("userService")
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    public UserDB login(String username, String password) {
        UserDB user = new UserDB();
        user.setUsername(username);
        user.setPassword(password);
        List<UserDB> list = userDao.findAll(Example.of(user));
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 用户名查重
     *
     * @param username
     * @return
     */
    public boolean checkUsernameUnique(String username) {
        UserDB user = new UserDB();
        user.setUsername(username);
        List<UserDB> list = userDao.findAll(Example.of(user));
        return list.isEmpty();
    }

    /**
     * 添加用户
     *
     * @param username
     * @param password
     */
    public void addUser(UserDB manager, String username, String password) {
        if (!manager.getManager()) {
            throw new IllegalStateException("非管理员禁止此操作");
        }
        UserDB user = new UserDB();
        user.setUsername(username);
        user.setPassword(password);
        user.setManager(false);
        user.setRegTime(new Date());
        user.setUpdateTime(new Date());
        user.setUpdateId(manager.getId());
        userDao.save(user);
    }
}
