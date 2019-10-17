/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.ArrayList;
import java.util.List;
import utils.Tools;

/**
 *
 * @author delta
 */
public class TermKey {
    
    public static List getBaseKeyList(){
        List list = new ArrayList();
        list.add("COA_CODE");
        list.add("COA_PARENT_CODE");
        List termList = SQLData.getKeyList();
        for (int i = 0; i < termList.size(); i++) {
            list.add(Tools.trsQueryData(termList.get(i)));
        }
        System.out.println(list);
        return list;
    }
    
    public static List getOverAndPeriodKeyList(){
        List list = new ArrayList();
        list.add("COA_CODE");
        list.add("COA_PARENT_CODE");
        list.add("OVERDUE_CUR");
        list.add("UNPERIOD_CUR");
        System.out.println(list);
        return list;
    }
    
    public static List getFrameKeyList(){
        List list = new ArrayList();
        List termList = getBaseKeyList();
        
        list.add("ID");
        list.add("COA_PLAN_CODE");
        list.add("COA_CODE");
        list.add("COA_NAME");
        list.add("COA_PARENT_CODE");
        
        for (int i = 0; i < termList.size(); i++) {
            list.add(Tools.trsQueryData(termList.get(i)));
        }
        list.add("OVERDUE_CUR");
        list.add("UNPERIOD_CUR");
        list.add("TOTAL");
        System.out.println(list);
        return list;
    }
}
