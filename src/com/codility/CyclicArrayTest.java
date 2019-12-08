package com.codility;

import java.util.Arrays;

public class CyclicArrayTest {

    public static void main(String[] args) {
        int[] testArray = {5,-1000};
        CyclicRotation cyclicRotation = new CyclicRotation();
        Arrays.stream(cyclicRotation.solution(testArray, 1)).forEach(value -> System.out.println(value));
    }
}
