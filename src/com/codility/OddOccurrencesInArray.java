package com.codility;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

    public int solution(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) return -1;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (!countMap.keySet().contains(inputArray[i])) countMap.put(inputArray[i], 1);
            else {
                int value = countMap.get(inputArray[i]);
                countMap.put(inputArray[i], value + 1);
            }
        }


        int oddValue = -1;


        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer value = entry.getKey();
            Integer count = entry.getValue();
            if (count % 2 != 0) {
                oddValue = value;
                break;
            }
        }


        return oddValue;
    }
}
