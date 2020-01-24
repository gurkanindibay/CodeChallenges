package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class CommonChild {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        Map<Character, List<Integer>> s1Map = createIndexMap(s1Chars);
        Map<Character, List<Integer>> s2Map = createIndexMap(s2Chars);
        //List<Character> commonCharList = new ArrayList<>();
        Map<Character, Integer> minCountMap = new HashMap<>();
        int maxWordLength = 0;
        List<Integer> s1IndexList = new ArrayList<>();
        List<Integer> s2IndexList = new ArrayList<>();
        for (Character c : s1Map.keySet()) {
            if (s2Map.keySet().contains(c)) {
                s1IndexList.addAll(s1Map.get(c));
                s2IndexList.addAll(s2Map.get(c));

                //commonCharList.add(c);
                minCountMap.put(c, Math.min(s1Map.get(c).size(), s2Map.get(c).size()));
                maxWordLength += minCountMap.get(c);
            }
        }

//
//        int s1TotalLetterCount = s1Map.values().stream().map(l->l.size()).reduce(0,Integer::sum);
//        int s2TotalLetterCount = s2Map.values().stream().map(l->l.size()).reduce(0,Integer::sum);

        Collections.sort(s1IndexList);
        Collections.sort(s2IndexList);
//        s1IndexList.forEach(i -> System.out.print(i));
        List<int[]> s1Combinations = getCombinations(maxWordLength, s1IndexList);

        List<int[]> s2Combinations = getCombinations(maxWordLength, s2IndexList);

//        s1Combinations.forEach(a -> {
//            Arrays.stream(a).forEach(i -> System.out.print(i));
//            System.out.println();
//        });

        List<String> s1StringVarieties = getStringVarities(s1, s1Combinations);
        List<String> s2StringVarieties = getStringVarities(s2, s2Combinations);

//        s1StringVarieties.forEach(s -> System.out.println(s));


        s1StringVarieties.retainAll(s2StringVarieties);
        return s1StringVarieties.stream().mapToInt(s -> s.length()).max().orElse(0);


    }

    private static List<int[]> getCombinations(int maxWordLength, List<Integer> s1IndexList) {
        List<int[]> s1Combinations = new ArrayList<>();
        for (int i = maxWordLength; i > 0; i--) {
            List<int[]> combinationIndexes = generate(s1IndexList.size(), i);
            List<int[]> actualIndexes = new ArrayList<>();
            combinationIndexes.forEach(ci -> {
                int[] array = new int[ci.length];
                for (int j = 0; j < ci.length; j++) {
                    array[j] = s1IndexList.get(ci[j]);
                }
                actualIndexes.add(array);
            });
            s1Combinations.addAll(actualIndexes);
        }
        return s1Combinations;
    }

    private static List<String> getStringVarities(String str, List<int[]> sCombinations) {
        List<String> sNStringVarieties = new ArrayList<>();
        for (int[] combination : sCombinations) {
            StringBuffer s = new StringBuffer();
            for (int i : combination)
                s.append(str.charAt(i));
            sNStringVarieties.add(s.toString());
        }
        return sNStringVarieties;
    }

    public static List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];

        // initialize with lowest lexicographic combination
        for (int i = 0; i < r; i++) {
            combination[i] = i;
        }

        while (combination[r - 1] < n) {
            combinations.add(combination.clone());

            // generate next combination in lexicographic order
            int t = r - 1;
            while (t != 0 && combination[t] == n - r + t) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < r; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }

        return combinations;
    }

    private static Map<Character, List<Integer>> createIndexMap(char[] s1Chars) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < s1Chars.length; i++) {
            List<Integer> list = indexMap.getOrDefault(s1Chars[i], new ArrayList<Integer>());
            list.add(i);
            indexMap.put(s1Chars[i], list);
        }
        return indexMap;
    }

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get(("resources/input_common_child.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
