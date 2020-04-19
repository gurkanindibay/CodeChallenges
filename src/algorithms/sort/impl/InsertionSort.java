package algorithms.sort.impl;

import algorithms.sort.ISort;

public class InsertionSort implements ISort {
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] <= array[j]) {
                    int value = array[i];
                    for (int k = i; k > j; k--) {
                        array[k] = array[k - 1];
                    }
                    array[j] = value;
                    break;
                }
            }
        }
        return array;
    }
}
