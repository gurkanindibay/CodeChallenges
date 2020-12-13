package com.codility;

import java.util.*;

public class SwapLexOrder {

    public static void main(String[] args)
    {
        int[][] pairs = { { 13, 23 }, { 13, 28 }, { 15, 20 }, { 24, 29 }, { 6, 7 }, { 3, 4 }, { 21, 30 }, { 2, 13 }, { 12, 15 },
                { 19, 23 }, { 10, 19 }, { 13, 14 }, { 6, 16 }, { 17, 25 }, { 6, 21 }, { 17, 26 }, { 5, 6 }, { 12, 24 }

        };
        System.out.println(swapLexOrder("lvvyfrbhgiyexoirhunnuejzhesylojwbyatfkrv",pairs ));
    }

    static String swapLexOrder(String str, int[][] pairs) {
        Map<Integer, Set<Integer>> neighbours = new HashMap<>();
        for (int[] pair : pairs) {
            Set<Integer> l0 = neighbours.get(pair[0]);
            Set<Integer> l1 = neighbours.get(pair[1]);
            if (l0 == null) {
                l0 = l1 == null ? new TreeSet<>() : l1;
            } else if (l1 != null) {
                Set<Integer> fl0 = l0;
                l1.forEach(i -> neighbours.put(i, fl0));
                l0.addAll(l1);
            }
            l0.add(pair[0]);
            l0.add(pair[1]);
            neighbours.put(pair[0], l0);
            neighbours.put(pair[1], l0);
        }
        StringBuilder sb = new StringBuilder(str);
        for (Set<Integer> set : new HashSet<>(neighbours.values())) {
            System.out.println(set);
            Iterator<Character> c = set.stream().map(i -> str.charAt(i - 1)).sorted(Comparator.reverseOrder()).iterator();
            set.forEach(i -> sb.setCharAt(i - 1, c.next()));
        }

        System.out.println();
        return sb.toString();
    }

}
