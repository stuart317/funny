package com.zc.factory.factory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * 通过配置文件，读取工厂类名，反射生成对象
 */
public class XMLUtil {

    public static Object getBean(){
        try {
            //创建DOM文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;

            String fileurl = XMLUtil.class.getClassLoader().getResource("config.xml").getPath();
            //System.out.println("fileurl:"+fileurl);
            doc = builder.parse(new File(fileurl));
            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName=classNode.getNodeValue();
            //System.out.println("cName====:"+cName);
            //通过类名生成实例对象并将其返回
            Class c = Class.forName(cName);
            return c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
