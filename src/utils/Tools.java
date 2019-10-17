/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;
import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author delta
 */
public class Tools {
    //private final static int DEEPEST = 4;
    private final static String basePath = "src"+File.separator+"doc"+File.separator;
    
    
    
    /**
     * 将数据插入表中
     * @param tabelName 表名
     * @param map 数据库字段与数据字段对应关系
     * @param list 数据
     * @return 
     */
    public static int insertTable(String tabelName,Map map,List<Map> list){
        int flag = -1;
        DBUtils db = new DBUtils();
        Connection connection = db.getConnection();
        String tempId = "";
        try {
            Statement st = connection.createStatement();
            for (int i=0; i < list.size(); i++) {
                Map map1 = list.get(i);
                String content = map1.get(map.get("content").toString()).toString();
                String defined = map1.get(map.get("defined").toString()).toString();
                String id = UUID.randomUUID().toString();
                String sql = "insert into "+tabelName+" values('"+id+"','"+content+"','"+defined+"')";
                System.out.println(sql);
                st.executeUpdate(sql);
                tempId = id;
            }
        } catch (Exception e) {
            System.out.println(tempId+"已插入！");
            e.printStackTrace();
        }finally{
            db.closeConnection();
        }
        return list.size();
    }
    
    public static void pl(Object obj){
        System.out.println(obj);
    }
    
    public static void p(Object obj){
        System.out.print(obj);
    }
    
    public static void upSumNodeList(List resultList,List keyList){
        Set parentSet = new HashSet();
        for (int i = 0; i < resultList.size(); i++) {
            Map map = (Map) resultList.get(i);
            parentSet.add(trsQueryData(map.get("coa_parent_code")));
        }
        List parentList = new ArrayList(parentSet);
        Collections.sort(parentList);
        System.out.println(parentList);
        
        for(int i=parentList.size()-1;i>=0;i--){
            String parentCode = (String) parentList.get(i);
            for (int j = 0,kLen = keyList.size(); j < kLen; j++) {
                String term = (String) keyList.get(j);
                BigDecimal sum = BigDecimal.ZERO;
                for (int k = 0,rLen = resultList.size(); k < rLen; k++) {
                    Map map = (Map) resultList.get(k);
                    String pCode = trsQueryData(map.get("coa_parent_code"));
                    if(parentCode.equals(pCode)){
                        sum = sum.add(new BigDecimal(trsQueryData(map.get(term))));
                    }
                }
                for (int k = 0,rLen=resultList.size(); k <rLen ; k++) {
                    Map map = (Map) resultList.get(k);
                    if(parentCode.equals(map.get("coa_code"))){
                        map.put(term, sum.toString());
                        break;
                    }
                }
            }
        }
    }
    
    public static void upSum(List resultList,Class cla) throws Exception{
        String simpleName = cla.getSimpleName();
        String xmlPath = basePath + simpleName+".xml";
        System.out.println("xmlPath:"+xmlPath);
        SAXReader read = new SAXReader();
        Document document = read.read(new File(xmlPath));
        Element root = document.getRootElement();
        List<Element> elements = root.elements("sum");
        if(!elements.isEmpty()){
            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);
                String parentCoaCode = element.elementTextTrim("parentcoacode");
                String coaCode = element.elementTextTrim("coacode");
                System.out.println("parentCoaCode:"+parentCoaCode+"\tcoaCode:"+coaCode);
                upSum(resultList,parentCoaCode,coaCode);
            }
        }
    }
    
    private static void upSum(List resultList,String parentCoaCode,String coaCode){
        List<String> code = new ArrayList();
        if(coaCode.indexOf(",")>0){
            String[] temp = coaCode.split(",");
            for (int i = 0; i < temp.length; i++) {
                code.add(temp[i]);
            }
        }else if(coaCode.indexOf("-")>0){
            String[] temp = coaCode.split("-");
            String endCoaCode = temp[1].substring(temp[1].length()-2);
            String baseCoaCode = temp[0].substring(0,temp[0].length()-2);
            int end =-1;
            if(endCoaCode.charAt(0)== '0'){
                end = Integer.parseInt(endCoaCode.charAt(1)+"");
                for (int i = 1; i <= end; i++) {
                    code.add(baseCoaCode+"0"+i);
                }
            }else{
                end = Integer.parseInt(endCoaCode);
                for (int i = 1; i <= end; i++) {
                    code.add(baseCoaCode+(i<10?"0":"")+i);
                }
            }
        }else{
            code.add(coaCode);
        }
        System.out.println(code);
        BigDecimal sum = BigDecimal.ZERO;
        int codeLen = code.size();
        int resultLen = resultList.size();
        for (int i = 0; i < codeLen; i++) {
            String lcode = code.get(i);
            for (int j = 0; j < resultLen; j++) {
                Map map = (Map) resultList.get(j);
                if(lcode.equals(trsQueryData(map.get("coa_code")))){
                    sum = sum.add(new BigDecimal(trsQueryData(map.get("d1_cur"))));
                }
            }
        }
        for (int i = 0; i < resultLen; i++) {
            Map map = (Map) resultList.get(i);
            if(map.get("coa_code").equals(parentCoaCode)){
                map.put("d1_cur", sum.toString());
            }
        }
        System.out.println(sum.toString());
    }
    
   
    
    /**
     * 将正常数据和逾期未定期限数据加入到模板数据
     * @param resultList
     * @param normalList
     * @param overDueAndUnperiodList 
     */
    public static void addDataToFrame(List resultList, List normalList, List overDueAndUnperiodList) {
        for (int i = 0; i < resultList.size(); i++) {
            Map resultMap = (Map) resultList.get(i);
            String coaCode = (String) resultMap.get("COA_CODE");
            for (int j = 0; j < normalList.size(); j++) {
                Map normalMap = (Map) normalList.get(j);
                String normalCoaCode = (String) normalMap.get("COA_PARENT_CODE");
                if (coaCode.equals(normalCoaCode)) {
                    resultMap.putAll(normalMap);
                }
            }
            for (int j = 0; j < overDueAndUnperiodList.size(); j++) {
                Map overdueMap = (Map) overDueAndUnperiodList.get(j);
                String overdueCoaCode = (String) overdueMap.get("COA_PARENT_CODE");
                if (coaCode.equals(overdueCoaCode)) {
                    resultMap.putAll(overdueMap);
                }
            }
        }
    }
    
    //调用一些有规律的方法
    public static void dyff(String methodName,Class cla){
        try {
            Method method = cla.getDeclaredMethod(methodName);
            method.invoke(cla.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String trsQueryData(Object obj){
        return obj==null?"":obj.toString();
    }
    
    public static BigDecimal testNullToBigDecimal(Object obj){
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal rbg = BigDecimal.ZERO;
        if(obj==null || "".equals(obj)){
            rbg = zero;
        }else{
            rbg = new BigDecimal(trsQueryData(obj));
        }
        return rbg;
    }
    
    public static List<Map> formatList(List<Map> resultList,List keyList){
        BigDecimal w = new BigDecimal(10000);
        for (int i = 0; i < resultList.size(); i++) {
            Map map = resultList.get(i);
            for (int j = 0; j < keyList.size(); j++) {
                String term = trsQueryData(keyList.get(j));
                BigDecimal term_bd = testNullToBigDecimal(map.get(term));
                map.put(term, term_bd.divide(w).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }
        }
        return resultList;
    }
    
    public static List<Map> reProList(ResultSet rs,List keyList){
        List<Map> list = new ArrayList();
        try {
            while (rs.next()) {
                Map map = new HashMap();
                for (int i = 0; i < keyList.size(); i++) {
                    String term = trsQueryData(keyList.get(i));
                    map.put(term, rs.getString(term));
                }
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public static int getNumberNum(Map map){
        int result = 0;
        String coa_name = map.get("coa_name").toString();
        for(int i=0;i<coa_name.length();i++){
            if(coa_name.charAt(i)>48 && coa_name.charAt(i)<57){
                result++;
            }
        }
        return result;
    }
    
    
    
    
}
