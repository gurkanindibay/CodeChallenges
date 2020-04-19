package algorithms.search.test;

import algorithms.search.impl.ExponentialSearch;

import static org.junit.Assert.assertTrue;

class ExponentialSearchTest {

    ExponentialSearch exponentialSearch;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        exponentialSearch = new ExponentialSearch();
    }

    @org.junit.jupiter.api.Test
    void findNumberIndex() {
        int[] testArray = {12,13,15,32,45,66};

        assertTrue(exponentialSearch.findNumberIndex(12,testArray)==0);
        assertTrue(exponentialSearch.findNumberIndex(13,testArray)==1);
        assertTrue(exponentialSearch.findNumberIndex(15,testArray)==2);
        assertTrue(exponentialSearch.findNumberIndex(32,testArray)==3);
        assertTrue(exponentialSearch.findNumberIndex(45,testArray)==4);
        assertTrue(exponentialSearch.findNumberIndex(66,testArray)==5);
    }
}
