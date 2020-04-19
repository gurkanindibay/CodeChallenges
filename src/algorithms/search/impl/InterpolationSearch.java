package algorithms.search.impl;

public class InterpolationSearch {

    public int findNumberIndex(int requestedNumber, int[] array) {
        int high = array.length - 1;
        int low = 0;
        int counter = 0;
        while (low <= high) {
            counter++;
            System.out.println("Counter:"+counter);
            if (low == high) {
                if (array[low] == requestedNumber) return low;
                else return -1;
            }

            int pos = low + (((high - low) /
                    (array[high] - array[low])) * (requestedNumber - array[low]));
            if (array[pos] == requestedNumber) return pos;
            else if (array[pos] > requestedNumber) {
                high = pos - 1;
            } else {
                low = pos + 1;
            }
        }

        return -1;
    }
}
