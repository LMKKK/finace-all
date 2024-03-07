package com.finace.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * 条件查询插件
 */
public class ExampleWhereClausePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement rootElement = document.getRootElement();
        rootElement.addElement(replaceCondition());
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    private TextElement replaceCondition() {
        String node = "<sql id=\"Example_Where_Clause\">\n" +
                "   <where>\n" +
                "            <trim prefixOverrides=\"and | or\">\n" +
                "                <foreach collection=\"oredCriteria\" item=\"criteria\">\n" +
                "                    <if test=\"criteria.valid\">\n" +
                "                        <if test=\"criteria.andOrOr\">\n" +
                "                            and\n" +
                "                        </if>\n" +
                "                        <if test=\"!criteria.andOrOr\">\n" +
                "                            or\n" +
                "                        </if>\n" +
                "                        <trim prefix=\"(\" prefixOverrides=\"and | or\" suffix=\")\">\n" +
                "                            <foreach collection=\"criteria.criteria\" item=\"criterion\">\n" +
                "                                <choose>\n" +
                "                                    <when test=\"criterion.noValue\">\n" +
                "                                        ${criterion.condition}\n" +
                "                                    </when>\n" +
                "                                    <when test=\"criterion.singleValue\">\n" +
                "                                        ${criterion.condition} #{criterion.value, jdbcType=${criterion.jdbcType}}\n" +
                "                                    </when>\n" +
                "                                    <when test=\"criterion.betweenValue\">\n" +
                "                                        ${criterion.condition} #{criterion.value, jdbcType=${criterion.jdbcType}} and #{criterion.secondValue, jdbcType=${criterion.jdbcType}}\n" +
                "                                    </when>\n" +
                "                                    <when test=\"criterion.listValue\">\n" +
                "                                        ${criterion.condition}\n" +
                "                                        <foreach close=\")\" collection=\"criterion.value\" item=\"listItem\" open=\"(\"\n" +
                "                                                 separator=\",\">\n" +
                "                                            #{listItem, jdbcType=${criterion.jdbcType}}\n" +
                "                                        </foreach>\n" +
                "                                    </when>\n" +
                "                                </choose>\n" +
                "                            </foreach>\n" +
                "                        </trim>\n" +
                "                    </if>\n" +
                "                </foreach>\n" +
                "            </trim>\n" +
                "        </where>" +
                "</sql>";
        // 将条件替换为自己的逻辑
        return new TextElement(node);
    }
}