package com.jishu5.ctfcommunityserver.utils;



import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class SingleModuleGenerator {

    /*数据源配置*/
    /**url*/
    static String url = "jdbc:mysql://localhost:3306/codeoj?serverTimezone=Asia/Shanghai";
    /**用户名*/
    static String username = "root";
    /**密码*/
    static String password = "root";

    /*全局配置*/
    /**输出目录*/
    static String outputDir = System.getProperty("user.dir") + "/src/main/java";
    /**作者*/
    static String author = "nifeng";
    /**时间策略*/
    static DateType dateType = DateType.TIME_PACK;
    /**注释日期*/
    static String commentDate = "yyyy-MM-dd HH:mm:ss";

    /*包配置*/
    /**父包名*/
    static String parentPackage = "com.jishu5.ctfcommunityserver";
    /**父模块名（根据业务来填写，如果没有就是空）*/
    static String moduleName = "";
    /**controller包名*/
    static String controllerPackage = "controller";
    /**service接口包名*/
    static String servicePackage = "service";
    /**serviceImpl包名*/
    static String serviceImplPackage = "service.impl";
    /**实体类包名*/
    static String entityPackage = "entity";
    /**mapper接口包名*/
    static String mapperPackage = "mapper";
    /**xxMapper.xml文件的位置*/
    static String xmlPackage = System.getProperty("user.dir") + "/src/main/resources" + "/mybatis/mapper";
    /**自定义文件包名*/
    static String other = "other";

    /*模板配置*/
    /**禁用模板 本项目配置不生成 Service ServiceImpl Controller*/
    static TemplateType[] disableTemplateType = {
            //TemplateType.ENTITY,
            //TemplateType.MAPPER,
            //TemplateType.SERVICE,
            //TemplateType.SERVICEIMPL,
            TemplateType.XML,
            TemplateType.CONTROLLER
    };


    /*策略配置*/
    /**需要生成的表名*/
    static String[] tableNames = {};
    /**过滤表名前缀*/
    static String tablePrefix = "";
    /**过滤表名后缀*/
    static String tableSuffix = "";
    /**过滤表字段后缀*/
    static String fieldPrefix = "";
    /**过滤表字段后缀*/
    static String fieldSuffix = "";

    /*Controller 策略*/
    /**设置 Controller 父类*/
    static String controllerSuperClass = "";
    /**格式化 Controller 接口名称。%s:表名。默认是"%sController"*/
    static String formatControllerName = "%sController";

    /*Service 策略*/
    /**设置 Service 父类*/
    static String superServiceClass = "";
    /**设置 ServiceImpl 父类*/
    static String superServiceImplClass = "";
    /**格式化 Service 名称*/
    static String formatServiceFileName = "%sService";
    /**格式化 ServiceImpl 名称*/
    static String formatServiceImplFileName = "%sServiceImpl";

    /*mapper接口以及xml文件策略*/
    /**实体类父类的全名*/
    static String mapperSuperClass = "";
    /**格式化mapper接口名称。%s:表名。默认是"%sMapper"*/
    static String formatMapperFileName = "%sMapper";
    /**格式化xml文件名称。%s:表名。默认是"%sMapper"*/
    static String formatXmlFileName = "%sMapper";

    /*entity 策略*/
    /**实体类父类的全名*/
    static String entitySuperClass = "";
    /**乐观锁字段名(数据库)*/
    static String versionColumnName = "";
    /**乐观锁属性名(实体)*/
    static String versionPropertyName = "";
    /**逻辑删除字段名(数据库)*/
    static String logicDeleteColumnName = "";
    /**逻辑删除属性名(实体)*/
    static String logicDeletePropertyName = "";
    /**添加父类公共字段*/
    static String[] superEntityColumns = {};
    /**添加忽略字段*/
    static String[] ignoreColumns = {};
    /**自动填充的字段和时机*/
    static List<IFill> fillColumns = new ArrayList<IFill>(){{
        add(new Column("create_time", FieldFill.INSERT));
        add(new Column("create_user", FieldFill.INSERT));
        add(new Column("modify_time", FieldFill.UPDATE));
        add(new Column("modify_user", FieldFill.UPDATE));
    }};
    /**格式化实体类名称。%s:表名。默认是"%s"*/
    static String formatFileName = "%s";

    public static void main(String[] args) {
        // 生成器
        FastAutoGenerator.create(url, username, password)
                // 全局配置
                .globalConfig(builder -> builder
                        .disableOpenDir()                   // 禁止打开输出目录
                        .outputDir(outputDir)               // 指定输出目录
                        .author(author)                     // 设置作者
                        .dateType(dateType)                 // 时间策略
                        .commentDate(commentDate)           // 注释日期
//                        .enableSwagger()                    // 开启 swagger 模式
                        .build())
                // 包配置
                .packageConfig(builder -> builder
                        .parent(parentPackage)              // 父包名
                        .moduleName(moduleName)             // 父包模块名
                        .controller(controllerPackage)      // Controller 包名
                        .service(servicePackage)            // Service 包名
                        .serviceImpl(serviceImplPackage)    // ServiceImpl 包名
                        .mapper(mapperPackage)              // Mapper 包名
                        .entity(entityPackage)              // Entity 包名
                        .other(other)                       // 输出自定义文件时所用到的包名
                        // 设置mapperXml生成路径
                        .pathInfo(Collections.singletonMap(OutputFile.xml, xmlPackage))
                        .build())
                // 模板配置
                .templateConfig(builder -> builder
                        .disable(disableTemplateType)
                        .build()
                )
                // 策略配置
                .strategyConfig((scanner, builder) -> builder
                        .addInclude(getTables("all"))         // 遍历所有的表
//                        .addInclude(tableNames)       // 设置需要生成的表名
                        .addTablePrefix(tablePrefix)    // 设置过滤表名前缀
                        .addTableSuffix(tableSuffix)    // 设置过滤表名后缀
                        .addFieldPrefix(fieldPrefix)    // 设置过滤表字段前缀
                        .addFieldSuffix(fieldSuffix)    // 设置过滤表字段后缀

                        // Controller 策略
                        .controllerBuilder()
                        .fileOverride()                         // 覆盖已生成文件
                        .superClass(controllerSuperClass)       // Controller父类
                        .enableRestStyle()                      // 开启生成 @RestController 控制器
                        .formatFileName(formatControllerName)   // 格式化 Controller 接口名称。%s:表名。默认是"%sController"

                        // Service 策略
                        .serviceBuilder()
                        // 覆盖已生成文件
                        .fileOverride()
                        // 设置 service 接口父类
                        .superServiceClass(StringUtils.isEmpty(superServiceClass) ? ConstVal.SUPER_SERVICE_CLASS : superServiceClass)
                        // 设置 service 实现类父类
                        .superServiceImplClass(StringUtils.isEmpty(superServiceImplClass) ? ConstVal.SUPER_SERVICE_IMPL_CLASS : superServiceImplClass)
                        .formatServiceFileName(formatServiceFileName)           // 格式化 service 接口名称。%s:表名。默认是"I%sService"
                        .formatServiceImplFileName(formatServiceImplFileName)   // 格式化 service 实现类名称。%s:表名。默认是"%sServiceImpl"

                        // mapper策略
                        .mapperBuilder()
                        .fileOverride()                             // 覆盖已生成文件
                        // mapper接口的父类
                        .superClass(StringUtils.isEmpty(mapperSuperClass) ? ConstVal.SUPER_MAPPER_CLASS : mapperSuperClass)
                        //.enableMapperAnnotation()                   // 开启 @Mapper 注解
                        .enableBaseResultMap()                      // 启用 BaseResultMap 生成
                        .enableBaseColumnList()                     // 启用 BaseColumnList
                        .formatMapperFileName(formatMapperFileName) // 格式化mapper接口名称。%s:表名。默认是"%sMapper"
                        .formatXmlFileName(formatXmlFileName)       // 格式化xml文件名称。%s:表名。默认是"%sMapper"

                        // entity 策略
                        .entityBuilder()
                        .fileOverride()                                     // 覆盖已生成文件
                        .superClass(entitySuperClass)                       // 实体类的父类



                        .enableLombok()                                     // 开启 Lombok 注解
                        .enableTableFieldAnnotation()                       // 开启生成实体时生成字段注解
                        .enableActiveRecord()                               // 开启 ActiveRecord 模型
                        .versionColumnName(versionColumnName)               // 乐观锁字段名(数据库)
                        .versionPropertyName(versionPropertyName)           // 乐观锁属性名(实体)
                        .logicDeleteColumnName(logicDeleteColumnName)       // 逻辑删除字段名(数据库)
                        .logicDeletePropertyName(logicDeletePropertyName)   // 逻辑删除属性名(实体)
                        .addSuperEntityColumns(superEntityColumns)          // 添加父类公共字段
                        .addIgnoreColumns(ignoreColumns)                    // 添加忽略字段
                        .addTableFills(fillColumns)                         // 自动填充字段
                        .formatFileName(formatFileName)                     // 格式化实体类名称。%s:表名。默认是"%s"

                        .build())
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }


    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        List<String> objects = "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
        return objects;
    }

}
