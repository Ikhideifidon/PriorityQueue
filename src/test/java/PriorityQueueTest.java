import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriorityQueueTest {

    PriorityQueue<Integer> priorityQueue;

    @BeforeEach
    void setUp() {
        priorityQueue = new HeapBasedPriorityQueue<>();
        int[] nums = {8, 15, 17, 19, 22, 7, 11, 5, 10, 6, 9, 12};
        for (int data : nums)
            priorityQueue.insert(data);
    }

    @Test
    void size() {
        System.out.println(priorityQueue.size());
    }

    @Test
    void isEmpty() {
    }

    @Test
    void insert() {
    }

    @Test
    void remove() {
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
    }

    @Test
    void peek() {
        System.out.println(priorityQueue.peek());
    }
}