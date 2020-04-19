package algorithms.search.test;

import algorithms.search.impl.BinarySearchOwn;

import static org.junit.Assert.assertTrue;

class BinarySearchOwnTest {

    BinarySearchOwn binarySearchOwn;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        binarySearchOwn = new BinarySearchOwn();
    }

    @org.junit.jupiter.api.Test
    void findNumberIndex() {
        binarySearchOwn = new BinarySearchOwn();
        int[] testArray = {12,13,15,32,45,66};

        assertTrue(binarySearchOwn.findNumberIndex(12,testArray)==0);
        assertTrue(binarySearchOwn.findNumberIndex(13,testArray)==1);
        assertTrue(binarySearchOwn.findNumberIndex(15,testArray)==2);
        assertTrue(binarySearchOwn.findNumberIndex(32,testArray)==3);
        assertTrue(binarySearchOwn.findNumberIndex(45,testArray)==4);
        assertTrue(binarySearchOwn.findNumberIndex(66,testArray)==5);
    }
}
