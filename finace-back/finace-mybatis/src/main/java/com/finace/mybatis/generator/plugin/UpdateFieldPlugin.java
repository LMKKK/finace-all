package com.finace.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * 修改插件，支持将字段设置为null
 */
public class UpdateFieldPlugin extends PluginAdapter {

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
        String node = "<update id=\"updateField\" parameterType=\"com.finace.mybatis.helper.MyBatisWrapper\">\n" +
                "    update " + tableName + " \n" +
                "    set \n" +
                "    <trim prefixOverrides=\",\" suffixOverrides=\",\">\n" +
                "         ${example.updateSql} \n" +
                "      </trim>\n" +
                "     <if test=\"example.updateSql != null\">\n" +
                "      <include refid=\"Update_By_Example_Where_Clause\" />\n" +
                "    </if>\n" +
                "  </update>";
        // 将条件替换为自己的逻辑
        return new TextElement(node);
    }
}