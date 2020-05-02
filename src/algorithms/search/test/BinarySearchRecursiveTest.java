package algorithms.search.test;

import algorithms.search.impl.BinarySearchOwn;
import algorithms.search.impl.BinarySearchRecursive;

import static org.junit.Assert.assertTrue;

class BinarySearchRecursiveTest {

    BinarySearchRecursive binarySearchRecursive;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        binarySearchRecursive = new BinarySearchRecursive();
    }

    @org.junit.jupiter.api.Test
    void findNumberIndex() {
        binarySearchRecursive = new BinarySearchRecursive();
        int[] testArray = {12,13,15,32,45,66};

        assertTrue(binarySearchRecursive.findNumberIndex(12,testArray)==0);
        assertTrue(binarySearchRecursive.findNumberIndex(13,testArray)==1);
        assertTrue(binarySearchRecursive.findNumberIndex(15,testArray)==2);
        assertTrue(binarySearchRecursive.findNumberIndex(32,testArray)==3);
        assertTrue(binarySearchRecursive.findNumberIndex(45,testArray)==4);
        assertTrue(binarySearchRecursive.findNumberIndex(66,testArray)==5);
        assertTrue(binarySearchRecursive.findNumberIndex(41,testArray)==-1);
    }
}
