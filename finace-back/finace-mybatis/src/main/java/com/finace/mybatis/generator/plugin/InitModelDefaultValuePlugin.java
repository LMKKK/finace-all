package com.finace.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import java.util.List;

/**
 * 初始化实体类默认值 插件，与数据库默认值保持一致
 */
public class InitModelDefaultValuePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        Method initDefaultMethod = new Method("initDefault");
        initDefaultMethod.setVisibility(JavaVisibility.PUBLIC);
        for (IntrospectedColumn column : introspectedTable.getAllColumns()) {
            String defaultValue = column.getDefaultValue();
            if (column.getDefaultValue() != null && column.getDefaultValue().equals("null")) {
                defaultValue = "null";
            }
            if (column.getDefaultValue() != null && !column.getDefaultValue().equals("null") && column.getFullyQualifiedJavaType().getFullyQualifiedName().equals("java.lang.String")) {
                defaultValue = "\"" + defaultValue + "\"";
            }
            if (column.getDefaultValue() != null && column.getFullyQualifiedJavaType().getFullyQualifiedName().equals("java.lang.Long")) {
                defaultValue = defaultValue + "L";
            }
            if (column.getDefaultValue() != null && column.getFullyQualifiedJavaType().getFullyQualifiedName().equals("java.lang.Boolean")) {
                defaultValue = Boolean.toString(Boolean.parseBoolean(defaultValue));
            }
            if (column.getDefaultValue() != null && column.getFullyQualifiedJavaType().getFullyQualifiedName().equals("java.lang.Byte")) {
                defaultValue = "(byte) " + defaultValue;
            }
            if (column.getDefaultValue() != null && column.getFullyQualifiedJavaType().getFullyQualifiedName().equals("java.util.Date")) {
                defaultValue = "new Date()";
                topLevelClass.addImportedType("java.util.Date");
            }
            if (column.getDefaultValue() != null && column.getFullyQualifiedJavaType().getFullyQualifiedName().equals("java.math.BigDecimal")) {
                defaultValue = "new BigDecimal(\"" + defaultValue + "\")";
            }
            if (defaultValue != null) {
                initDefaultMethod.addBodyLine("if (this.get" + JavaBeansUtil.getCamelCaseString(column.getActualColumnName().replaceFirst("is_", ""), true) + "() == null) {");
                initDefaultMethod.addBodyLine("this.set" + JavaBeansUtil.getCamelCaseString(column.getActualColumnName().replaceFirst("is_", ""), true) + "(" + defaultValue + ");");
                initDefaultMethod.addBodyLine("}");
            }
        }
        topLevelClass.addMethod(initDefaultMethod);

        Method initUpdateMethod = new Method("initUpdate");
        initUpdateMethod.setVisibility(JavaVisibility.PUBLIC);
        for (IntrospectedColumn column : introspectedTable.getAllColumns()) {
            if (!column.getActualColumnName().equals("gmt_modified")) {
                continue;
            }
            String defaultValue = column.getDefaultValue();
            if (column.getDefaultValue() != null && column.getDefaultValue().equals("null")) {
                defaultValue = "null";
            }
            if (column.getDefaultValue() != null && !column.getDefaultValue().equals("null") && column.getFullyQualifiedJavaType().getFullyQualifiedName().equals("java.lang.String")) {
                defaultValue = "\"" + defaultValue + "\"";
            }
            if (column.getDefaultValue() != null && column.getFullyQualifiedJavaType().getFullyQualifiedName().equals("java.lang.Long")) {
                defaultValue = defaultValue + "L";
            }
            if (column.getDefaultValue() != null && column.getFullyQualifiedJavaType().getFullyQualifiedName().equals("java.lang.Boolean")) {
                defaultValue = Boolean.toString(Boolean.parseBoolean(defaultValue));
            }
            if (column.getDefaultValue() != null && column.getFullyQualifiedJavaType().getFullyQualifiedName().equals("java.util.Date")) {
                defaultValue = "new Date()";
                topLevelClass.addImportedType("java.util.Date");
            }
            if (column.getDefaultValue() != null && column.getFullyQualifiedJavaType().getFullyQualifiedName().equals("java.math.BigDecimal")) {
                defaultValue = "new BigDecimal(\"" + defaultValue + "\")";
            }
            if (defaultValue != null) {
                initUpdateMethod.addBodyLine("if (this.get" + JavaBeansUtil.getCamelCaseString(column.getActualColumnName(), true) + "() == null) {");
                initUpdateMethod.addBodyLine("this.set" + JavaBeansUtil.getCamelCaseString(column.getActualColumnName(), true) + "(" + defaultValue + ");");
                initUpdateMethod.addBodyLine("}");
            }
        }
        topLevelClass.addMethod(initUpdateMethod);
        return true;
    }
}