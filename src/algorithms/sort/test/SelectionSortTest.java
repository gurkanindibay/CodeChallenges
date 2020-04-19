package algorithms.sort.test;

import algorithms.search.impl.BinarySearchOwn;
import algorithms.sort.ISort;
import algorithms.sort.impl.SelectionSort;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest extends BaseSortTest {

    ISort sorter;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        sorter = new SelectionSort();
    }

    @org.junit.jupiter.api.Test
    void sort() {
        int[] testArray = getTestSet1();

        int[] array = sorter.sort(testArray);

        testConditionsForSet1(testArray);
    }

}
