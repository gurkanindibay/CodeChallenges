package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class FraudelentActivityNotificationsWithCountSum {


    static int activityNotifications(int[] expenditure, int d) throws IOException {

        int alertCount = 0;

        int maxValue = Arrays.stream(expenditure).max().getAsInt();

        int[] countArray = new int[maxValue + 1];

        for (int i = 0; i < d; i++) {
            countArray[expenditure[i]]++;
        }
        for (int i = d; i < expenditure.length; i++) {
            int medianX2 = getMedianX2(countArray, d);
            System.out.println(medianX2);
            if (expenditure[i] >= medianX2) alertCount++;
            countArray[expenditure[i - d]]--;
            countArray[expenditure[i]]++;
        }
        return alertCount;

    }

    static int getMedianX2(int[] countArray, int d) {
        int trailingArrayLength = 0;
        int medianX2 = 0;
        int indexCount = 0;
        if (d % 2 == 1) {
            for (int i = 0; i < countArray.length; i++) {
                indexCount += countArray[i];
                if (indexCount >= (d / 2 + 1)) {
                    medianX2 = 2 * (i);
                    break;
                }
            }
        } else {
            int firstMedianIndex = d / 2;
            int secondMedianIndex = firstMedianIndex + 1;
            int firstMedian = -1;
            int secondMedian = -1;
            for (int i = 0; i < countArray.length; i++) {
                indexCount += countArray[i];
                if (indexCount >= firstMedianIndex && firstMedian < 0) {
                    firstMedian = i;
                }
                if (indexCount >= secondMedianIndex && secondMedian < 0) {
                    secondMedian = i;
                    break;
                }
                //if(firstMedian > 0 && secondMedian > 0) break;
            }


            medianX2 = firstMedian + secondMedian;
        }

        return medianX2;
    }


    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get(("resources/input_fraudelent_simple.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
