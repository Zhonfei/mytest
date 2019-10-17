/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import nkbc.calculate.BigNumber;

/**
 *
 * @author delta
 */
public class CalculateTest {
    public static void main(String[] args){
//        String temp = 134567214+"";
//        int ys =Integer.parseInt((134567214+"").substring((134567214+"").length()-1));
//        System.out.println(ys);
        
        BigNumber bn1 = getBigNumber("-99999999999999999999");
        BigNumber bn2 = getBigNumber("-22222222222222222222");
        BigNumber bn = bn1.add(bn2);
        System.out.println(new BigDecimal("-99999999999999999999").add(new BigDecimal("-22222222222222222222")));
        System.out.println(showBigNumber(bn));
    }
    
    public static BigNumber getBigNumber(String s){
        BigNumber bigNumber = new BigNumber();
        List<Integer> list = new ArrayList<Integer>();
        char flag = s.charAt(0);
        String str = s.substring(1);
        for (int i = 0; i < str.length(); i++) {
            Integer num = Integer.parseInt(str.charAt(i)+"");
            list.add(num);
        }
        bigNumber.setFlag(flag);
        bigNumber.setNumberList(list);
        return bigNumber;
    }
    
    public static String showBigNumber(BigNumber bigNumber){
        String s1 = bigNumber.getFlag()+"";
        StringBuffer sb = new StringBuffer();
        List<Integer> list = bigNumber.getNumberList();
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            sb.append(integer);
        }
        return s1+new String(sb);
    }
}
