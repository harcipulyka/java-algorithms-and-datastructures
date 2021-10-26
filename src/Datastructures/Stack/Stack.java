package Datastructures.Stack;

//Java doesn't support generic arrays, and using ArrayList would have defeated the purpose of this
public class Stack {
    private int top = -1; //index to the last pushed element
    private final int[] array;

    public Stack(int size){
        array = new int[size]; //Java doesn't support generic arrays, this is a workaround
    }

    public void push(int value){
        if(top + 1 == array.length) throw new IllegalArgumentException("Overflow error, stack is full!");
        top++;
        array[top] = value;
    }

    public int pop(){
        if (this.isEmpty()) throw new IllegalArgumentException("Underflow error, stack is empty!");
        top--;
        return array[top + 1];
    }

    public boolean isEmpty(){
        return top == -1;
    }

}
