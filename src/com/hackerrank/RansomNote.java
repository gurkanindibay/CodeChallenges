package com.hackerrank;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {

    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazineMap = new HashMap<>();

        for (String s : magazine) {
            magazineMap.put(s, (magazineMap.get(s) == null ? 0 : magazineMap.get(s)) + 1);
        }

        for (String s : note) {
            Integer wordCount = null;
            if ((wordCount = magazineMap.get(s)) == null || wordCount.intValue() == 0) {
                System.out.println("No");
                return;
            } else {
                magazineMap.put(s, wordCount - 1);
            }

        }
        System.out.println("Yes");


    }

    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner(Paths.get("resources/input_ransom_note_no.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }

}
