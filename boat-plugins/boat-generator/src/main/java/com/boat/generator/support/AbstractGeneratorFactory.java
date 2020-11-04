package com.boat.generator.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 代码生成器抽象类，集成了配置信息加载
 *
 * @author yangfan
 * @createTime 2020-09-20 18:26
 */
public abstract class AbstractGeneratorFactory implements IGeneratorFactory {
    
    /** 项目路径 */
    protected static String projectPath = System.getProperty("user.dir");

    /**
     * 配置信息
     */
    protected static Properties p = new Properties();

    public AbstractGeneratorFactory() {
        init("generator.properties");
    }

    /**
     * 配置信息初始化
     *
     * @param propertyFileName 配置文件名称
     * @author yangfan
     * @since 2020-09-20 06:30:46
     */
    protected static void init(String propertyFileName) {
        InputStream in = null;

        try {
            in = AbstractGeneratorFactory.class.getClassLoader().getResourceAsStream(propertyFileName);
            if (in != null) {
                p.load(in);
            }
        } catch (IOException var11) {
            System.out.println("load " + propertyFileName + " into Constants error!");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException var10) {
                    System.out.println("close " + propertyFileName + " error!");
                }
            }
        }
    }

    /**
     * 获取配置信息
     *
     * @param key          配置key
     * @param defaultValue 如无配置默认值
     * @return java.lang.String
     * @author yangfan
     * @since  2020-09-20 06:33:58
     */
    protected static String getProp(String key, String defaultValue) {
        return p.getProperty(key, defaultValue);
    }

    protected static String getProp(String key) {
        return p.getProperty(key);
    }
}
