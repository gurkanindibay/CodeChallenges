package algorithms.search.test;

import algorithms.search.impl.InterpolationSearch;

import static org.junit.Assert.assertTrue;

class InterpolationSearchTest {

    InterpolationSearch interpolationSearch;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        interpolationSearch = new InterpolationSearch();
    }

    @org.junit.jupiter.api.Test
    void findNumberIndex() {
        int[] testArray = {12, 13, 15, 32, 45, 66};

        assertTrue(interpolationSearch.findNumberIndex(12, testArray) == 0);
        assertTrue(interpolationSearch.findNumberIndex(13, testArray) == 1);
        assertTrue(interpolationSearch.findNumberIndex(15, testArray) == 2);
        assertTrue(interpolationSearch.findNumberIndex(32, testArray) == 3);
        assertTrue(interpolationSearch.findNumberIndex(45, testArray) == 4);
        assertTrue(interpolationSearch.findNumberIndex(66, testArray) == 5);
    }
}
