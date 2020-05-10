package com.hackerrank.search;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IceCreamParlor {
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            valueMap.put(cost[i], i);
        }
        for (int i = 0; i < cost.length; i++) {
            Integer diffIndex = valueMap.getOrDefault(money - cost[i], 0);
            if (diffIndex > 0) {
                System.out.println((i + 1) + " " + (diffIndex + 1));
                break;
            }
        }
    }

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get(("resources/search/input_ice_cream_parlor.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
