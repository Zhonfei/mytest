/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import com.google.gson.Gson;
import data.Data;
import java.awt.Desktop;
import java.io.File;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;
import utils.ExcelParseTools;
import utils.ExportTools;
import utils.MSGUtils;
import utils.Tools;
import utils.XMLParseTools;

/**
 *
 * @author delta
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Gson gson = new Gson();
        String path = "G:\\temp\\test.xls";
//       String e_path = "G:\\temp\\test.xls";
//        String path = "G:\\temp\\test.xml";
//        Map map = new HashMap();
//        List list = ExcelParseTools.getExcelList(e_path);
//        System.out.println(list);
//        map.put("name", "zhangsan");
//        Map tMap = (Map) list.get(0);
//        map.put("title", "标题1");
//        map.put("content", tMap.get("内容"));
//        map.put("defined", tMap.get("定义"));
//        ExportTools et = new ExportTools();
//        System.out.println(map);
//        System.out.println(et.exportWord(path, map));
        
        List list = ExcelParseTools.getExcelList(path);
        System.out.println(gson.toJson(list));
        Map map = organziMap();
        //int flag = Tools.insertTable("temp", map, list);
        //System.out.println("update:"+flag);
        
//        String jsonString = "[{\"内容\":\"内容1\",\"定义\":\"定义1\"},{\"内容\":\"内容2\",\"定义\":\"定义2\"}]";
//        List list = gson.fromJson(jsonString, ArrayList.class);
//        System.out.println(list);
        
        
//        Map map = new HashMap();
//        map.put("abc", "a");
//        boolean containsKey = map.containsKey("0");
                //Test.test();
//        DBUtils dbu = new DBUtils();
//        System.out.println(dbu.getConnection());
                //new DBProxy().proxyTest();
                //System.out.println(new MySQLDBUtils().getConnection());
                //Map map = new HashMap();
                //DBUtilsFactory.getDBUtils("oracle");
                //map.put("d1", "-773121869.43163");
                // System.out.println(new BigDecimal(map.get("d1").toString()));
                //new Test().openFile("C:\\Users\\delta\\Desktop\\test.bat");
                //new Test().openFile(MSGUtils.sendMessage("192.168.9.11", "hello"));
                //System.out.println(new Gson().toJson(Data.getResultList()));
         
//          List resultList = Data.getResultList();
//          System.out.println(new Gson().toJson(resultList));
//          List keyList = new ArrayList();
//          keyList.add("d1_cur");
//          keyList.add("d7_cur");
//          Tools.upSumNodeList(resultList, keyList);
//          System.out.println(new Gson().toJson(resultList));
                
                //Tools.upSum(resultList, Test.class);
                //System.out.println(new Gson().toJson(resultList));
//          List keyList = Data.getKeyList();
//          OrganziaMethods om = new OrganziaMethods();
//          long l1 = new Date().getTime();
//          List list = om.getSumResultList(resultList,keyList);
//          long l2 = new Date().getTime();
//          System.out.println("=="+(l2-l1)+"==");
//          System.out.println(om.trsGson(list));

//          List list2 = om.testGetSumResultList(resultList);
//          System.out.println(om.trsGson(list2));
//        List orgnliList = new ArrayList();
//        System.out.println(resultList);
//        for (int i = 0; i < resultList.size(); i++) {
//            Map map = (Map)resultList.get(i);
//            String coa_name = map.get("coa_name").toString();
//            int num = Tools.getNumberNum(map);
//            System.out.println(coa_name+"\t"+num);
//        }
//        System.out.println(orgnliList);
//            Test test = new Test();
//            test.getResultList("");
                //System.out.println(testOrganziSum());
;
    }
    
    public static Map organziMap(){
        Map map = new HashMap();
        map.put("content", "内容");
        map.put("defined", "定义");
        System.out.println(map);
        return map;
    }
    
    public static List testOrganziSum(){
        List reList = Data.getResultList();
        System.out.println(reList);
        Map map = (Map) reList.get(8);
        List list = new ArrayList();
        for (int i = 9; i < 12; i++){
            list.add(reList.get(i));
        }
        OrganziaMethods o = new OrganziaMethods();
        o.organSum(map, list);
        return  reList;
    }
    
    public static void test(){
        String dataDate = "2019-06-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(dataDate);
            System.out.println(date);
//            sdf = new SimpleDateFormat("MM/dd/yyyy");
//            String format = sdf.format(date);
//            System.out.println(format);
            Calendar cd = Calendar.getInstance();
            cd.setTime(sdf.parse(dataDate));
            System.out.println(cd.getTime());
            System.out.println(Calendar.DAY_OF_MONTH);
            cd.add(Calendar.YEAR,-1);
            Date d = cd.getTime();
            System.out.println(sdf.format(d));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    public void getNumNum(String str){
        int num = 0;
        for(int j=0;j<str.length();j++){
            if(str.charAt(j)>=48 && str.charAt(j)<=57){
                num++;
            }
        }
        Tools.pl(num);
    }
    
    public void test1(){
        System.out.println(new Gson().toJson(getList()));
        List list = getList();
        int W1_CUR=0;
        for(int i=0;i<list.size();i++){
            Map map = (Map)list.get(i);
            W1_CUR = (int)map.get("D1_CUR")+
                    (int)map.get("D2_CUR")+
                    (int)map.get("D3_CUR")+
                     (int)map.get("D4_CUR")+
                    (int)map.get("D5_CUR")+
                    (int)map.get("D6_CUR")+
                    (int)map.get("D7_CUR");
            map.put("W1_CUR", W1_CUR);
        }
        System.out.println(new Gson().toJson(list));
    }
    
    public List getList(){
        List list = new ArrayList();
        for(int i=1;i<10;i++){
            Map map = new HashMap();
            for (int j = 1; j < 8; j++) 
            {
                map.put("D"+j+"_CUR", j);
            }
            map.put("W1_CUR", 0);
            list.add(map);
        }
        return list;
    }
    
    public void openFile(File file) throws Exception{
       // File file = new File(path);
        Desktop.getDesktop().open(file);
    }
    
    public List getResultList(String sql) throws Exception{
        List resultList = new ArrayList();
        //获取连接
       // Connection connection = XMLParseTools.getConnection("oracle");
        
        return resultList;
    }
    
    
}
