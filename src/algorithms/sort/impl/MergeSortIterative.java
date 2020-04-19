package algorithms.sort.impl;

import algorithms.sort.ISort;

public class MergeSortIterative implements ISort {
    @Override
    public int[] sort(int[] array) {
        int arraySize = array.length;
        for (int index = 1; index <= arraySize - 1; index = 2 * index) {
            // Pick starting point of different subarrays of current size
            for (int low = 0; low < arraySize - 1; low += 2 * index) {
                // Find ending point of left subarray. mid+1 is starting
                // point of right
                int medium = Math.min(low + index - 1, arraySize - 1);

                int high = Math.min(low + 2 * index - 1, arraySize - 1);

                System.out.println("Merge:" + low + "," + medium + "," + high);

                // Merge Subarrays arr[left_start...mid] & arr[mid+1...right_end]
                merge(array, low, medium, high);
            }
            System.out.println();
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
