package Datastructures.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {
    Queue queue;

    @BeforeEach
    public void beforeEach(){
        this.queue = new Queue(10);
    }

    @Test
    public void isEmptyTest(){
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void overflowTest(){
        for (int i = 0; i < 10; i++) queue.enqueue(12);
        Assertions.assertThrows(IllegalArgumentException.class, () -> queue.enqueue(10));
    }

    @Test
    public void underflowTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> queue.dequeue());
    }

    @Test
    public void orderTest1() {
        String output = "";
        queue.enqueue(1);
        queue.enqueue(2);
        output += queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(4);
        output += queue.dequeue();
        output += queue.dequeue();
        output += queue.dequeue();
        Assertions.assertEquals("1234", output);
    }

    @Test
    public void orderTest2() {
        String output = "";
        queue.enqueue(1);
        queue.enqueue(2);
        output += queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(4);
        output += queue.dequeue();
        output += queue.dequeue();
        output += queue.dequeue();
        Assertions.assertThrows(IllegalArgumentException.class, () -> queue.dequeue());
    }
}
