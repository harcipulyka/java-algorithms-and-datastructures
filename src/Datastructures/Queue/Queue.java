package Datastructures.Queue;

public class Queue {
    private int tail = 0; //points to the next location at which the new element will be inserted
    private final int[] array;

    public Queue(int size){
        this.array = new int[size];
    }

    public void enqueue(int value){
        if(tail == array.length) throw new IllegalArgumentException("Overflow error, not enough space!");
        array[tail] = value;
        tail++;
    }

    public int dequeue(){
        if (isEmpty()) throw new IllegalArgumentException("Underflow error, queue is empty!");
        int temp = array[0];
        //shifting every element one to the direction of the head
        for (int i = 0; i < tail - 1; i++) {
            array[i] = array[i+1];
        }
        tail--;
        return temp;
    }

    public boolean isEmpty() {
        return tail==0;
    }
}
