import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


/**
 * Minimum PriorityQueue Heap-Based Implementation
 * @param <E>
 */
public class HeapBasedPriorityQueue<E extends Object & Comparable<? super E>> implements PriorityQueue<E> {
    public static final int DEFAULT_CAPACITY = 16;
    private E[] data;                       // Initial array container
    private int t;                          // Number of elements in array.


    @SuppressWarnings("unchecked")
    public HeapBasedPriorityQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.t = 0;
    }

    public HeapBasedPriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public HeapBasedPriorityQueue(Collection<? extends E> collections) {
        this.data = (E[]) collections.toArray();
        this.t = collections.size();
    }

    private void ensureCapacity(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }

    private void checkIndices(int index1, int index2) {
        if ((index1 < 0 || index1 > t) || (index2 < 0 || index2 > t))
            throw new ArrayIndexOutOfBoundsException();
    }

    private void swap(int from, int to) {
        checkIndices(from, to);
        E temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }

    private void trickleUp(int position) {
        if (position == 0)
            return;
        @SuppressWarnings("IntegerDivisionInFloatingPointContext")
        int parent = (int) Math.floor((position - 1) / 2);
        if (data[position].compareTo(data[parent]) < 0) {
            swap(position, parent);
            trickleUp(parent);
        }
    }

    private void trickleDown(int parent) {
        int leftChild = 2 * parent + 1;
        int rightChild = 2 * parent + 2;

        if (leftChild == t - 1 && data[parent].compareTo(data[leftChild]) > 0) {
            swap(parent, leftChild);
            return;
        }

        if (rightChild == t - 1 && data[parent].compareTo(data[rightChild]) > 0) {
            swap(parent, rightChild);
            return;
        }

        if (leftChild >= t - 1 || rightChild >= t - 1)
            return;

        if (data[leftChild].compareTo(data[rightChild]) > 0 && data[parent].compareTo(data[rightChild]) > 0) {
            swap(parent, rightChild);
            trickleDown(rightChild);
        } else if (data[leftChild].compareTo(data[rightChild]) < 0 && data[parent].compareTo(data[leftChild]) > 0) {
            swap(parent, leftChild);
            trickleDown(leftChild);
        }
    }

    @Override
    public int size() {
        return t;
    }

    @Override
    public boolean isEmpty() {
        return t == 0;
    }

    @Override
    public void insert(E obj) {
        if (t >= data.length)
            ensureCapacity(2 * data.length);
        data[t] = obj;
        trickleUp(t++);

    }

    @Override
    public E remove() {
        if (isEmpty())
            throw new ArrayStoreException();        
        E answer = data[0];
        swap(0, --t);
        trickleDown(0);
        return answer;
    }

    @Override
    public E peek() {
        f (isEmpty())
            throw new ArrayStoreException(); 
        return data[0];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }
}
