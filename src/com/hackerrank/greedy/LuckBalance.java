package com.hackerrank.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LuckBalance {
    // Complete the luckBalance function below.

    //Evaluation
    //Can not completed on the first attempt even if the problem is easy. If I had understood the problem completely, I would hav solved the question easily
    //Also not knowing the comparator interface usage slowed me down.

    static int luckBalance(int k, int[][] contests) {
        int luckBalance = 0;

        int lostContestIndex = 0;
        Arrays.sort(contests, new SortByLuckpoint().reversed());
        for (int i = 0; i < contests.length; i++) {
            luckBalance = (contests[i][1] == 0 || lostContestIndex < k) ? luckBalance + contests[i][0] : luckBalance - contests[i][0];
            lostContestIndex++;
        }

        return luckBalance;
    }

    static class SortByLuckpoint implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0]*o1[1] - o2[0]*o2[1];
        }
    }

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get(("resources/input_luck_balance.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
