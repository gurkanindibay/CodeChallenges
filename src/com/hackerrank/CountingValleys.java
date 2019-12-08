package com.hackerrank;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountingValleys {

    static int countingValleys(int n, String s) {
        char[] steps = s.toCharArray();

        int height = 0;
        int valleyCount = 0;
        for (char c : steps) {
            if (height == 0 && c == 'D') valleyCount += 1;
            if (c == 'U') height++;
            else if (c == 'D') height--;
        }
        return valleyCount;

    }

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "DDUUUUDD"));
    }
}
