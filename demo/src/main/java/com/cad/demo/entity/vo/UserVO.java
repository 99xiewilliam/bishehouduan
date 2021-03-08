package com.cad.demo.entity.vo;

import lombok.Data;

@Data
public class UserVO {
    private Integer id;
    private String uname;
    private String phone;
    private Integer gender;
    private int state;
    private String update_time;
}
