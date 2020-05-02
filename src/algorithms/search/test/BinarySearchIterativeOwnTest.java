package algorithms.search.test;

import algorithms.search.impl.BinarySearchIterativeOwn;
import algorithms.search.impl.BinarySearchRecursive;

import static org.junit.Assert.assertTrue;

class BinarySearchIterativeOwnTest {

    BinarySearchIterativeOwn binarySearchIterativeOwn;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        binarySearchIterativeOwn = new BinarySearchIterativeOwn();
    }

    @org.junit.jupiter.api.Test
    void findNumberIndex() {
        binarySearchIterativeOwn = new BinarySearchIterativeOwn();
        int[] testArray = {12,13,15,32,45,66};

        assertTrue(binarySearchIterativeOwn.findNumberIndex(12,testArray)==0);
        assertTrue(binarySearchIterativeOwn.findNumberIndex(13,testArray)==1);
        assertTrue(binarySearchIterativeOwn.findNumberIndex(15,testArray)==2);
        assertTrue(binarySearchIterativeOwn.findNumberIndex(32,testArray)==3);
        assertTrue(binarySearchIterativeOwn.findNumberIndex(45,testArray)==4);
        assertTrue(binarySearchIterativeOwn.findNumberIndex(66,testArray)==5);
        assertTrue(binarySearchIterativeOwn.findNumberIndex(41,testArray)==-1);
    }
}
