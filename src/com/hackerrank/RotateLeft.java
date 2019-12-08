package com.hackerrank;

import java.util.Arrays;

public class RotateLeft {

    static int[] rotLeft(int[] a, int d) {
        if (a == null || a.length <= 1) return a;
        int shiftCount = d % a.length;
        int[] shiftedArray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            shiftedArray[i] = a[(i + shiftCount) % a.length];
        }
        return shiftedArray;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};

        Arrays.stream(rotLeft(a, 4)).forEach(v -> System.out.println(v));
    }
}
