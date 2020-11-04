package com.boat.generator.support;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成器默认版，使用mybatis-plus的代码生成器实现
 *
 * @author yangfan
 * @createTime 2020-09-20 19:28
 */
public class DefaultGeneratorFactory extends AbstractGeneratorFactory {
    @Override
    public void generate() {
        new AutoGenerator().setGlobalConfig(buildGlobalConfig())
                // 数据源配置
                .setDataSource(buildDsConfig())
                // 包信息配置
                .setPackageInfo(buildPkgConfig())
                // 自定义配置
                //.setCfg(buildCustomConfig())
                // 自定义模板配置
                //.setTemplate(buildCustomTemplateConfig())
                // 策略配置
                .setStrategy(buildStrategyConfig())
                // 使用freemarker模板引擎
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    protected GlobalConfig buildGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(getOutPutDir());
        gc.setIdType(IdType.valueOf(getProp(ConfigKeyEnum.idType.getKey(), "AUTO")));
        gc.setAuthor(getProp(ConfigKeyEnum.author.getKey()));
        gc.setOpen(false);
        gc.setSwagger2("1".equals(getProp(ConfigKeyEnum.swagger.getKey(), "0")));
        return gc;
    }

    protected DataSourceConfig buildDsConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(getProp(ConfigKeyEnum.DsUrl.getKey()));
        dsc.setDriverName(getProp(ConfigKeyEnum.DsDriver.getKey()));
        dsc.setUsername(getProp(ConfigKeyEnum.DsUser.getKey()));
        dsc.setPassword(getProp(ConfigKeyEnum.DsPwd.getKey()));
        return dsc;
    }

    protected PackageConfig buildPkgConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setMapper("dao").setEntity("model").setXml("sqlmappers");
        pc.setParent(getProp(ConfigKeyEnum.pkgName.getKey()));
        return pc;
    }

    protected InjectionConfig buildCustomConfig() {
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do something
            }
        };
        // 自定义xml位置
        String xmlTemplatePath = "/templates/mapper.xml.ftl";
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(xmlTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return getOutPutResourceDir() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir(filePath);
                // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                return true;
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    protected TemplateConfig buildCustomTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        /*templateConfig.setEntity("templates/entity2.java");
        templateConfig.setService("");
        templateConfig.setController("");
        templateConfig.setXml(null);*/
        return templateConfig;
    }

    protected StrategyConfig buildStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        String superEntityClass = getProp(ConfigKeyEnum.superEntityClass.getKey());
        if (StringUtils.isNotBlank(superEntityClass)) {
            strategy.setSuperEntityClass(superEntityClass);
        }
        String superControllerClass = getProp(ConfigKeyEnum.superControllerClass.getKey());
        if (StringUtils.isNotBlank(superControllerClass)) {
            strategy.setSuperControllerClass(superControllerClass);
        }

        // 写于父类中的公共字段
        String superEntityColumns = getProp(ConfigKeyEnum.superEntityColumns.getKey());
        if (StringUtils.isNotBlank(superControllerClass)) {
            strategy.setSuperEntityColumns(superEntityColumns.split(","));
        }
        strategy.setInclude(getProp(ConfigKeyEnum.tables.getKey()).split(","));
        String tablePrefix = getProp(ConfigKeyEnum.tablePrefix.getKey());
        if (StringUtils.isNotBlank(tablePrefix)) {
            strategy.setTablePrefix(tablePrefix);
        }
        strategy.setEntitySerialVersionUID(false);
        strategy.setChainModel(true);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        return strategy;
    }

    private String getOutPutDir() {
        String projectModule = getProp(ConfigKeyEnum.projectModule.getKey());
        if (!StringUtils.isBlank(projectModule)) {
            return projectPath + "/" + projectModule + "/src/main/java";
        }
        return projectPath + "/src/main/java";
    }

    private String getOutPutResourceDir() {
        String projectModule = getProp(ConfigKeyEnum.projectModule.getKey());
        if (!StringUtils.isBlank(projectModule)) {
            return projectPath + "/" + projectModule + "/src/main/resources/sqlmappers";
        }
        return projectPath + "/src/main/resources/sqlmappers";
    }
}
