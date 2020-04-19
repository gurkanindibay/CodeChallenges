package algorithms.search.test;

import algorithms.search.impl.SublistSearch;
import algorithms.search.impl.SublistSearch.Node;

import static org.junit.Assert.assertTrue;

class SublistSearchTest {

    @org.junit.jupiter.api.Test
    void findList() {
        Node secondNode = new Node(new int[]{1, 2, 3, 4, 8, 9, 11, 17,21,32,45});
        Node firstNode = new Node(new int[]{17,21,32});

        SublistSearch sublistSearch = new SublistSearch();
        assertTrue(sublistSearch.findList(firstNode, secondNode));
    }
}
