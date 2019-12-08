package com.codility;

public class CyclicRotation {
    public int[] solution(int[] rotationArray, int rotationCount) {
        if (rotationArray == null || rotationArray.length == 0 || rotationArray.length == 1 || rotationCount == 0 || rotationArray.length % rotationCount == 0)
            return rotationArray;
        else {
            int modValue = rotationArray.length % rotationCount;
            int[] shiftedArray = new int[rotationArray.length];
            for (int i = 0; i < rotationArray.length; i++) {
                shiftedArray[i] = rotationArray[(i + modValue) % rotationArray.length];
            }

            return shiftedArray;
        }
    }
}
