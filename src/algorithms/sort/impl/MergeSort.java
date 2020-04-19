package algorithms.sort.impl;

import algorithms.sort.ISort;

public class MergeSort implements ISort {

    public int[] sort(int[] array) {
        return mergeSort(array, 0, array.length - 1);

    }

    private int[] mergeSort(int[] array, int low, int high) {
        int medium = (low + high) / 2;
        if (high > low) {
            mergeSort(array, low, medium);
            mergeSort(array, medium + 1, high);
            System.out.println("Merge:" + low + "," + medium + "," + high);
            merge(array, low, medium, high);
        }
        return array;
    }

    private void merge(int[] array, int low, int medium, int high) {
        for (int i = medium + 1; i <= high; i++) {
            for (int j = low; j <= i; j++) {
                if (array[i] <= array[j]) {
                    int valueToInsert = array[i];
                    for (int k = i; k > j; k--) {
                        array[k] = array[k - 1];
                    }
                    array[j] = valueToInsert;
                }
            }
        }
    }
}
