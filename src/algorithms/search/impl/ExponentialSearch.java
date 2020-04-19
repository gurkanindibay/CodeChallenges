package algorithms.search.impl;

public class ExponentialSearch {
    public int findNumberIndex(int requestedNumber, int[] array) {
        int high = array.length - 1;
        int low = 0;
        int pos = 1;
        while (pos <= high && array[pos] < requestedNumber) {
            pos = pos * 2;
        }
        BinarySearchOwn binarySearchOwn = new BinarySearchOwn();
        return binarySearchOwn.findNumberIndex(requestedNumber, array, pos/2, Math.min(pos,high));
    }
}
