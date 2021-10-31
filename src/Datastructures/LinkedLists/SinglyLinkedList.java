package Datastructures.LinkedLists;

public class SinglyLinkedList <T extends Comparable>{
    private class Node<T>{
        public Node next;
        public T val;

        private Node(T val) {
            this.val = val;
        }

        private Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;

    public void insert(T val) {
        head = new Node(val, head);
    }

    public void remove(T val){
        if (head == null) return; //edge case, empty list

        //edge case, head is the node to be deleted
        if (head.val.equals(val)) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.val.equals(val)) temp = temp.next;
        if (temp.next == null) return;
        if (temp.next.next == null) temp.next = null;
        else temp.next = temp.next.next;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return null;
        StringBuilder b = new StringBuilder();
        Node temp = head;
        while (temp != null){
            b.append(temp.val + ", ");
            temp = temp.next;
        }
        b.delete(b.length()-2, b.length());
        return b.toString();
    }

    public boolean isEmpty(){return head==null;}
}
