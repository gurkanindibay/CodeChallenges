package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation1(int n, int[][] queries) {

        long[] resultArray = new long[n];
        long maxValue = 0;
        for (int i = 0; i < queries.length; i++) {
            int startIndex = queries[i][0];
            int endIndex = queries[i][1];
            int value = queries[i][2];
            for (int j = startIndex - 1; j < endIndex; j++) {
                resultArray[j] += value;
                if (resultArray[j] > maxValue) maxValue = resultArray[j];
            }
        }

        //for (int i : resultArray) {
        //  System.out.print(i + " ");
        //}

        return maxValue;
    }

    static long arrayManipulation(int n, int[][] queries) {

        long[] resultArray = new long[n];
        for (int i = 0; i < queries.length; i++) {
            int startIndex = queries[i][0];
            int endIndex = queries[i][1];
            int value = queries[i][2];

            resultArray[startIndex - 1] += value;
            if (endIndex < n) resultArray[endIndex] -= value;

//            for (long j : resultArray) {
//                System.out.print(j + " ");
//            }
//
//            System.out.println();

        }

        long maxValue = 0;
        long temp = 0;

        for (int i = 0; i < n; i++) {
            temp += resultArray[i];
            if (temp > maxValue) maxValue = temp;
        }

//
//        for (long i : resultArray) {
//            System.out.print(i + " ");
//        }

        return maxValue;
    }

    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner(Paths.get("resources/input_array_manipulation.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
