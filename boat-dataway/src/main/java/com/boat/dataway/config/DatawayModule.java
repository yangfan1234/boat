package com.boat.dataway.config;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 整合hasor，注入数据源
 * @author yangfan
 * @createTime 2020-10-19 21:23
 */
@Component
@DimModule
public class DatawayModule implements SpringModule {

    @Autowired
    private DataSource dataSource;

    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.installModule(new JdbcModule(Level.Full, dataSource));
    }
}
