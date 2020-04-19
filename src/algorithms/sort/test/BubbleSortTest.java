package algorithms.sort.test;

import algorithms.sort.ISort;
import algorithms.sort.impl.BubbleSort;

class BubbleSortTest extends BaseSortTest {

    ISort sorter;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        sorter = new BubbleSort();
    }

    @org.junit.jupiter.api.Test
    void sort() {
        int[] testArray = getTestSet1();

        int[] array = sorter.sort(testArray);

        testConditionsForSet1(testArray);

    }

}
