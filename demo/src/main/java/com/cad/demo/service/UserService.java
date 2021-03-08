package com.cad.demo.service;


import com.cad.demo.common.MyPage;
import com.cad.demo.entity.User;
import com.cad.demo.entity.vo.UserVO;

import java.util.List;

public interface UserService {
    boolean addUser(User user);

    MyPage<UserVO> getUsers(User user, int page, int size);

    boolean deleteUser(Integer id);

    boolean updateUser(User user);

}
