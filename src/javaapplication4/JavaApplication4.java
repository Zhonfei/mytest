/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication4;

import sort.ISort;
import sort.QuickSort;

/**
 *
 * @author delta
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       int[] data = {1,10,3,4,96,34,2,5};
       ISort quicksort = new QuickSort(data);
       quicksort.sortPrint();
       quicksort.sort();
       quicksort.sortPrint();
    }
    
}
