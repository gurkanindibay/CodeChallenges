package algorithms.sort.impl;

import algorithms.sort.ISort;

public class BubbleSort implements ISort {

    public int[] sort(int[] array) {
        int swapCount = 1;

        while(swapCount > 0){
            swapCount = 0;
            for(int i=1; i < array.length;i++){
                if(array[i-1] > array[i]){
                    int value = array[i-1];
                    array[i-1] = array[i];
                    array[i] = value;
                    swapCount++;
                }
            }
        }
        return array;
    }
}
