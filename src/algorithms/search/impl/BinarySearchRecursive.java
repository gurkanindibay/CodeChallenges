package algorithms.search.impl;

public class BinarySearchRecursive {

    public int findNumberIndex(int value, int[] array) {
        return findNumberIndex(value, 0,array.length-1,array);
    }

    private int findNumberIndex(int value, int lower, int higher, int[] array) {
        int medium = (lower + higher) / 2;

        if (value == array[medium]) return medium;
        else if (lower == higher) return -1;
        else if (value < array[medium]) return findNumberIndex(value, lower, medium - 1, array);
        else return findNumberIndex(value, medium + 1, higher, array);
    }
}
