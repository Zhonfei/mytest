/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nkbc;

import java.util.Scanner;
import utils.Tools;

/**
 *
 * @author delta
 */
public class Demo06 implements IDemo{
    public int resu;
    
    @Override
    public void demoRun() {
        Tools.p("please input num;");
        Tools.p(getResult(new Scanner(System.in).nextInt()));
    }
    
    public int getResult(int num){
       if(num<10){
           return num;
       }
       return  getNumSum(num);
    }
    
    public int getNumSum(int num){
        String str = num+"";
        int result = 0;
        for(int i=0;i<str.length();i++){
            resu += charToInt(str.charAt(i));
        }
        if(resu<10){
           result =  resu;
        }else{
            Tools.pl("resu:"+resu);
            int temp = resu;
            resu = 0;
            result = getNumSum(temp);
        }
        return result;
    }
    
    
    
    public int charToInt(char c){
        String s = c+"";
        return Integer.parseInt(s);
    }
    
   
}
