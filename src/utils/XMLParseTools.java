/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import beans.ConnectBean;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author delta
 */
public class XMLParseTools {
    private final static String PATH = "src"+File.separator+"doc"+File.separator+"ConnectBeans.xml";
    
    public static Map parseXml() throws Exception{
        Map map = new HashMap();
        String driver = null;
        String url = null;
        String username = null;
        String password = null;
        String sqlFlag = null;
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(PATH));
        Element connectBean = document.getRootElement();
        List<Element> sqlflagList = connectBean.elements();
        Element flag = sqlflagList.get(0);
        sqlFlag = flag.elementTextTrim("sqlFlag");
        System.out.println(sqlFlag);
        for (Element element : sqlflagList) {
            String eleName = element.getName();
            if(eleName.equalsIgnoreCase(sqlFlag)){
                //System.out.println(eleName);
                driver = element.elementText("driver");
                url = element.elementText("url");
                username = element.elementText("username");
                password = element.elementText("password");
                break;
            }
        }
        map.put("dbdriver", driver);
        map.put("url", url);
        map.put("username", username);
        map.put("password", password);
        System.out.println(map);
        //System.out.println(sqlflag.getText());
        return map;
    }
    
    private String getSqlFlag(){
        String sqlFlag = "";
        
        return sqlFlag;
    }
}
