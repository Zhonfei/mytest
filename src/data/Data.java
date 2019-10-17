/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author delta
 */
public class Data {
    
    public static List getKeyList(){
        List list = new ArrayList();
        list.add("d1_cur");
        list.add("d7_cur");
        list.add("total");
        return list;
    }
    
    public static List getResultList(){
        List list = new ArrayList();
        
        Map map = new HashMap();
        map.put("coa_name", "3.负债合计");
        map.put("d1_cur", BigDecimal.ZERO);
        map.put("d7_cur", BigDecimal.ZERO);
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "1003");
        map.put("coa_parent_code","0");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.1向中央银行借款");
        map.put("d1_cur", BigDecimal.ZERO);
        map.put("d7_cur", BigDecimal.ZERO);
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "100301");
        map.put("coa_parent_code","1003");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.2同业存放款项");
        map.put("d1_cur", BigDecimal.ZERO);
        map.put("d7_cur", BigDecimal.ZERO);
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "100302");
        map.put("coa_parent_code","1003");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.3同业拆入");
        map.put("d1_cur", BigDecimal.ZERO);
        map.put("d7_cur", BigDecimal.ZERO);
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "100303");
        map.put("coa_parent_code","1003");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.3.1同业拆入人民币");
        map.put("d1_cur", new BigDecimal("450000").setScale(2, BigDecimal.ROUND_HALF_UP));
        map.put("d7_cur", new BigDecimal("450000").setScale(2, BigDecimal.ROUND_HALF_UP));
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "10030301");
        map.put("coa_parent_code","100303");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.3.2同业拆入外币");
        map.put("d1_cur", BigDecimal.ZERO);
        map.put("d7_cur", BigDecimal.ZERO);
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "10030302");
        map.put("coa_parent_code","100303");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.4卖出回购款项");
        map.put("d1_cur", new BigDecimal("647969.63").setScale(2, BigDecimal.ROUND_HALF_UP));
        map.put("d7_cur", new BigDecimal("647969.63").setScale(2, BigDecimal.ROUND_HALF_UP));
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "100304");
        map.put("coa_parent_code","1003");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.5吸收存款");
        map.put("d1_cur", BigDecimal.ZERO);
        map.put("d7_cur", BigDecimal.ZERO);
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "100305");
        map.put("coa_parent_code","1003");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.5.1吸收存款（人民币）");
        map.put("d1_cur", BigDecimal.ZERO);
        map.put("d7_cur", BigDecimal.ZERO);
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "10030501");
        map.put("coa_parent_code","100305");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.5.1.1活期及协定存款");
        map.put("d1_cur", new BigDecimal("2521454.53").setScale(2, BigDecimal.ROUND_HALF_UP));
        map.put("d7_cur", new BigDecimal("2521454.53").setScale(2, BigDecimal.ROUND_HALF_UP));
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "1003050101");
        map.put("coa_parent_code","10030501");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.5.1.2通知存款");
        map.put("d1_cur", BigDecimal.ZERO);
        map.put("d7_cur", BigDecimal.ZERO);
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "1003050102");
        map.put("coa_parent_code","10030501");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.5.1.3定期存款");
        map.put("d1_cur", BigDecimal.ZERO);
        map.put("d7_cur", BigDecimal.ZERO);
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "1003050103");
        map.put("coa_parent_code","10030501");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.5.2吸收存款（外币）");
        map.put("d1_cur", new BigDecimal("2521454.53").setScale(2, BigDecimal.ROUND_HALF_UP));
        map.put("d7_cur", new BigDecimal("2521454.53").setScale(2, BigDecimal.ROUND_HALF_UP));
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "10030502");
        map.put("coa_parent_code","100305");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.6发行债券");
        map.put("d1_cur", BigDecimal.ZERO);
        map.put("d7_cur", BigDecimal.ZERO);
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "100306");
        map.put("coa_parent_code","1003");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.7其他有确定到期日的负债");
        map.put("d1_cur", new BigDecimal("1152263.87").setScale(2, BigDecimal.ROUND_HALF_UP));
        map.put("d7_cur", new BigDecimal("1152263.87").setScale(2, BigDecimal.ROUND_HALF_UP));
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "100307");
        map.put("coa_parent_code","1003");
        list.add(map);
        
        map = new HashMap();
        map.put("coa_name", "3.8没有确定到期日的负债");
        map.put("d1_cur", BigDecimal.ZERO);
        map.put("d7_cur", BigDecimal.ZERO);
        map.put("total", BigDecimal.ZERO);
        map.put("coa_code", "100308");
        map.put("coa_parent_code","1003");
        list.add(map);
        
//        map = new HashMap();
//        map.put("coa_name", "3.9没有确定到期日的负债");
//        map.put("d1_cur", BigDecimal.ZERO);
//        map.put("d7_cur", BigDecimal.ZERO);
//        map.put("total", BigDecimal.ZERO);
//        map.put("coa_code", "100309");
//        map.put("coa_parent_code","1003");
//        list.add(map);
//        
//        map = new HashMap();
//        map.put("coa_name", "3.10没有确定到期日的负债");
//        map.put("d1_cur", BigDecimal.ZERO);
//        map.put("d7_cur", BigDecimal.ZERO);
//        map.put("total", BigDecimal.ZERO);
//        map.put("coa_code", "1003010");
//        map.put("coa_parent_code","1003");
//        list.add(map);
        
        return list;
    }
    
    
}
