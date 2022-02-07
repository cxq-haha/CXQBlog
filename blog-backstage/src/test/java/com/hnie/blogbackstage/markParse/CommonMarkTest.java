package com.hnie.blogbackstage.markParse;

import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CommonMarkTest {
    @Test
    public void commonmarkTest1() {
        Parser parser = Parser.builder().build();
        Node document = parser.parse("# Qt单元测试\n" +
                "## 什么是Qt单元测试\n" +
                "|c1|c2|c3|\n" +
                "|--|--|--|\n" +
                "|A|B|C|\n" +
                "## Qt单元测试能做什么\n" +
                "* one\n" +
                "* two\n" +
                "* three\n" +
                "## 为什么要用Qt单元测试\n" +
                "> sadfa\n" +
                "> sadf\n" +
                "> dasf\n" +
                "\n" +
                "```java\n" +
                "\tSystem.out.println(\"hello world!\");\n" +
                "```\n");
        HtmlRenderer renderer = HtmlRenderer.builder().
                attributeProviderFactory(new AttributeProviderFactory() {
                    @Override
                    public AttributeProvider create(AttributeProviderContext attributeProviderContext) {
                        return new AttributeProvider() {
                            @Override
                            public void setAttributes(Node node, String s, Map<String, String> map) {
                                if (node instanceof Image) {
                                    map.put("style", "width:150px;height:200px;position:relative;left:50%;margin-left:-100px;");
                                }
                                if(node instanceof Link){
                                    map.put("target", "_blank");
                                }
                            }
                        };
                    }
                }).
                build();
        String mdHtml = renderer.render(document);
        System.out.println(mdHtml);
    }
}
