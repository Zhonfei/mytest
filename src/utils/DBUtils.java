/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import beans.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;

/**
 *
 * @author delta
 */
public class  DBUtils {
    private Connection connection ;

    public DBUtils() {
        try {
            Map map = XMLParseTools.parseXml();
            String className = (String) map.get("dbdriver");
            String url = (String) map.get("url");
            String user = (String) map.get("username");
            String pwd = (String) map.get("password");
            Class.forName(className);
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void closeConnection(){
        if(connection!=null){
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
   // public List getList(String sql,DataBase db);
    
}
