/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nkbc;

import utils.Tools;

/**
 *
 * @author delta
 */
public class Demo03 implements IDemo{
    public int num;

    @Override
    public void demoRun() {
       for(int i=0;i<=num;i++){
           String snum = i+"";
           if(snum.indexOf("1")>=0){
               Tools.p(i+" ");
           }
       }
    }

    public Demo03(int num) {
        this.num = num;
    }
    
    
}
