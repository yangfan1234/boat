package com.boat.model.po.core;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户表
 *
 * @author yangfan
 * @@version 1.0
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value="User对象", description="用户表")
@TableName("tb_user")
public class User {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码，加密存储")
    private String password;

    @ApiModelProperty(value = "注册手机号")
    private String phone;

    @ApiModelProperty(value = "注册邮箱")
    private String email;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime created;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updated;

}
