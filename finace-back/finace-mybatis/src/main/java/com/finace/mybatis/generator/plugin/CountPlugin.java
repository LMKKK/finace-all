package com.finace.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class CountPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement rootElement = document.getRootElement();
        rootElement.addElement(replaceCondition(introspectedTable.getFullyQualifiedTable().getIntrospectedTableName()));
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    private TextElement replaceCondition(String tableName) {
        String node = "<select id=\"count\" parameterType=\"com.bage.mybatis.help.MyBatisWrapper\" resultType=\"java.lang.Integer\">\n" +
                "        <include refid=\"countSql\"/>\n" +
                "    </select>\n" +
                "    <sql id=\"countSql\">\n" +
                "        select count(*) total_count from " + tableName + "\n" +
                "        <if test=\"_parameter != null\">\n" +
                "            <include refid=\"Example_Where_Clause\"/>\n" +
                "        </if>\n" +
                "    </sql>";
        // 将条件替换为自己的逻辑
        return new TextElement(node);
    }
}