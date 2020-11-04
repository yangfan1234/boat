package com.boat.web.domain;

import lombok.Data;

/**
 * 用户实体
 * @author yangfan
 * @createTime 2020-08-03 16:35
 */
@Data
public class User {
    private String id;
    private String account;
    private String realName;
    private int gender;
    private int age;
    private int status;
}
