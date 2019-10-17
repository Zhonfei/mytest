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

/**
 *
 * @author delta
 */
public class Person {
    
    public String name;
    public List list = new ArrayList();
    private Person nextPerson;
    
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
