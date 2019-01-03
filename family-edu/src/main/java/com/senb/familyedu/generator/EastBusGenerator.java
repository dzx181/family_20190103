package com.senb.familyedu.generator;




import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * MybatisPlus生成器
 */
public class EastBusGenerator {

    private static final DbType DB_TYPE = DbType.MYSQL;
    private static final String DB_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String DB_JDBC_URL = "jdbc:mysql://localhost:3306/db_edu?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    private static final String GEN_PATH = new File("D:\\family_20190103\\family-edu").getAbsolutePath();
    private static final String PACKAGE_NAME = "com.senb.familyedu";
    private static final String AUTHOR_NAME = "senb";
    private static final String[] TABLE_PREFIXS = {"deu_"};
    private static final String[] TABLE_NAMES = {
            "edu_course",
            "edu_remark",
            "edu_select",
            "edu_user"
    };


    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();
        generator.setGlobalConfig(globalConfig());
        generator.setDataSource(dataSourceConfig());
        generator.setStrategy(strategyConfig());
        generator.setPackageInfo(packageConfig());
        generator.setCfg(injectionConfig());
        generator.setTemplate(new TemplateConfig().setXml(null));
        generator.execute();
    }

    private static InjectionConfig injectionConfig() {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("author", this.getConfig().getGlobalConfig().getAuthor());
                this.setMap(map);
            }
        };
        FileOutConfig fileOutConfig = new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return GEN_PATH + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        };
        injectionConfig.setFileOutConfigList(Collections.singletonList(fileOutConfig));
        return injectionConfig;
    }

    private static PackageConfig packageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(PACKAGE_NAME);
        packageConfig.setEntity("entity");
        packageConfig.setMapper("dao");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setController("controller");
        return packageConfig;
    }

    private static StrategyConfig strategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setTablePrefix(TABLE_PREFIXS);
        strategyConfig.setInclude(TABLE_NAMES);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setEntityColumnConstant(true);
        strategyConfig.setEntityBuilderModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.entityTableFieldAnnotationEnable(true);
        return strategyConfig;
    }

    private static DataSourceConfig dataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DB_TYPE);
        dataSourceConfig.setDriverName(DB_DRIVER_NAME);
        dataSourceConfig.setUsername(DB_USERNAME);
        dataSourceConfig.setPassword(DB_PASSWORD);
        dataSourceConfig.setUrl(DB_JDBC_URL);
        return dataSourceConfig;
    }

    private static GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(GEN_PATH + "/src/main/java");
        globalConfig.setAuthor(AUTHOR_NAME);
        globalConfig.setFileOverride(true);
        globalConfig.setActiveRecord(false);
        globalConfig.setEnableCache(false);
        globalConfig.setBaseResultMap(false);
        globalConfig.setBaseColumnList(false);
        globalConfig.setOpen(false);
        globalConfig.setMapperName("%sDao");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        return globalConfig;
    }
}
