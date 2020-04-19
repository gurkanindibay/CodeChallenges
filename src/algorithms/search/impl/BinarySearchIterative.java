package algorithms.search.impl;

public class BinarySearchIterative {

    public  int findNumberIndex(int requestedNumber, int[] array) {
        int floorValue = 0, ceilValue = array.length-1;
        int counter = 0;
        while(floorValue <= ceilValue){
            counter++;
            System.out.println("Counter:"+counter);
            int median = (ceilValue+floorValue)/2;
            if(array[median] == requestedNumber){
                return median;
            }else if(array[median] > requestedNumber){
                ceilValue = median-1;
            }else{
                floorValue = median+1;
            }
        }

        return -1;

    }
}
