package algorithms.search.impl;

public class BinarySearchOwn {


    public  int findNumberIndex(int requestedNumber, int[] array) {
        int lowerIndex = 0;
        int higherIndex = array.length;
        return findNumberIndex(requestedNumber,array,lowerIndex,higherIndex);
    }

    public  int findNumberIndex(int requestedNumber, int[] array, int lowerIndex, int higherIndex) {
        if (array == null) return -1;


        int paramIndex = (lowerIndex + higherIndex) / 2;

        if(array[paramIndex] != requestedNumber) {
            while (array[paramIndex] != requestedNumber) {

                if (array[paramIndex] == requestedNumber) return paramIndex;
                else if (array[paramIndex] > requestedNumber) {
                    higherIndex = paramIndex;
                } else {
                    lowerIndex = paramIndex + 1;
                }
                paramIndex = (lowerIndex + higherIndex) / 2;
                if (array[paramIndex] == requestedNumber) return paramIndex;
            }
        }else return paramIndex;
        return -1;
    }

}
