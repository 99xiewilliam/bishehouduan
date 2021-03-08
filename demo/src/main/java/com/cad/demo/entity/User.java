package com.cad.demo.entity;

import com.cad.demo.annotation.Phone;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class User {

    private Integer id;
    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空")
    private String uname;
    @Phone
    private String phone;
    private String password;
    @Max(value = 1, message = "性别设置有误")
    @Min(value = 0, message = "性别设置有误")
    private Integer gender;

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUname() {
        return uname;
    }

    private Integer state;
    private Integer is_deleted;
    private String create_time;
    private String update_time;
}
