import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author system
 * 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 */
public class CodeGenerator {

    public static void main(String[] args) {
        String url = "jdbc:mysql://172.16.16.22:3306/sj_zulin2?characterEncoding=utf-8";
        String username = "root" ;
        String password = "ef7k-kc4BVss" ;
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);
        sc.setEntityColumnConstant(true);
        //sc.setTablePrefix("jscore");
        sc.setLogicDeleteFieldName("del_flag");
        // 需要生成的表 支持多表生成
        sc.setInclude("jscore_support_bank");
        mpg.setStrategy(sc);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("system");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(false);
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("work.lemoon.demo.springboottest.persist.rdb");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setXml("mapper.xml");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        mpg.setCfg(cfg);
        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/resources 下面内容修改，
        // 放置自己项目的 src/main/resources/resources 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        // 设置值为null 则不生成controller
        tc.setController(null);
        mpg.setTemplate(tc);
        // 执行生成
        mpg.execute();
    }

}