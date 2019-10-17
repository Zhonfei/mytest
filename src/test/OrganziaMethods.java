/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author delta
 */
public class OrganziaMethods {
    private static final int INITLEN = 4;
    Gson gson = new Gson();
    
    public List getSumResultList(List resultList,List keyList){
        List parentList;
        Set set = new HashSet();
        for (int i = 0; i < resultList.size(); i++) {
            Map map = (Map) resultList.get(i);
            String parent_coa_code = trsQueryData(map.get("parent_coa_code"));
            set.add(parent_coa_code);
        }
        parentList = new ArrayList(set);
        Collections.sort(parentList);
        //System.out.println("***********");
        System.out.println(parentList);
        for (int i = parentList.size()-1; i >= 0 ; i--) {
            String parent = trsQueryData(parentList.get(i));
            for (int j = 0; j < keyList.size()-1; j++) {
                String term = trsQueryData(keyList.get(j));
                BigDecimal result = BigDecimal.ZERO;
                for (int k = 0; k < resultList.size(); k++) {
                    Map map = (Map) resultList.get(k);
                    BigDecimal cur = testNullToBigDecimal(map.get(term));
                    String parent_coa_code = trsQueryData(map.get("parent_coa_code"));
                    if(parent_coa_code.equals(parent)){
                        result = result.add(cur);
                    }
                }
                if(i==0){
                    break;
                }
                for (int k = 0; k < resultList.size(); k++) {
                    Map map = (Map) resultList.get(k);
                    String coa_code = trsQueryData(map.get("coa_code"));
                    if(parent.equals(coa_code)){
                        map.put(term, result.toString());
                    }
                }
            }
        }
        
        for (int i = 0; i < resultList.size(); i++) {
            Map map = (Map) resultList.get(i);
            BigDecimal sum = BigDecimal.ZERO;
            for (int j = 0; j < keyList.size()-1; j++) {
                String term = trsQueryData(keyList.get(j));
                sum = sum.add(testNullToBigDecimal(map.get(term)));
            }
            map.put("total", sum.toString());
        }
        
        return resultList;
    }
    
    public List testGetSumResultList(List resultList){
        int maxLen = getMaxLength(resultList);
        List tempList = new ArrayList();
        Set set = new HashSet();
        for (int len = maxLen; len >= INITLEN; len=len-2) {
            for (int i = 0; i < resultList.size(); i++) {
                Map map = (Map) resultList.get(i);
                String coa_code = trsQueryData(map.get("coa_code"));
                String parent_coa_code = trsQueryData(map.get("parent_coa_code"));
                if(coa_code.length()==len){
                    tempList.add(map);
                }
                set.add(parent_coa_code);
            }
            //tempList.add(len);
        }
        
        List sortList = new ArrayList(set);
        Collections.sort(sortList);
        for (int i = sortList.size()-1; i >= 0; i--) {
            String parent = trsQueryData(sortList.get(i));
            BigDecimal sum = BigDecimal.ZERO;
            for (int j = 0; j < resultList.size(); j++) {
                Map map = (Map) resultList.get(j);
                String coa_code = trsQueryData(map.get("coa_code"));
                if(coa_code.equals(parent)){
                    for (int k = 0; k < tempList.size(); k++) {
                        Map tmap = (Map) tempList.get(k);
                        String parent_coa_code = trsQueryData(tmap.get("parent_coa_code"));
                        BigDecimal cur_cal = testNullToBigDecimal(tmap.get("cur_cal"));
                        if(parent_coa_code.equals(parent)){
                            sum = sum.add(cur_cal);
                        }
                    }
                    map.put("cur_cal", sum.toString());
                }
            }
        }
        
       // System.out.println("======\n"+sortList+"\n=====");
        
       // System.out.println("******\n"+trsGson(tempList)+"\n******");
        return resultList;
    }
    
    public String trsGson(List list){
        return gson.toJson(list);
    }
    
    public int getMaxLength(List resultList){
        Map map0 = (Map)resultList.get(0);
        String code0 = trsQueryData(map0.get("coa_code"));
        int max = code0.length();
        for (int i = 0; i < resultList.size(); i++) {
            Map map = (Map)resultList.get(i);
            String coa_code = trsQueryData(map.get("coa_code"));
            if(max<coa_code.length()){
                max = coa_code.length();
            }
        }
        return max;
    }
    
    /**
     * 子项往父项汇总
     * @param map 父项map
     * @param leveList 子项map集合
     * @return 
     */
    public void organSum(Map paMap,List leveList){
        BigDecimal resBigDecimal = BigDecimal.ZERO;
        for (int i = 0; i < leveList.size(); i++) {
            Map  map = (Map)leveList.get(i);
            BigDecimal bal = testNullToBigDecimal(map.get("cur_cal"));
            resBigDecimal=resBigDecimal.add(bal);
        }
        paMap.put("cur_cal", resBigDecimal);
    }
      
    public BigDecimal testNullToBigDecimal(Object obj){
        BigDecimal returnBigDecimal = BigDecimal.ZERO;
        if(obj==null || "".equals(obj)){
            returnBigDecimal = BigDecimal.ZERO;
        }else{
            returnBigDecimal = new BigDecimal(obj.toString());
        }
        return returnBigDecimal;
    }
    
    public String trsQueryData(Object obj){
        return obj==null?"":obj.toString();
    }
}
