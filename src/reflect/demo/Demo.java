/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reflect.demo;

import reflect.bean.ReDemo;
import utils.Tools;

/**
 *
 * @author delta
 */
public class Demo {
    public  static  void  main(String[] args){
        System.out.println("start...");
        ReDemo rd = new ReDemo();
        for (int i = 1; i < 7; i++) {
            Tools.dyff("demo0"+i, ReDemo.class);
        }
       /* rd.demo01();
        rd.demo02();
        rd.demo03();
        rd.demo04();
        rd.demo05();
        rd.demo06();*/
        System.out.println("over...");
    }
}
