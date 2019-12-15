package com.hackerrank;

import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountTriplets {
    static long countTriplets2(List<Long> arr, long r) {


        Map<Long, List<Long>> map = new HashMap<>();
        long index = 0;
        long totalCount = 0L;
        for (long l : arr) {
            List<Long> indexList = map.getOrDefault(l, new ArrayList<>());
            indexList.add(index++);
            map.put(l, indexList);
        }
        for (long l : map.keySet()) {
            List<Long> indexList = map.get(l);
            if (r == 1) {
                long listSize = indexList.size();
                totalCount += listSize * (listSize - 1) * (listSize - 2) / 6;
                break;
            } else {
                List<Long> multiplyOnceIndex = map.get(l * r);
                List<Long> multiplyTwiceIndex = map.get(l * r * r);
                if (multiplyOnceIndex == null || multiplyTwiceIndex == null || multiplyOnceIndex.isEmpty() || multiplyTwiceIndex.isEmpty()) {
                    continue;
                } else {

                    for (long il : indexList) {
                        long twiceCount = 0;
                        for (long ol : multiplyOnceIndex.stream().filter(v -> v > il).collect(Collectors.toList())) {
                            twiceCount = multiplyTwiceIndex.stream().filter(v -> v > ol).count();
                            totalCount += twiceCount;
                            //if(twiceCount > 0) multiplyTwiceIndex.stream().filter(v -> v > ol).forEach(tl-> System.out.println(il   +" "+ ol+ " "+ tl ));
                        }
                    }
                }
            }
        }
        return totalCount;
    }

    static class ValueReferencesContainer {
        List<Long> valueList = new ArrayList<>();
        List<Long> squareReferenceList = new ArrayList<>();
        List<Long> power3ReferenceList = new ArrayList<>();


    }

    private static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            long a = arr.get(i);
            long key = a / r;

            if (counter.containsKey(key) && a % r == 0) {
                count += counter.get(key);
            }

            if (potential.containsKey(key) && a % r == 0) {
                long c = potential.get(key);
                counter.put(a, counter.getOrDefault(a, 0L) + c);
            }

            potential.put(a, potential.getOrDefault(a, 0L) + 1); // Every number can be the start of a triplet.
        }
        return count;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/input_count_triplets.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);
    }
}
