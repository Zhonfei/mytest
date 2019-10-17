/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nkbc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import utils.Tools;

/**
 *
 * @author delta
 */
public class Demo05 implements IDemo{

    @Override
    public void demoRun() {
        Tools.p("please input number(6):");
        int en = new Scanner(System.in).nextInt();
        List list2 = changeNumList(en);
        Tools.pl(list2);
        boolean flag[] = new boolean[6];
        for(int i=0;i<flag.length;i++){
            flag[i] = listInList(changeNumList(en*(i+1)),list2);
        }
        int k=0;
        for(int i=0;i<flag.length;i++){
            if(flag[i]){
                k++;
            }
        }
        if(k==flag.length){
            Tools.pl("yes");
        }else{
            Tools.pl("no");
            Tools.pl("k="+k);
        }
    }
    
    public List changeNumList(int num){
        List list = new ArrayList();
        list.add(num/100000);
        list.add((num%100000)/10000);
        list.add(num%100000%10000/1000);
        list.add(num%100000%10000%1000/100);
        list.add(num%100000%10000%1000%100/10);
        list.add(num%100000%10000%1000%100%10);
        return list;
    }
    
    public boolean isExistNum(int num,List list){
        boolean flag = false;
        for(int i=0;i<list.size();i++){
            if((int)list.get(i)==num){
                flag = true;
            }
        }
        return flag;
    }
    
    public boolean listInList(List list1,List list2){
        Tools.pl("..."+list1+"\t");
        int k = 0;
        for(int i=0;i<list1.size();i++){
            if(isExistNum((int)list1.get(i),list2)){
                k++;
            }
        }
        return k==list1.size();
    }
}
