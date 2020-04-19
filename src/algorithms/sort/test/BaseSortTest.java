package algorithms.sort.test;

import static org.junit.Assert.assertTrue;

public class BaseSortTest {

    public int[] getTestSet1(){
        return new int[] {15,12,17,9,56,45,76,88,75,15};
    }

    public void testConditionsForSet1( int[] array){

        assertTrue(array[0]==9);
        assertTrue(array[1]==12);
        assertTrue(array[2]==15);
        assertTrue(array[3]==15);
        assertTrue(array[4]==17);
        assertTrue(array[5]==45);
        assertTrue(array[6]==56);
        assertTrue(array[7]==75);
        assertTrue(array[8]==76);
        assertTrue(array[9]==88);
    }
}
