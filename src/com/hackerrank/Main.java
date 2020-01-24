package com.hackerrank;

import java.util.Arrays;

public class Main
{
    public static void main(String args[])
    {
        // initializing an array original
        int[] org = new int[] {1, 2 ,3,4,5};

        System.out.println("Original Array");
        for (int i = 0; i < org.length; i++)
            System.out.print(org[i] + " ");

        // copying array org to copy
        int[] copy = Arrays.copyOf(org, 3);

        // Changing some elements of copy

        System.out.println("\nNew array copy after modifications:");
        for (int i = 0; i < copy.length; i++)
            System.out.print(copy[i] + " ");
    }
}
