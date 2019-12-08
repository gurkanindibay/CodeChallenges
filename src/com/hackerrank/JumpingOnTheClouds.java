package com.hackerrank;

public class JumpingOnTheClouds {
    static int jumpingOnClouds(int[] c) {
        if (c.length == 1) return 1;
        int currentIndex = 0;
        int stepCount = 0;
        while (currentIndex < c.length) {

            if (currentIndex + 2 < c.length && c[currentIndex + 2] == 0) {

                currentIndex += 2;
                System.out.println(currentIndex);
                stepCount++;
            } else if (currentIndex + 1 < c.length && c[currentIndex + 1] == 0) {
                currentIndex += 1;
                System.out.println(currentIndex);
                stepCount++;
            } else if (currentIndex + 1 == c.length) return stepCount;
            else return -1;
        }

        return stepCount;
    }

    public static void main(String[] args) {
        int[] c = {0, 0, 1, 0, 0, 0, 0, 0};
        System.out.println(jumpingOnClouds(c));
    }
}
