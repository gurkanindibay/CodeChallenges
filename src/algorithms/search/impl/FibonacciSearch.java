package algorithms.search.impl;

public class FibonacciSearch {
    public int findNumberIndex(int requestedNumber, int[] array) {
        int fibM = 1, fibM1 = 1, fibM2 = 0;

        while (fibM < array.length) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM2 + fibM1;
        }

        int offset = -1;
        while (fibM > 1) {
            int i = Math.min(offset + fibM2, array.length - 1);
            if (array[i] == requestedNumber) return i;
            else if (array[i] > requestedNumber) {
                fibM = fibM2;
                fibM1 = fibM1 - fibM2;
                fibM2 = fibM - fibM1;
            } else {
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            }
        }
        if (fibM1 == 1 && array[offset + 1] == requestedNumber) return offset + 1;
        return -1;
    }
}
