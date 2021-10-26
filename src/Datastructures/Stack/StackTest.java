package Datastructures.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {
    Stack stack;

    @BeforeEach
    public void beforeEach(){
        this.stack = new Stack(20);
    }

    @Test
    public void simple1() {
        Assertions.assertTrue(this.stack.isEmpty());
    }

    @Test
    public void underflowTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.stack.pop());
    }

    @Test
    public void overflowTest(){
        for(int i = 0; i < 20; i++) this.stack.push(20);
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.stack.push(20));
    }

    @Test
    public void fillUpAndEmpty() {
        for (int i = 0; i < 20; i++) this.stack.push((int)Math.random() * Integer.MAX_VALUE);
        for (int i = 0; i < 20; i++) this.stack.pop();
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.stack.pop());
    }

    @Test
    public void valuesTest() {
        this.stack.push(12);
        this.stack.push(120);
        this.stack.push(1200);
        String output = "";
        output += this.stack.pop();
        output += this.stack.pop();
        output += this.stack.pop();
        Assertions.assertEquals("120012012", output);
    }

    @Test
    public void valuesTest2() {
        String output = "";
        this.stack.push(12);
        this.stack.push(120);
        this.stack.push(1200);
        output += this.stack.pop();
        output += this.stack.pop();
        this.stack.push(14513);
        this.stack.push(123);
        output += this.stack.pop();
        output += this.stack.pop();

        Assertions.assertEquals("120012012314513", output);
    }
}
