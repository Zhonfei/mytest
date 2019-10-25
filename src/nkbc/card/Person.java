/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nkbc.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author delta
 */
public class Person {
    
    public String name;
    public List list = new ArrayList();
    private Person nextPerson;
    public boolean isFarm;
    
    public void dealRequest3(Box box){
        System.out.println(this.name+"正在处理...");
        System.out.println("before:"+box.lastCard);
        System.out.println(this.name+":"+this.list);
            System.out.print("please select:");
            String flag = new Scanner(System.in).next();
            if(!"0".equals(flag)){
                String[] flags = flag.split(",");
                List list = new ArrayList(flags.length);
                for (int i = 0; i < flags.length; i++) {
                    String string = flags[i];
                    this.list.remove(string);
                    list.add(string);
                }
                box.lastCard = list;
                if(this.list.isEmpty()){
                    System.out.println(this.name+":Vector");
                }else{
                    System.out.println(this.name+"处理完毕......");
                    nextPerson.dealRequest3(box);
                }
            }else{
                System.out.println(this.name+"处理完毕......");
                nextPerson.dealRequest3(box);
            }
    }
    
    public void dealRequest2(Box box){
       System.out.println(this.name+"正在处理...");
       System.out.println(this.name+":"+this.list);
       System.out.println("please select one(Y/N):");
       String flag = new Scanner(System.in).next();
       if("Y".equalsIgnoreCase(flag)){
           for (int i = 0; i < 3; i++) {
               getCard(box.card);
           }
           isFarm = true;
       }else{
           nextPerson.dealRequest2(box);
       }
       System.out.println(this.name+"处理完毕");
    }
    
    public void dealRequest(Box box){
       System.out.println(this.name+"正在处理...");
       getCard(box.card);
       System.out.println(this.name+"处理完毕");
       if(nextPerson!=null && box.card.size()>3){
           nextPerson.dealRequest(box);
       }
//       if(this.list.size()==17){
//           Collections.sort(this.list);
//           System.out.println(this.list);
//       }
    }
    
    private void getCard(List card){
        int romI = new Random().nextInt(card.size());
        list.add(card.get(romI));
        card.remove(romI);
        System.out.println(list);
    }

    public Person(String name) {
        this.name = name;
    }

    public void setNextPerson(Person nextPerson) {
        this.nextPerson = nextPerson;
    }
    
    
}
