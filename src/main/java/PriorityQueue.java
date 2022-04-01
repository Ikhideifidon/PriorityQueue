/**
 * A minimum Priority Queue Interface that supports the main API for queue operations.
 * The implementation of this interface will be based on:
 *      1. Array (Sorted and Unsorted)
 *      2. Single LinkedList (Sorted and Unsorted)
 *      3. Heaps
 */
public interface PriorityQueue<E extends Object & Comparable<? super E>> extends Iterable<E> {

    /**
     * The number of elements in this data structure
     * @return the number of elements currently present in the underlying data structure.
     */
    int size();

    /**
     * Check if this data structure is empty or not.
     * @return true if empty; false otherwise.
     */
    boolean isEmpty();

    /**
     * Inserts an element to this data structure while preserving both the Heap relational
     * property and its structural property.
     * @param obj An element to be inserted.
     */
    void insert(E obj);

    /**
     * Remove and Return the element at the root if any; otherwise an appropriate Exception is thrown
     * @return An element present at the root is removed and returned. An Exception is thrown if
     * root is empty.
     */
    E remove();

    /**
     * Return without removing the element at the root if any; otherwise an appropriate Exception is thrown
     * @return An element present at the root is returned. An Exception is thrown if
     * root is empty.
     */
    E peek();
    

}
