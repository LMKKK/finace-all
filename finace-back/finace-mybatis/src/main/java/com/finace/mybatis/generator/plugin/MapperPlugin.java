package com.finace.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;

import java.util.Iterator;
import java.util.List;

public class MapperPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    /**
     * 修改Mapper类
     */
    @Override
    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType serializable = new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper");
        interfaze.addImportedType(serializable);

        FullyQualifiedJavaType commonMapperType = new FullyQualifiedJavaType("com.bage.mybatis.help.CommonMapper");
        interfaze.addImportedType(commonMapperType);

        commonMapperType.addTypeArgument(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
        interfaze.addSuperInterface(commonMapperType);

        interfaze.addAnnotation("@Mapper");

        // 获取所有的方法
        List<Method> methods = interfaze.getMethods();

        // 遍历方法，删除不需要的方法
        Iterator<Method> iterator = methods.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        return super.clientGenerated(interfaze, introspectedTable);
    }
}
