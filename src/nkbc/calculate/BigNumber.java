/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nkbc.calculate;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author delta
 */
public class BigNumber {
    
    private char flag ;
    
    private List<Integer> numberList;
    
    public BigNumber add(BigNumber other){
        BigNumber bn = new BigNumber();
        List<Integer> result = new ArrayList<>();
        List<Integer> teList = new ArrayList<>();
        List<Integer> otherList = other.getNumberList();
        char otherFlag = other.flag;
        if(otherFlag==flag){//同符号相加
            //List 相加
            List<Integer> maxList = null;
            List<Integer> minList = null;
            System.out.println(otherList);
            if(numberList.size()>otherList.size()){
                maxList = numberList;
                minList = otherList;
            }else{
                maxList = otherList;
                minList = numberList;
            }
            int jw = 0;
            for (int i = 0; i < maxList.size(); i++) {
                Integer num1 = maxList.get(i);
                Integer num2 = (i>minList.size()-1)?0:minList.get(i);
                int num = num1+num2+jw;
                String temp = num+"";
                int ys =Integer.parseInt(temp.substring(temp.length()-1));
                if(temp.length()>1){
                    jw = Integer.parseInt(temp.substring(0,temp.length()-1));
                }else{
                    jw = 0;
                }
                teList.add(ys);
                if(i==maxList.size()-1 && jw>0){
                    teList.add(jw);
                }
            }
            for (int j = teList.size()-1; j >=0 ; j--) {
                Integer integer = teList.get(j);
                result.add(integer);
            }
            //组合bignumber
            bn.flag = flag;
            bn.numberList = result;
        }else{//异符号相加
             
        }
        return bn;
    }
    
//    public BigNumber getBigNumber(String str){
//        BigNumber bn = new BigNumber();
//        bn.setFlag(str.charAt(0));
//        List <Integer> list = new ArrayList<>();
//        String temp = str.substring(1);
//        for (int i = 0; i < temp.length(); i++) {
//            Integer integer = Integer.parseInt(temp.charAt(i)+"");
//            list.add(integer);
//        }
//        bn.setNumberList(list);
//        return bn;
//    }

    public BigNumber() {
    }

    public BigNumber(char flag, List<Integer> numberList) {
        this.flag = flag;
        this.numberList = numberList;
    }
    
    

    public char getFlag() {
        return flag;
    }

    public void setFlag(char flag) {
        this.flag = flag;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }
    
    
}
