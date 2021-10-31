package Datastructures.LinkedLists;

public class DoublyLinkedList <T>{
    private class Node<T>{
        public Node prev;
        public Node next;
        public T val;

        private Node(T val) {
            this.val = val;
        }

        private Node(T val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head;
}
