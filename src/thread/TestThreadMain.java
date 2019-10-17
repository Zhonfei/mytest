/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

/**
 *
 * @author delta
 */
public class TestThreadMain {
    public static void main(String[] args){
        Runnable run = new TestThread();
        Thread[] th = new Thread[5];
        for(int i=0;i<5;i++){
            th[i] = new Thread(run);
            th[i].start();
        }
    }
}
