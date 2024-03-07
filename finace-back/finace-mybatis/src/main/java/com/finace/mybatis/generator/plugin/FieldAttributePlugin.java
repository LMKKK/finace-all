package com.finace.mybatis.generator.plugin;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.DefaultJavaFormatter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import java.util.Collections;
import java.util.List;

/**
 * 字段属性插件
 */
public class FieldAttributePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        String queryVoName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();

        String model = context.getJavaModelGeneratorConfiguration().getTargetPackage();
        String querVoSuffix = properties.getProperty("QUERVO_VO_SUFFIX", "Field");
        TopLevelClass root = new TopLevelClass(join(model, queryVoName + querVoSuffix));
//        root.addImportedType(model + "." + queryVoName);
        root.setVisibility(JavaVisibility.PUBLIC);
        root.addImportedType("com.bage.mybatis.help.DbField");
        root.addImportedType("com.bage.mybatis.help.FieldResult");
        root.addImportedType("java.util.Collections");

        List<IntrospectedColumn> allColumns = introspectedTable.getAllColumns();
        for (IntrospectedColumn column : allColumns) {
            String varName = JavaBeansUtil.getCamelCaseString(column.getActualColumnName(), true);
            String attrName = JavaBeansUtil.getCamelCaseString(column.getActualColumnName(), false);
            //生成字段
            Field field = new Field(varName,
                    new FullyQualifiedJavaType("com.bage.mybatis.help.DbField"));
            field.setVisibility(JavaVisibility.PUBLIC);
            field.setStatic(true);
            field.setInitializationString(String.format("new DbField(\"%s\",\"%s\",\"%s\",\"%s\")", column.getActualColumnName(), attrName, column.getJdbcTypeName(), column.getFullyQualifiedJavaType()));
            root.addField(field);

            Method setMethod = new Method("set" + field.getName());
            setMethod.setVisibility(JavaVisibility.PUBLIC);
            setMethod.setStatic(true);
            setMethod.addParameter(new Parameter(column.getFullyQualifiedJavaType(), attrName));
            setMethod.setReturnType(new FullyQualifiedJavaType("com.bage.mybatis.help.FieldResult"));
            setMethod.addBodyLine("return new FieldResult(" + field.getName() + ", Collections.singletonList(" + attrName + "));");
            root.addMethod(setMethod);
        }

        String targetProject = context.getJavaClientGeneratorConfiguration().getTargetProject();
        GeneratedJavaFile gjf = new GeneratedJavaFile(root, targetProject, "UTF-8", new DefaultJavaFormatter());

        return Collections.singletonList(gjf);
    }

    private String join(String... strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str).append(".");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}