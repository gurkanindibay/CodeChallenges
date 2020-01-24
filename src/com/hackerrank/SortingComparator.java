package com.hackerrank;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player {
    public String name;
    public Integer score;

    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        if (b.score > a.score) {
            return 1;
        } else if (b.score < a.score) {
            return -1;
        } else if (a.score == b.score) {
            return a.name.compareTo(b.name);
        }
        else{
            throw new RuntimeException("Error case");
        }
    }
}


public class SortingComparator {

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get(("resources/input_sorting_comparator.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scanner.next(), scanner.nextInt());
        }
        scanner.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
