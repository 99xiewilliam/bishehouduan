package com.cad.demo.service.impl;

import com.cad.demo.common.MyPage;
import com.cad.demo.dao.UserDAO;
import com.cad.demo.entity.User;
import com.cad.demo.entity.vo.UserVO;
import com.cad.demo.exception.GlobalException;
import com.cad.demo.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean addUser(User user) {
        int flag = 0;
        try {
            flag = userDAO.addUser(user);
        } catch (DataAccessException e) {
            System.out.println(e);
            throw new GlobalException(500, "用户名已存在");
        }
        return flag != 0;
    }

    @Override
    public MyPage<UserVO> getUsers(User user, int page, int size) {
        if (user.getUname() != null) {
            user.setUname("%" + user.getUname() + "%");
        }
        PageHelper.startPage(page, size);
        List<UserVO> users = userDAO.getUsers(user);
        PageInfo<UserVO> pageInfo = new PageInfo<>(users);
        return new MyPage<UserVO>(pageInfo);
    }

    @Override
    public boolean deleteUser(Integer id) {
        int flag = userDAO.deleteUser(id);
        return flag != 0;
    }

    @Override
    public boolean updateUser(User user) {
        int flag = 0;
        try {
            flag = userDAO.updateUser(user);
        } catch (DataAccessException e) {
            System.out.println(e);
            throw new GlobalException(500, "用户名已存在");
        }
        return flag != 0;
    }

}
