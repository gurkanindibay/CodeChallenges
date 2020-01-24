package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAnagrams {
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        Map<String, Integer> anagrams = new HashMap<>();
        Map<String, Integer> combinations = new HashMap<>();
        int anagramCount = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                String partialString = s.substring(j, i + 1);
                String anagramicIndex = anagramCheckCount(partialString);
                int combinationCount = combinations.getOrDefault(anagramicIndex, 0);
                if (combinationCount > 0 ) anagramCount += combinationCount;
                combinations.put(anagramicIndex, combinationCount + 1);
            }
        }

        return anagramCount;
    }

    private static String anagramCheckCount(String s){
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get(("resources/input_count_triplets.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
