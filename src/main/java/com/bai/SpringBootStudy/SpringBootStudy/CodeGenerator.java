package com.bai.SpringBootStudy.SpringBootStudy;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import jdk.nashorn.internal.objects.Global;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    /**
     * 需要生成的表名
     * */
    private static final String[] TABLE_NAMES = new String[]{"user"};
    /**
     * 文件路径
     * */
    private static final String projectPath = System.getProperty("user.dir");

    public static void main(String[] args) {
        AutoGenerator autoGenerator =new AutoGenerator();
        autoGenerator.setDataSource(getDataSourceConfigInfo());
        autoGenerator.setGlobalConfig(getGlobalConfigInfo());
        autoGenerator.setPackageInfo(getPackageConfigInfo());
        autoGenerator.setStrategy(getStrategyConfigInfo());
        autoGenerator.setTemplate(new TemplateConfig().setXml(null));
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.setCfg(getInjectionConfigInfo());
        autoGenerator.execute();
    }

    /**
     * 数据源配置
     * @return DataSourceConfig
     */
    private static DataSourceConfig getDataSourceConfigInfo(){
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/mybatis?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setDbType(DbType.MYSQL);
        return dataSourceConfig;
    }

    /** 全局配置
     * @return GlobalConfig
     */
    private static GlobalConfig getGlobalConfigInfo(){
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setFileOverride(true);
        globalConfig.setOutputDir(projectPath+"/src/main/java");
        globalConfig.setAuthor("BaiYe");
        globalConfig.setOpen(false);
        globalConfig.setSwagger2(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setBaseResultMap(true);
        globalConfig.setActiveRecord(false);
        globalConfig.setServiceName("%sService");
        return globalConfig;
    }

    /**
     * 包配置
     * @return PackageConfig
     */
    private static PackageConfig getPackageConfigInfo(){
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.bai.SpringBootStudy.SpringBootStudy");
        packageConfig.setModuleName(null);
        packageConfig.setEntity("module");
        return packageConfig;
    }

    /**
     * 策略配置
     * @param tableNames
     * @return StrategyConfig
     */
    private static StrategyConfig getStrategyConfigInfo(String... tableNames){
        StrategyConfig strategyConfigInfo = new StrategyConfig();
        strategyConfigInfo.setCapitalMode(true);
        strategyConfigInfo.setNaming(NamingStrategy.underline_to_camel);
        //下划线转驼峰命名
        strategyConfigInfo.setColumnNaming(NamingStrategy.underline_to_camel);
        //需要生成的的表名，多个表名传数组
        strategyConfigInfo.setInclude(tableNames);
        //设置逻辑删除字段
        strategyConfigInfo.setLogicDeleteFieldName("data_state");
        //使用lombok
        strategyConfigInfo.setEntityLombokModel(true);
        //设置表格前缀
        strategyConfigInfo.setTablePrefix("t_");
        //rest风格
        strategyConfigInfo.setRestControllerStyle(true);

        return strategyConfigInfo;
    }

    /**
     * 抽象的对外接口
     * @return
     */
    private static InjectionConfig getInjectionConfigInfo(){
        InjectionConfig injectionConfig=new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 输出xml
                return projectPath + "/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        return injectionConfig;


    }
}
