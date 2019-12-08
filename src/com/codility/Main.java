package com.codility;

public class Main {

    public static void main(String[] args) {
        int[] testArray = testSet2();
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        System.out.println(oddOccurrencesInArray.solution(testArray));
    }

    private static int[] testSet1() {
        return new int[]{1, 2, 3, 4, 5, 6, 2, 3, 4, 5, 6};
    }
    private static int[] testSet2() {
        return new int[]{9,3,9,3,9,7,9};
    }
}
