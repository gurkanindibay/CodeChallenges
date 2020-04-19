package algorithms.sort.test;

import algorithms.sort.ISort;
import algorithms.sort.impl.InsertionSort;

import static org.junit.Assert.assertTrue;

class InsertionSortTest extends BaseSortTest {
    ISort sorter;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        sorter = new InsertionSort();
    }

    @org.junit.jupiter.api.Test
    void sort() {
        int[] testArray = getTestSet1();

        int[] array = sorter.sort(testArray);

       testConditionsForSet1(testArray);

    }
}
