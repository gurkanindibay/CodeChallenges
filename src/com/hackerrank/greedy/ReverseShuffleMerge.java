package com.hackerrank.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 *
 * Evaluation
 * I could not complete the challenge by myself. I looked at discussions to find answers. Even in that case I could not implement it correctly.
 * I found a Java solution and completed it using this soluyion
 * I didn't use buffers to form the string. It was a difficult question. I couldn't form the algorithm
 */

public class ReverseShuffleMerge {

    static String reverseShuffleMerge(String s) {
        int a = 'a';
        int z = 'z';

        int[] frequency = new int[z - a + 1];
        int[] buffer = new int[s.length()];
        int top = -1;

        s.chars().forEach(c -> frequency[c - a]++);

        int[] reference = Arrays.stream(frequency).map(v->v/2).toArray();

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentChar = s.charAt(i)-a;

            frequency[currentChar]--;
            if(reference[currentChar]< 1 ) continue;
            reference[currentChar]--;
            while(top >=0 && buffer[top] > currentChar && frequency[buffer[top]] > reference[buffer[top]]){
                reference[buffer[top--]]++;
            }
            buffer[++top] = currentChar;
        }
        return IntStream.rangeClosed(0,top).mapToObj(v->Character.toString((char)(buffer[v]+a))).collect(Collectors.joining(""));
    }


    // where n = the length of string s
    static String reverseShuffleMerge1(String s) {
        int a = 'a';
        int m = 'z' - a + 1;
        int[] frequency = new int[m];
        s.chars().forEach(c -> frequency[c - a]++);
        int[] count = Arrays.stream(frequency).map(f -> f / 2).toArray();

        int top = -1;
        int[] stack = new int[s.length()];
        for (int n = s.length(); --n >= 0; ) {
            int c = s.charAt(n) - a;
            frequency[c]--;
            if (count[c] < 1) continue;

            count[c]--;
            while (top >= 0 &&
                    stack[top] > c &&
                    frequency[stack[top]] > count[stack[top]]) {
                count[stack[top--]]++; // Increment and then pop the stack
            }
            stack[++top] = c; // Push c on to the stack
        }

        return java.util.stream.IntStream.rangeClosed(0, top)
                .mapToObj(c -> Character.toString((char) (stack[c] + a)))
                .collect(java.util.stream.Collectors.joining(""));
    }


    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get(("resources/input_reverse_shuffle_merge.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String s = scanner.nextLine();

        String result = reverseShuffleMerge(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
