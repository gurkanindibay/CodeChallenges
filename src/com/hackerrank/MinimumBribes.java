package com.hackerrank;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumBribes {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribeCount = 0;
        boolean isTooChaotic = false;
        for (int i = 0; i < q.length; i++) {
            int indexDiff = q[i] - i - 1;
            if (indexDiff > 2) {
                isTooChaotic = true;
                break;
            } else {
                if (indexDiff > 0) bribeCount = bribeCount + indexDiff;
            }
        }
        if (isTooChaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribeCount);
        }


    }

    static void minimumBribes2(int[] q) {
        int bribeCount = 0;
        boolean isTooChaotic = false;
        boolean isDisordered = true;
        int startIndex = 0;
        boolean isOrderedInArrayPass = true;
        while (isDisordered) {
            if (startIndex == 0) isOrderedInArrayPass = true;
            int indexDiff = q[startIndex] - (startIndex + 1);
            if (indexDiff > 2) {
                isTooChaotic = true;
                break;
            } else {
                if (indexDiff > 0 && q[startIndex] > q[startIndex + 1]) {
                    bribeCount++;
                    int value = q[startIndex];
                    q[startIndex] = q[startIndex + 1];
                    q[startIndex + 1] = value;
                    //System.out.println("Swap:"+q[startIndex+1]+"->"+ q[startIndex]);
                    //Arrays.stream(q).forEach(v-> System.out.print(v+" "));
                    //System.out.println();
                    startIndex = (startIndex + 1) % q.length;
                    isOrderedInArrayPass = false;

                } else {
                    startIndex = (startIndex + 1) % q.length;
                }
            }
            if (startIndex == 0 && isOrderedInArrayPass) isDisordered = false;
        }
        if (isTooChaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribeCount);
        }
    }

    static int bubbleSort(int[] arr) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                }
            }
        }
        return count;
    }

    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner(Paths.get("resources/input_bribe.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            //System.out.println(qItems.length);
            //System.out.println(n);
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes2(q);
        }

        scanner.close();
    }
}
