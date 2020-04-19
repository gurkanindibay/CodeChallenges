package algorithms.search.impl;

public class SublistSearch {

    public static class Node {
        public int data;
        public Node next;

        public Node(){

        }
        public Node(int[] data){
            if(data.length > 0) this.data = data[0];
            Node mainNode=this;
            Node node=mainNode;
            for(int i=1;i < data.length;i++){
                node.next= new Node();
                node.next.data = data[i];
                node = node.next;
            }
        }
    }

    public  boolean findList(Node first, Node second) {
        Node secondBaseIterator = second;
        Node secondIterator = second;
        Node firstIterator = first;
        while (secondBaseIterator != null) {
            secondIterator = secondBaseIterator;
            while (firstIterator != null) {
                if (secondIterator.data != firstIterator.data) {
                    firstIterator = first;
                    break;
                } else {
                    firstIterator = firstIterator.next;
                    secondIterator = secondIterator.next;
                    if(firstIterator == null) return true;
                }

            }
            secondBaseIterator = secondBaseIterator.next;
        }
        return false;
    }

}
