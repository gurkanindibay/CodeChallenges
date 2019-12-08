package com.hackerrank;

public class TwoDArray {

    static int hourglassSum(int[][] arr) {
        if (arr == null || arr.length < 3 || arr[0].length < 3) return 0;

        int maxHourGlassSum = -50000;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 2; j++) {
                int hourGlassSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                if (hourGlassSum > maxHourGlassSum) maxHourGlassSum = hourGlassSum;
                //System.out.println("i:"+i+" j:"+j+" sum:"+hourGlassSum);
            }
        }

        return maxHourGlassSum;

    }

    public static void main(String[] args) {
        int[][] sampleArray = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};

        int[][] sampleArray2 = {
                {3, 7, -3, 0, 1, 8},
                {1, -4, -7, -8, -6, 5},
                {-8, 1, 3, 3, 5, 7},
                {-2, 4, 3, 1, 2, 7},
                {2, 4, -5, 1, 8, 4},
                {5, -7, 6, 5, 2, 8}};
  int[][] sampleArray3 = {
                {-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, 5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5}};


        System.out.println(hourglassSum(sampleArray3));
    }
}
