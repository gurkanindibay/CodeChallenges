package com.hackerrank.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GreedyFlorist {
    // Evaluation I understood the problem and implemented the method in the first attempt however I implemented the code slow because of lack of knowledge on
    //collections streaming API and sorting. My first attempt on code execution failed because of wrong sort of the list.
    static int getMinimumCost(int k, int[] costs) {

        if (k == 0) return 0;
        int minimumCost;
        Stream<Integer> costList = Arrays.stream(costs)
                .boxed().sorted(Collections.reverseOrder());

        if (k > costs.length) {
            minimumCost = costList.reduce(0, Integer::sum);
            minimumCost += costList.mapToInt(v -> v).min().orElse(0) * (costs.length - k);
        } else {
            AtomicInteger i = new AtomicInteger();
            minimumCost = costList.mapToInt(v -> (int) (v * Math.ceil(((double) (i.incrementAndGet())) / k))).sum();
        }
        return minimumCost;
    }

    static int getMinimumCostWithForLoop(int k, int[] costs) {

        if(k==0) return 0;
        int minimumCost = 0;
        List<Integer> costList = Arrays.stream(costs)
                .boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        if (k > costs.length) {
            minimumCost = costList.stream().reduce(0, Integer::sum);
            minimumCost += costList.stream().mapToInt(v -> v).min().orElse(0) * (costs.length - k);
        } else {
            for (int i = 0; i < costList.size(); i++) {
                minimumCost+=costList.get(i)*Math.ceil(((double)(i+1))/k);
            }
        }
        return minimumCost;
    }

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get(("resources/input_greedy_florist.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
