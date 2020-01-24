package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FraudelentActivityNotificationsBinarySort {


    static class IndexValue implements Comparable {
        Integer number;
        int index;

        public IndexValue(int number, int index) {
            this.number = number;
            this.index = index;
        }

        @Override
        public int compareTo(Object o) {
            return number.compareTo(((IndexValue) o).number);
        }
    }


    static int activityNotifications(int[] expenditure, int d) throws IOException {

        int alertCount = 0;




        return alertCount;


    }

    private static void addValueToSortedList(int[] expenditure, List<IndexValue> sortedList, int index, int medianValue) {

        int endIndex = sortedList.size();
        int startIndex = 0;

        if (expenditure[index] * 2 == medianValue) {
            sortedList.add(sortedList.size() / 2, new IndexValue(expenditure[index], index));
            return;
        } else if (expenditure[index] * 2 > medianValue) {
            endIndex = sortedList.size();
            startIndex = endIndex / 2;
        } else {
            endIndex = sortedList.size() / 2;
            startIndex = 0;
        }

        while (endIndex != startIndex) {
            if (expenditure[index] == sortedList.get((startIndex + endIndex) / 2).number || endIndex - startIndex <= 1) {
                sortedList.add((startIndex + endIndex) / 2, new IndexValue(expenditure[index], index));
                break;
            } else if (expenditure[index] > sortedList.get((startIndex + endIndex) / 2).number) {
                startIndex = new Double(Math.floor(startIndex + endIndex) / 2).intValue();
            } else if (expenditure[index] < sortedList.get((startIndex + endIndex) / 2).number) {
                endIndex = new Double(Math.ceil(startIndex + endIndex) / 2).intValue();
            } else {
                throw new RuntimeException("Unsupported condition");
            }
        }
    }


    static class MedianValueWithIndex {
        int medianValueMulipleBy2;
        int index;

        MedianValueWithIndex(int medianValueMulipleBy2, int index) {
            this.medianValueMulipleBy2 = medianValueMulipleBy2;
            this.index = index;
        }

    }


    static MedianValueWithIndex findMedianMultipliedByTwo(List<IndexValue> sortedList) {
        if (sortedList.size() % 2 == 1)
            return new MedianValueWithIndex(2 * sortedList.get(sortedList.size() / 2).number, sortedList.size() / 2);
        else {
            int arraySize = sortedList.size();
            int firstMedian = sortedList.get((arraySize + 1) / 2).number;
            int secondMedian = sortedList.get(((arraySize + 1) / 2) - 1).number;
            return new MedianValueWithIndex(firstMedian + secondMedian, sortedList.get((arraySize + 1) / 2).index);
        }
    }


    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get(("resources/input_fraudelent.txt")));
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
