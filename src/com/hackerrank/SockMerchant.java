package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {

        return solutionByReduce(ar);

    }

    private static int solutionByReduce(int[] ar) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            if (!countMap.containsKey(ar[i])) countMap.put(ar[i], 1);
            else countMap.put(ar[i], countMap.get(ar[i]) + 1);
        }
        return countMap.values().stream().reduce(0, (sum, element) -> sum + element / 2);
    }

    private static int solutionByAtomicInteger(int[] ar) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            if (!countMap.containsKey(ar[i])) countMap.put(ar[i], 1);
            else countMap.put(ar[i], countMap.get(ar[i]) + 1);
        }
        AtomicInteger pairCount = new AtomicInteger(0);
        countMap.values().forEach(v -> pairCount.addAndGet(v / 2));
        return pairCount.get();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
        int[] testArray = {10, 20, 20, 10, 10, 30, 50, 10, 20, 20};

        System.out.println(sockMerchant(9, testArray));

    }
}
