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
public class BubbleSort implements ISort{
    private int[] data;
    
    @Override
    public void sort(){
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {
                if(data[j]<data[i]){
                    int temp = data[j];
                    data[j] = data[i];
                    data[i] = temp;
                }
            }
        }
    }
    
    @Override
    public void sortPrint(){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public BubbleSort(int[] data) {
        this.data = data;
    }
}
