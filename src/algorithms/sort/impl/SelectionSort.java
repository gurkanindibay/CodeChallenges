package algorithms.sort.impl;

import algorithms.sort.ISort;

public class SelectionSort implements ISort {
    public int[] sort(int[] array) {
        int sortedIndex = 0;
        while (sortedIndex < array.length - 1) {
            int minValue = -1;
            int minValueIndex = -1;
            for (int i = sortedIndex; i < array.length; i++) {
                if (array[i] < minValue || minValue == -1) {
                    minValue = array[i];
                    minValueIndex = i;
                }
            }
            if (minValueIndex > 0) {
                array[minValueIndex] = array[sortedIndex];
                array[sortedIndex] = minValue;
                sortedIndex++;
            }
        }
        return array;
    }
}
