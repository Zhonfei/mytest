/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nkbc.card;

import java.util.Collections;
import java.util.List;
import sort.BubbleSort;

/**
 *
 * @author delta
 */
public class PlayMain {
    public static void main(String[] args){
        Person p1,p2,p3;
        p1 = new Person("张三");
        p2 = new Person("李四");
        p3 = new Person("王五");
        
        p1.setNextPerson(p2);
        p2.setNextPerson(p3);
        p3.setNextPerson(p1);
        
        Box box = new Box();
        p1.dealRequest(box);
        showHandleCard(p1,p2,p3,box);
        p1.dealRequest2(box);
        //showHandleCard(p1,p2,p3,box);
        Person p = getFarmPerson(p1,p2,p3);
        p.dealRequest3(box);
    }
    
    public static Person getFarmPerson(Person p1,Person p2,Person p3){
        if(p1.isFarm)return p1;
        if(p2.isFarm)return p2;
        if(p3.isFarm)return p3;
        return null;
    }
    
    public static void showHandleCard(Person p1,Person p2,Person p3,Box box){
        System.out.println(p1.name+":");
        sortList(p1.list);
        System.out.println(p1.list);
        
        System.out.println(p2.name+":");
        sortList(p2.list);
        System.out.println(p2.list);
        
        System.out.println(p3.name+":");
        sortList(p3.list);
        System.out.println(p3.list);
        System.out.println(box.card);
    }
    
    public static void sortList(List list){
        for(int i =0;i<list.size();i++){
            String num = list.get(i).toString();
            if(num.equals("J")){
                list.remove(i);
                list.add(i,11);
            }else if(num.equals("Q")){
                list.remove(i);
                list.add(i,12);
            }else if(num.equals("K")){
                list.remove(i);
                list.add(i,13);
            }else if(num.equals("A")){
                list.remove(i);
                list.add(i,14);
            }else if(num.equals("2")){
                list.remove(i);
                list.add(i,15);
            }else if(num.equals("S")){
                list.remove(i);
                list.add(i,16);
            }else if(num.equals("L")){
                list.remove(i);
                list.add(i,17);
            }
        }
        //sort
        int[] data = new int[list.size()];
        for (int i = 0; i < data.length; i++) {
            int num = Integer.parseInt(list.get(i).toString());
            data[i] = num;
        }
        BubbleSort bs = new BubbleSort(data);
        bs.sort();
        list.clear();
        for (int i = 0; i < data.length; i++) {
           if(data[i]==11){
               list.add("J");
           }else if(data[i]==12){
               list.add("Q");
           }else if(data[i]==13){
               list.add("K");
           }else if(data[i]==14){
               list.add("A");
           }else if(data[i]==15){
               list.add("2");
           }else if(data[i]==16){
               list.add("S");
           }else if(data[i]==17){
               list.add("L");
           }else{
               list.add(data[i]+"");
           }
        }
    }
    
    
}
