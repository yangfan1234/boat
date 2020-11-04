package com.boat.generator;

import com.boat.generator.support.DefaultGeneratorFactory;
import com.boat.generator.support.IGeneratorFactory;

/**
 * 代码生成器执行入口
 *
 * @author yangfan
 * @createTime 2020-09-20 06:12:47
 */
public class BoatGenerator {

    public static void main(String[] args) {
        IGeneratorFactory factory = new DefaultGeneratorFactory();
        factory.generate();
    }

}
