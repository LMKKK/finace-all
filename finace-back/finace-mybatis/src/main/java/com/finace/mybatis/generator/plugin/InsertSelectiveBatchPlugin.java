package com.finace.mybatis.generator.plugin;


import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class InsertSelectiveBatchPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

//    /**
//     * 修改Mapper类
//     */
//    @Override
//    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {
//        generatedBatchInsertMethod("insertBatchSelective", interfaze, introspectedTable);
//        return super.clientGenerated(interfaze, introspectedTable);
//    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
        IntrospectedColumn primaryKeyColumn = primaryKeyColumns.stream()
                .filter(IntrospectedColumn::isAutoIncrement)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("生成文件时发生错误, 表: %s, 无自增主键。", introspectedTable.getFullyQualifiedTableNameAtRuntime())));


        List<IntrospectedColumn> allColumns = introspectedTable.getAllColumns();
        XmlElement insertBatchSelective = new XmlElement("insert");
        insertBatchSelective.addAttribute(new Attribute("id", "insertBatchSelective"));
        insertBatchSelective.addAttribute(new Attribute("parameterType", "java.util.List"));
//        insertBatchSelective.addAttribute(new Attribute("useGeneratedKeys", "true"));
        insertBatchSelective.addAttribute(new Attribute("keyColumn", primaryKeyColumn.getActualColumnName()));
//        insertBatchSelective.addAttribute(new Attribute("keyProperty", JavaBeansUtil.getCamelCaseString(primaryKeyColumn.getActualColumnName(), false)));

        XmlElement foreach = new XmlElement("foreach");
        foreach.addAttribute(new Attribute("item", "item"));
        foreach.addAttribute(new Attribute("index", "index"));
        foreach.addAttribute(new Attribute("collection", "list"));
        foreach.addAttribute(new Attribute("separator", ";"));

        List<XmlElement> columns = allColumns.stream().filter(p -> !p.isAutoIncrement())
                .map(m -> generateCheckNullForColumn(m, "item."))
                .collect(Collectors.toList());
        XmlElement trimForColumns = new XmlElement("trim");
        trimForColumns.addAttribute(new Attribute("prefix", "("));
        trimForColumns.addAttribute(new Attribute("suffix", ")"));
        trimForColumns.addAttribute(new Attribute("suffixOverrides", ","));
        columns.forEach(trimForColumns::addElement);

        List<XmlElement> values = allColumns.stream().filter(p -> !p.isAutoIncrement())
                .map(this::checkItemNullForValue)
                .collect(Collectors.toList());
        XmlElement trimForValues = new XmlElement("trim");
        trimForValues.addAttribute(new Attribute("prefix", "("));
        trimForValues.addAttribute(new Attribute("suffix", ")"));
        trimForValues.addAttribute(new Attribute("suffixOverrides", ","));
        values.forEach(trimForValues::addElement);

        foreach.addElement(new TextElement(String.format("insert into %s ", introspectedTable.getFullyQualifiedTableNameAtRuntime())));
        foreach.addElement(trimForColumns);
        foreach.addElement(new TextElement(" values "));
        foreach.addElement(trimForValues);

        insertBatchSelective.addElement(foreach);
        XmlElement rootElement = document.getRootElement();
        rootElement.addElement(insertBatchSelective);
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    private XmlElement generateCheckNullForColumn(IntrospectedColumn column, String itemName) {
        String actualColumnName = column.getActualColumnName().replace("is_", "");
        String camelCaseColumnName = JavaBeansUtil.getCamelCaseString(actualColumnName, false);

        XmlElement element = new XmlElement("if");
        element.addAttribute(new Attribute("test", String.format("%s%s != null", itemName, camelCaseColumnName)));
        element.addElement(new TextElement(String.format("%s,", actualColumnName)));
        return element;
    }

    private XmlElement checkItemNullForValue(IntrospectedColumn column) {
        return generateCheckNullForValue(column, "item.");
    }

    private XmlElement generateCheckNullForValue(IntrospectedColumn column, String itemName) {
        String actualColumnName = column.getActualColumnName();
        String camelCaseColumnName = JavaBeansUtil.getCamelCaseString(actualColumnName, false);

        XmlElement element = new XmlElement("if");
        element.addAttribute(new Attribute("test", String.format("%s%s != null", itemName, camelCaseColumnName)));
        element.addElement(new TextElement(String.format("#{%s%s, jdbcType=%s},", itemName, camelCaseColumnName, column.getJdbcTypeName())));
        return element;
    }
}