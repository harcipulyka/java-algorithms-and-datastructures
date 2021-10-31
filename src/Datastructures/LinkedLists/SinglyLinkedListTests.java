package Datastructures.LinkedLists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTests {
    SinglyLinkedList<Integer> sll;

    @BeforeEach
    public void beforeEach(){
        this.sll = new SinglyLinkedList();
    }

    @Test
    public void isEmptyTest(){
        Assertions.assertTrue(sll.isEmpty());
    }

    @Test
    public void insertTests(){
        for (int i = 0; i < 1000; i++) {
            sll.insert(i);
        }
        Assertions.assertTrue(true);
    }

    @Test
    public void removeTest(){
        for (int i = 0; i < 1000; i++) {
            sll.insert(i);
        }
        for (int i = 0; i < 1000; i++) {
            sll.remove(i);
        }
        Assertions.assertTrue(sll.isEmpty());
    }

    @Test
    public void removeStressTest() {
        sll.insert(1);
        sll.remove(1);
        sll.remove(1);
        sll.remove(1);
        sll.insert(1);
        sll.insert(1);
        sll.remove(1);
        sll.remove(1);
        Assertions.assertTrue(sll.isEmpty());
    }
}
