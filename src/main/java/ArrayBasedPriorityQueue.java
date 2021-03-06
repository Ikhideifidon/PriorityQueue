import java.util.Iterator;
import java.util.NoSuchElementException;

// Maximum Priority Queue
// Array-based Priority Queue (Unsorted)
// This Priority Queue does not permit the insertion of null
public class ArrayBasedPriorityQueue<E extends Object & Comparable<? super E>> implements PriorityQueue<E>, Iterable<E> {
    public static final int INITIAL_CAPACITY = 100;
    private E[] queue;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayBasedPriorityQueue(int capacity) {
        queue = (E[]) new Object[capacity];
    }

    public ArrayBasedPriorityQueue() {
        this(INITIAL_CAPACITY);
    }

    private E nullChecker(E data) {
        if (data == null)
            throw new ArrayStoreException();
        return data;
    }

    private void resize(int increasedCapacity) {
        if (size >= queue.length) {
            @SuppressWarnings("unchecked")
            E[] newQueue = (E[]) new Object[increasedCapacity];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Insertion is done at the end of the array.
    public void insert(E data) {
        if (size >= queue.length)
            resize(2 * queue.length);
        queue[size++] = nullChecker(data);
    }

    private int indexFinder() {
       if (isEmpty())
           throw new NoSuchElementException();
       int maxIndex = 0;
       for (int i = 1; i < size; i++) {
           if (queue[i].compareTo(queue[maxIndex]) > 0)
               maxIndex = i;
       }
       return maxIndex;
    }

    public E peek() {
       int index = indexFinder();
       return queue[index];
    }

    public E remove() {
        int index = indexFinder();
        E answer = queue[index];
        queue[index] = queue[--size];
        return answer;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                return size == 0;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                E answer = peek();
                return null;
            }
        };
    }
}
