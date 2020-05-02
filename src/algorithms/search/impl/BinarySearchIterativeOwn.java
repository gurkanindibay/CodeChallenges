package algorithms.search.impl;

public class BinarySearchIterativeOwn {
    public int findNumberIndex(int value, int[] array) {
        int lower = 0, higher = array.length;
        while (true) {
            int medium = (lower + higher) / 2;
            if (value == array[medium]) return medium;
            else if(lower == medium || higher== medium) return -1;
            else if (value > array[medium]) lower = medium + 1;
            else higher = medium - 1;
        }
    }
}
