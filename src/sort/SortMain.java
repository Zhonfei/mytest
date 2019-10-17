/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sort;

/**
 *
 * @author delta
 */
public class SortMain {
    public static void main(String[] args) {
        // TODO code application logic here
       int[] data = {1,10,3,4,96,34,2,5};
       ISort bubble = new BubbleSort(data);
       bubble.sortPrint();
       bubble.sort();
       bubble.sortPrint();
//       ISort quicksort = new QuickSort(data);
//       quicksort.sortPrint();
//       quicksort.sort();
//       quicksort.sortPrint();
    }
}
