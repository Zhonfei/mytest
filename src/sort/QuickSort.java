/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sort;

import java.util.Arrays;
import utils.Tools;
/**
 *
 * @author delta
 */
public class QuickSort implements ISort{
    public int[] data;

    public QuickSort(int[] data) {
        this.data = data;
    }

    @Override
    public void sort() {
        // Arrays.sort(data);
        
    }

    @Override
    public void sortPrint() {
       for(int i=0;i<data.length;i++){
           Tools.p(data[i]+" ");
       }
       Tools.p("\n");
    }

   
    
    
}
