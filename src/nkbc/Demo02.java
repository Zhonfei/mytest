/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nkbc;
import java.util.List;
import java.util.ArrayList;
import utils.Tools;

/**
 *
 * @author delta
 */
public class Demo02 implements IDemo{
    public int n;

    public Demo02(int n) {
        this.n = n;
    }

    @Override
    public void demoRun() {
         int i,j;
         List list = snum(n);
         Tools.pl(list);
         for(i=0;i<list.size();i++){
             for(j=0;j<list.size();j++){
                 int p = (int)list.get(i);
                 int q = (int)list.get(j);
                 if(p+q==n){
                     Tools.pl(n+"="+p+"+"+q);
                 }
             }
         }
    }
    
    public List snum(int n){
        List list = new ArrayList();
        for(int i=1;i<=n;i++){
            int k=0;
            for(int j=2;j<=i-1;j++){
                if(i%j==0){
                    k++;
                }
            }
            if(k==0){
                list.add(i);
            }
        }
        return list;
    }
}
