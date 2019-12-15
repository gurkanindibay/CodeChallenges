package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoStrings {
    static String twoStrings(String s1, String s2) {
        Map<Character,Integer> s1Map = new HashMap<>();

        for(char c: s1.toCharArray()){
            s1Map.putIfAbsent(c,0);
        }

        for(char c: s2.toCharArray()){
            if(s1Map.get(c)!= null) return "YES";
        }
        return "NO";

    }

    private static  Scanner scanner = null;

    static {
        try {
            scanner = new Scanner(Paths.get("resources/input_two_strings.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
