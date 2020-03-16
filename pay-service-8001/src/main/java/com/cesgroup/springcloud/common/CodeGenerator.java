package com.cesgroup.springcloud.common;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 代码生成
 *
 * @author: Mr.Li yz
 * @create: 2019-10-16 10:14
 **/
public class CodeGenerator {
    /**
     * 父项目地址1
     */
    public static String PROJECT_PATH = System.getProperty("user.dir");
    /**
     * 子项目
     */
    public static String SUB_PROJECT_NAME = "/pay-service-8001";
    /**
     * 包路径
     */
    public static String PACKAGE_PATH = "com.cesgroup.springcloud";
    /**
     * 包路径
     */
//    public static String MODULE_NAME = "entities";
    /**
     * 实体类父类
     */
    public static String SUPER_ENTITY_CLASS = "";
    /**
     * 作者
     */
    public static String AUTHOR = "Duan.jw";
    /**
     * 数据库DRIVER_NAME
     */
    public static String DRIVER_NAME = "org.gjt.mm.mysql.Driver";
    /**
     * 数据库URL
     */
    public static String DRIVER_URL = "jdbc:mysql://192.168.56.22:3306/pay-service?useUnicode=true&characterEncoding-utr-8&useSSL=false";
    /**
     * 数据库账号
     */
    public static String USERNAME = "root";
    /**
     * 数据库密码
     */
    public static String PASSWORD = "mysql";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入服务" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {

        // 全局配置
        GlobalConfig globalConfig = getGlobalConfig();
        // 数据源配置
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        // 包名配置
        PackageConfig packageConfig = getPackageConfig();
        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig();
        // 自定义配置
        InjectionConfig injectionConfig = getInjectionConfig();

        //自动生成
        atuoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig);
    }

    private static void atuoGenerator(DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, GlobalConfig globalConfig, PackageConfig packageConfig) {
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
//                .setCfg(injectionConfig)
                .setStrategy(strategyConfig)
                .setTemplate(new TemplateConfig().setXml(null).setController(null));
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
//                .setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }

    private static GlobalConfig getGlobalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(PROJECT_PATH + SUB_PROJECT_NAME + "/src/main/java")
                .setAuthor(AUTHOR)
                .setOpen(false)
                .setSwagger2(true)
                .setFileOverride(true);
        return globalConfig;
    }

    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(DRIVER_URL)
                .setDriverName(DRIVER_NAME)
                .setUsername(USERNAME)
                .setPassword(PASSWORD)
                .setTypeConvert(new MySqlTypeConvert() {
                    @Override
                    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        if (fieldType.equals("datetime")) {
                            return DbColumnType.DATE;
                        }
                        if (fieldType.contains("decimal")) {
                            return DbColumnType.DOUBLE;
                        }
                        return super.processTypeConvert(globalConfig, fieldType);
                    }
                });
        return dataSourceConfig;
    }

    private static PackageConfig getPackageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig
                .setParent(PACKAGE_PATH);
//                .setModuleName(MODULE_NAME);
        return packageConfig;
    }

    private static StrategyConfig getStrategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
//                .setSuperEntityClass(SUPER_ENTITY_CLASS)
                .setEntitySerialVersionUID(true)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setInclude(scanner("表名，多个英文逗号分割").split(","))
                .setControllerMappingHyphenStyle(true);
//                .setLogicDeleteFieldName("deleted")
//                .setVersionFieldName("version")
//                .setSuperEntityColumns("id", "ep_id", "delete_flg", "create_time", "update_time");
        return strategyConfig;
    }

    private static InjectionConfig getInjectionConfig() {
        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PROJECT_PATH + SUB_PROJECT_NAME + "/src/main/resources/DB/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        injectionConfig.setFileOutConfigList(focList);
        return injectionConfig;
    }
}
