/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author delta
 */
public class TempTest {
    public static void main(String[] args){
        Map map = new HashMap();
        map.put("flag", false);
        test(map);
        System.out.println(map);
    }
    
    public static void test(Map map){
        map.put("flag", !(Boolean)map.get("flag"));
    }
}
