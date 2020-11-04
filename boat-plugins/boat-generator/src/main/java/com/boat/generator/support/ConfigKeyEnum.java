package com.boat.generator.support;

import com.baomidou.mybatisplus.annotation.IdType;

/**
 * 配置文件的key
 *
 * @author yangfan
 * @since 2020-09-20 08:17:46
 */
public enum ConfigKeyEnum {

    /**
     *  数据源连接URL
     */
    DsUrl("jdbc.url"),

    /**
     *  数据源连接驱动信息
     */
    DsDriver("jdbc.driver"),

    /**
     *  数据源连接用户
     */
    DsUser("jdbc.username"),

    /**
     *  数据源连接密码
     */
    DsPwd("jdbc.password"),

    /**
     *  子项目模块名称
     */
    projectModule("project.name"),

    /**
     *  是否启用swagger
     */
    swagger("gc.swagger"),

    /**
     *  ID类型
     * @see IdType
     */
    idType("gc.idType"),

    /**
     *  作者
     */
    author("gc.author"),

    /**
     *  包名
     */
    pkgName("pkg.fullName"),

    /**
     *  实体父类
     */
    superEntityClass("strategy.superEntityClass"),

    /**
     *  控制器父类
     */
    superControllerClass("strategy.superControllerClass"),

    /**
     *  写于父类的字段
     */
    superEntityColumns("strategy.superEntityColumns"),

    /**
     *  表名，多个用逗号分隔
     */
    tables("strategy.tables"),

    /**
     *  表名前缀
     */
    tablePrefix("strategy.tablePrefix");

    private String key;

    ConfigKeyEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
