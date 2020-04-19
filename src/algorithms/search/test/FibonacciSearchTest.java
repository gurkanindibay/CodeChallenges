package algorithms.search.test;

import algorithms.search.impl.FibonacciSearch;

import static org.junit.Assert.assertTrue;

class FibonacciSearchTest {
    FibonacciSearch fibonacciSearch;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        fibonacciSearch = new FibonacciSearch();
    }

    @org.junit.jupiter.api.Test
    void findNumberIndex() {
        int[] testArray = {12,13,15,32,45,66};

        assertTrue(fibonacciSearch.findNumberIndex(12,testArray)==0);
        assertTrue(fibonacciSearch.findNumberIndex(13,testArray)==1);
        assertTrue(fibonacciSearch.findNumberIndex(15,testArray)==2);
        assertTrue(fibonacciSearch.findNumberIndex(32,testArray)==3);
        assertTrue(fibonacciSearch.findNumberIndex(45,testArray)==4);
        assertTrue(fibonacciSearch.findNumberIndex(66,testArray)==5);
    }
}
