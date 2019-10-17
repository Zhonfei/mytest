/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nkbc;

import utils.Tools;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author delta
 */
public class Demo01 implements IDemo{
    public int snum;
   

    public Demo01(int snum) {
        this.snum = snum;
    }
    
    

    @Override
    public void demoRun() {
        int[] a = new int[snum];
        
        int aSum = 0;
        int m = 1;
        for(int i=0;i<a.length;i++){
            Tools.p("please input number:");
            a[i] = new Scanner(System.in).nextInt();
            aSum+=a[i];
            m = m*a[i];
        }
        Tools.pl(aSum);
        division(a,m);
    }
   
    public void division(int[] a,int m){
        Map map = new HashMap<Integer,Integer>();
        Tools.pl("snum="+snum);
      //  Tools.pl("mnum="+(m-1));
        for(int i=0;i<a.length;i++){
            map.put(i, m/a[i]);
            Tools.pl((i+1)+":"+(m/a[i]));
        }
        int msum = 0;
        for(int i=0;i<map.size();i++){
            msum+=(int)map.get(i);
        }
        Tools.pl("nnum="+(m-msum));
        Tools.pl("mnum="+msum);
    }
    
    
    
}
