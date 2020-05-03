package com.hackerrank.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Evalluation: I spent most of the time to cover all of the corner cases. Especially mapping difference of sequential values and correctly sum the values to form the difference. I could not cover performance requirements of
//two test cases
public class MinFairness {
    static int maxMin(int k, int[] arr) {

        Supplier<Stream<Integer>> streamSupplier = () -> Arrays.stream(arr)
                .boxed().sorted();
        Integer[] sortedArray = streamSupplier.get().toArray(Integer[]::new);
        AtomicInteger i = new AtomicInteger();
        Integer[] buffer = streamSupplier.get().map(v -> {
            int index = i.getAndIncrement();
            int val = index == 0 ? 0 : v - sortedArray[index - 1];
            return val;
        }).toArray(Integer[]::new);

        AtomicInteger j = new AtomicInteger();
        return Arrays.stream(buffer).map(v -> {
            int sum = 0;
            int counter = 0;
            int jIndex = j.getAndIncrement();
            for (int l = jIndex + 1; counter < k - 1 && l < buffer.length; l++) {
                sum += buffer[l];
                counter++;
            }
//            System.out.println("Counter:"+counter);
            if (counter < k-1) sum = Integer.MAX_VALUE;
            return sum;
        }).min(Integer::compareTo).orElse(0);

    }

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get(("resources/input_min_fairness.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
