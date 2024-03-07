package com.finace.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * 查询单条记录插件，如果返回多条数据则报错
 */
public class GetPlugin extends PluginAdapter {

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
        String selectNode = "  <select id=\"get\" parameterType=\"com.bage.mybatis.help.MyBatisWrapper\" resultMap=\"BaseResultMap\">\n" +
                "    select\n" +
                "    <if test=\"selectBuilder != null\">\n" +
                "      <trim prefixOverrides=\",\" suffixOverrides=\",\">\n" +
                "         ${selectBuilder} \n" +
                "      </trim>\n" +
                "    </if>\n" +
                "    from " + tableName + "\n" +
                "    <if test=\"_parameter != null\">\n" +
                "      <include refid=\"Example_Where_Clause\" />\n" +
                "    </if>\n" +
                "    <if test=\"orderByClause != null\">\n" +
                "      order by ${orderByClause}\n" +
                "    </if>\n" +
                "  </select>\n";
        // 将条件替换为自己的逻辑
        return new TextElement(selectNode);
    }
}