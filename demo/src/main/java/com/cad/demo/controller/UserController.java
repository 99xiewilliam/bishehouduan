package com.cad.demo.controller;

import com.cad.demo.common.MyPage;
import com.cad.demo.common.RetResult;
import com.cad.demo.entity.User;
import com.cad.demo.entity.vo.UserVO;
import com.cad.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public RetResult getUsers(@ModelAttribute User user, Integer page, Integer size) {
        System.out.println(page + " " + size);
        System.out.println(user);
        if (page == null) page = 1;
        if (size == null || size == 0) size = 7;
        MyPage<UserVO> users = userService.getUsers(user, page, size);
        return new RetResult(0, users);
    }

    @DeleteMapping("/{id}")
    public RetResult deleteUser(@PathVariable @NotNull(message = "用户id有误") Integer id) {
        if (userService.deleteUser(id)) {
            return new RetResult(0, "删除成功");
        }
        return new RetResult(500, "删除失败");
    }

    @PostMapping("")
    public RetResult addUser(@RequestBody @Validated User user) {
        if (userService.addUser(user)) {
            return new RetResult(0, "添加成功");
        }
        return new RetResult(500, "添加失败");

    }

    @PutMapping("/{id}")
    public RetResult updateUser(@PathVariable @NotNull(message = "参数有误") Integer id, @RequestBody @Validated User user) {
        if(userService.updateUser(user)){
            return new RetResult(0, "更新成功");
        }
        return new RetResult(500, "更新失败");
    }
}
