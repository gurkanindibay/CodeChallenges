package com.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> resultList = new ArrayList<>();

        Map<Integer, Long> valueMap = new HashMap<>();
        Map<Long, Long> countMap = new HashMap<>();
        for (int[] q : queries) {
            int operation = q[0];
            int value = q[1];

            if (operation == 1) {
                long valueCount = valueMap.getOrDefault(value, 0L);
                long countOfCount = countMap.getOrDefault(valueCount, 0L);
                if (countOfCount > 0) countMap.put(valueCount, --countOfCount);
                countMap.put(valueCount + 1, countMap.getOrDefault(valueCount + 1, 0L) + 1);
                valueMap.put(value, ++valueCount);
            } else if (operation == 2) {
                long valueCount = valueMap.getOrDefault(value, 0L);
                long countOfCount = countMap.getOrDefault(valueCount, 0L);
                if (countOfCount > 0) countMap.put(valueCount, --countOfCount);
                if (valueCount > 0) {
                    countMap.put(valueCount - 1, countMap.getOrDefault(valueCount - 1, 0L) + 1);
                    valueMap.put(value, --valueCount);
                }
            } else if (operation == 3) {
                resultList.add(countMap.getOrDefault(new Long(value), 0L) > 0L ? 1 : 0);
            }
        }
        return resultList;

    }


    static List<Integer> freqQuery2(List<int[]> queries) {
        List<Integer> resultList = new ArrayList<>();
        List<Long> keyList = new ArrayList<>();
        List<Long> valueList = new ArrayList<>();
        List<Integer> commandList = new ArrayList<>();
        Map<Integer, Long> valueMap = new HashMap<>();
        Map<Long, Long> countMap = new HashMap<>();
        int commandIndex = 1;
        for (int[] q : queries) {
            int operation = q[0];
            int value = q[1];

            if (operation == 1) {
                long valueCount = valueMap.getOrDefault(value, 0L);
                long countOfCount = countMap.getOrDefault(valueCount, 0L);
                if (countOfCount > 0) countMap.put(valueCount, --countOfCount);
                countMap.put(valueCount + 1, countMap.getOrDefault(valueCount + 1, 0L) + 1);
                valueMap.put(value, ++valueCount);
            } else if (operation == 2) {
                long valueCount = valueMap.getOrDefault(value, 0L);
                long countOfCount = countMap.getOrDefault(valueCount, 0L);
                if (countOfCount > 0) countMap.put(valueCount, --countOfCount);
                if (valueCount > 0) {
                    countMap.put(valueCount - 1, countMap.getOrDefault(valueCount - 1, 0L) + 1);
                    valueMap.put(value, --valueCount);
                }
            } else if (operation == 3) {
                resultList.add(countMap.getOrDefault(new Long(value), 0L) > 0L ? 1 : 0);
                keyList.add(new Long(value));
                valueList.add(countMap.getOrDefault(new Long(value), 0L));
                commandList.add(commandIndex);
            }
            commandIndex++;
        }


        for (int i = 0; i < keyList.size(); i++) {
            if (i == 3720) {
                System.out.println(keyList.get(i) + " " + valueList.get(i) + " " + commandList.get(i));
                for (long l : countMap.keySet()) System.out.println(l + " " + countMap.get(l));
            }

        }
        return resultList;

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/input_frequency.txt"))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            List<int[]> queries = new ArrayList<>(q);
            Pattern p = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
            for (int i = 0; i < q; i++) {
                int[] query = new int[2];
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    query[0] = Integer.parseInt(m.group(1));
                    query[1] = Integer.parseInt(m.group(2));
                    queries.add(query);
                }
            }
            List<Integer> ans = freqQuery(queries);
            //ans.forEach(v-> System.out.println(v+" "));
        }

    }
}
