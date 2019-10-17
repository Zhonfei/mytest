/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

import utils.Tools;

/**
 *
 * @author delta
 */
public class TestThread extends Common{
    private int count;

    @Override
    public synchronized void run() {
        count++;
        Tools.p("test"+count);
    }
    
    
}
