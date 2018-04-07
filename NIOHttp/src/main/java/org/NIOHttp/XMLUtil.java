package org.NIOHttp;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**  
 * @Title:  XMLUtil.java   
 * @Description: 解决XML读取问题 
 */  
public class XMLUtil {
    
    private static Logger logger = Logger.getLogger(XMLUtil.class);
    private static SAXReader reader = new SAXReader();
    
    /**
     * 得到根节点
     */
    public static Element getRootElement(String xmlPath) {
        Document document = null;;
        try {
        	ClassLoader classLoader = XMLUtil.class.getClassLoader();
        	if(classLoader.getResource(xmlPath) == null){
        		logger.info("找不到指定的xml文件的路径" + xmlPath + "！");
        		return null;
        	}
        	logger.info(classLoader.getResource(xmlPath).getPath());
        	InputStream inputStream = classLoader.getResourceAsStream(xmlPath);
            document = reader.read(inputStream);
        } catch (DocumentException e) {
            logger.error("找不到指定的xml文件的路径" + xmlPath + "！");
            return null;
        }
        return document.getRootElement();
    }
    
    /**
     * 得到该节点下的子节点集合
     */
    @SuppressWarnings("unchecked")
    public static List<Element> getElements(Element element) {
        return element.elements();
    }
    
    /**
     * 得到该节点下指定的节点
     */
    public static Element getElement(Element element, String name) {
        Element childElement = element.element(name);
        if(childElement == null) {
            logger.error(element.getName() + "节点下没有子节点" + name);
            return null;
        }
        return childElement;
    }
    
    /**
     * 得到该节点的内容
     */
    public static String getElementText(Element element) {
        return element.getText();
    }
}