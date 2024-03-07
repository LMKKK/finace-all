package com.finace.mybatis.generator.plugin;


import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.DefaultCommentGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * mybatis generator生成注释插件
 */
public class GeneratorCommentPlugin extends DefaultCommentGenerator {

    private Properties properties;
    /**
     * 当前时间
     */
    private String currentDateStr;

    /**
     * 是否生成日期
     */
    private Boolean suppressDate;

    //时间
    private Boolean suppressAllComments;

    private Boolean addRemarkComments;

    /**
     * 作者信息
     */
    private String author;

    public GeneratorCommentPlugin() {
        super();
        properties = new Properties();
        currentDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        suppressDate = "true".equals(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));

        suppressAllComments = "true".equals(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

        addRemarkComments = "true".equals(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));

        author = properties.getProperty("author");
    }

    /**
     * 实体类的注释
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (!addRemarkComments) {
            return;
        }
        // 实体类注释
        // BaseRecordGenerator类没有调用addClassComment()方法，调用了addModelClassComment()，所以在这里添加实体类的注释
        topLevelClass.addJavaDocLine("/**");
        // introspectedTable.getRemarks()：获取表的备注
        topLevelClass.addJavaDocLine(" * " + introspectedTable.getRemarks() + "（表：" + introspectedTable.getFullyQualifiedTable() + "）");
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * @author " + author);
        if (suppressDate) {
            topLevelClass.addJavaDocLine(" * @date " + currentDateStr);
        }
        topLevelClass.addJavaDocLine(" */");
    }

    /**
     * 实体类字段注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (!addRemarkComments) {
            return;
        }
        // 由BaseRecordGenerator调用JavaBeansUtil.getJavaBeansField()方法 -> JavaBeansUtil.addGeneratedJavaDoc()方法
        //最终调用 DefaultCommentGenerator#addFieldComment()方法
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
        field.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (!suppressAllComments) {
            super.addFieldComment(field, introspectedTable);
        }
    }

    /**
     * 去除mapper xml文件注释
     *
     * @param xmlElement
     */
    @Override
    public void addComment(XmlElement xmlElement) {
        if (!suppressAllComments) {
            super.addComment(xmlElement);
        }
    }

    /**
     * 去除example 方法注释
     *
     * @param method
     * @param introspectedTable
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (!suppressAllComments) {
            super.addGeneralMethodComment(method, introspectedTable);
        }
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        if (!suppressAllComments) {
            super.addClassComment(innerClass, introspectedTable);
        }
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        if (!suppressAllComments) {
            super.addClassComment(innerClass, introspectedTable, markAsDoNotDelete);
        }
    }
}