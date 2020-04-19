package algorithms.search.test;

import algorithms.search.impl.BinarySearchIterative;

import static org.junit.Assert.assertTrue;

class BinarySearchIterativeTest {

    BinarySearchIterative binarySearchIterative;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        binarySearchIterative = new BinarySearchIterative();
    }

    @org.junit.jupiter.api.Test
    void findNumberIndex() {
        int[] testArray = {12,13,15,32,45,66,88,99,132};

        assertTrue(binarySearchIterative.findNumberIndex(12,testArray)==0);
        assertTrue(binarySearchIterative.findNumberIndex(13,testArray)==1);
        assertTrue(binarySearchIterative.findNumberIndex(15,testArray)==2);
        assertTrue(binarySearchIterative.findNumberIndex(32,testArray)==3);
        assertTrue(binarySearchIterative.findNumberIndex(45,testArray)==4);
        assertTrue(binarySearchIterative.findNumberIndex(66,testArray)==5);
        assertTrue(binarySearchIterative.findNumberIndex(88,testArray)==6);
        assertTrue(binarySearchIterative.findNumberIndex(99,testArray)==7);
        assertTrue(binarySearchIterative.findNumberIndex(132,testArray)==8);
    }
}
