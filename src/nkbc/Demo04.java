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
public class Demo04 implements IDemo{
    public int mknum;
    public int firstDivi;

    @Override
    public void demoRun() {
        int sum = 0;
        for(int i=0,j=firstDivi;i<mknum;i++,j--){
            sum += 5*firstDivi+1;
            Tools.pl("mknum："+i+"\tdivi："+j);
        }
        Tools.pl(sum);
    }

    public Demo04(int mknum, int firstDivi) {
        this.mknum = mknum;
        this.firstDivi = firstDivi;
    }
    
    
}