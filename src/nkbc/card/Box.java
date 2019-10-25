/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nkbc.card;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author delta
 */
public class Box {
    
    public List card = new ArrayList<>();
    public List lastCard = new ArrayList<>();
    
    public Box() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 11; j++) {
                card.add(j+"");
            }
            card.add("J");
            card.add("Q");
            card.add("K");
            card.add("A");
        }
        card.add("S");
        card.add("L");
        System.out.println(card);
    }
    
    public String getNumber(String flag){
        String number = "0";
        switch(flag){
           case "J":{
                    number = "11"; break;
                }
           case "Q":{
                    number = "12"; break;
                }
           case "K":{
                    number = "13"; break;
                } 
           case "A":{
                    number = "14"; break;
                } 
           case "2":{
                    number = "15"; break;
                } 
           case "S":{
                    number = "16"; break;
                }
           case "L":{
                    number = "17"; break;
                } 
           default:{
               number = "0";
           }
        }
        return number;
    }
}
