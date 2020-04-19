package algorithms.sort.test;

import algorithms.sort.ISort;
import algorithms.sort.impl.BubbleSort;
import algorithms.sort.impl.MergeSort;

import static org.junit.Assert.assertTrue;

class MergeSortTest extends BaseSortTest {

    ISort sorter;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        sorter = new MergeSort();
    }

    @org.junit.jupiter.api.Test
    void sort() {
        int[] testArray = getTestSet1();

        int[] array = sorter.sort(testArray);

        testConditionsForSet1(testArray);

    }

}
