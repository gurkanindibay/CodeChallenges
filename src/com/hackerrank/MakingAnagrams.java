package com.hackerrank;

import java.io.*;
import java.math.*;
import java.nio.file.Paths;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        int[] aCount = new int[26];
        int[] bCount = new int[26];

        for (int i = 0; i < aChar.length; i++) {
            aCount[aChar[i] - 97]++;
        }

        for (int i = 0; i < bChar.length; i++) {
            bCount[bChar[i] - 97]++;
        }

        int diffCount = 0;

        for (int i = 0; i < 26; i++) {
            diffCount += Math.abs(aCount[i]-bCount[i]);
        }

        return diffCount;

    }

    private static Scanner scanner;
    static {
        try {
            scanner = new Scanner(Paths.get(("resources/input_string_anagram.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
