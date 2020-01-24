package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class SherlockValidString {
    // Complete the isValid function below.
    static String isValid(String s) {
        int[] charFrequencies = new int[26];
        char[] charsInString = s.toCharArray();

        for (int i = 0; i < charsInString.length; i++) {
            charFrequencies[charsInString[i] - 97]++;
        }

        int diffCount = 0;
        Map<Integer, Integer> diffMap = new HashMap<>();


        for (int i = 1; i < charFrequencies.length; i++) {
            diffMap.put(charFrequencies[i-1], diffMap.getOrDefault(charFrequencies[i-1], 0) + 1);
            int charDiffCount = charFrequencies[i] - charFrequencies[i - 1];
            if (charDiffCount > 1) return "NO";
            if (charDiffCount == 1) {
                diffCount++;
                if (diffCount > 1) return "NO";
            }
        }

        diffMap.remove(0);
        if (diffMap.keySet().size() > 2) return "NO";
        else if (diffMap.keySet().size() == 2) {
            Iterator<Integer> iterator = diffMap.keySet().iterator();
            int countKey1 = iterator.next();
            int countKey2 = iterator.next();
            if (countKey1 == 1 && diffMap.get(countKey1) == 1 || countKey2 == 1 && diffMap.get(countKey2) == 1) return "YES";
            else if (Math.abs(countKey1 - countKey2) > 1) return "NO";
            else if (countKey1 - countKey2 == 1 && diffMap.get(countKey1) > 1) return "NO";
            else if (countKey2 - countKey1 == 1 && diffMap.get(countKey2) > 1) return "NO";
            else return "YES";
        } else {
            return "YES";
        }

    }

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get(("resources/input_sherlock_valid.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
