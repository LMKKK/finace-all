package com.finace.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import java.util.List;

public class UpdateBatchSelectivePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement rootElement = document.getRootElement();
        rootElement.addElement(replaceCondition(introspectedTable));
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    private TextElement replaceCondition(IntrospectedTable introspectedTable) {
        StringBuilder node = new StringBuilder("<update id=\"updateBatchSelective\" parameterType=\"java.util.List\">\n" +
                "    update " + introspectedTable.getFullyQualifiedTable().getIntrospectedTableName() + "\n");
        IntrospectedColumn idColumn = introspectedTable.getAllColumns().stream().filter(p -> p.getActualColumnName().equals("id")).findFirst().orElse(null);
        if (idColumn == null) {
            return null;
        }
        for (IntrospectedColumn column : introspectedTable.getAllColumns()) {
            node.append(
                    "   <trim prefix=\"set\" suffixOverrides=\",\">\n" +
                            "      <trim prefix=\"" + column.getActualColumnName() + " = case\" suffix=\"end,\">\n" +
                            "        <foreach collection=\"list\" index=\"index\" item=\"item\">\n" +
                            "          <if test=\"item." + JavaBeansUtil.getCamelCaseString(column.getActualColumnName(), false) + " != null\">\n" +
                            "            when id = #{item.id,jdbcType=" + idColumn.getJdbcTypeName() + "} then #{item." + JavaBeansUtil.getCamelCaseString(column.getActualColumnName(), false) + ",jdbcType=" + column.getJdbcTypeName() + "}\n" +
                            "          </if>\n" +
                            "        </foreach>\n" +
                            "      </trim>\n" +
                            "  </trim>\n");
        }
        node.append(
                "  where id in\n" +
                        "    <foreach close=\")\" collection=\"list\" item=\"item\" open=\"(\" separator=\", \">\n" +
                        "      #{item.id,jdbcType=" + idColumn.getJdbcTypeName() + "}\n" +
                        "    </foreach>\n" +
                        "</update>\n");
        // 将条件替换为自己的逻辑
        return new TextElement(node.toString());
    }
}