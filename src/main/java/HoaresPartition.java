public class HoaresPartition {

    /**
     * Returns the final location of the pivot
     * @param array An array of int
     * @return Position of the pivot element.
     */
    public static int partition(int[] array) {
        return partition(array, 0, array.length - 1);
    }
    private static int partition(int[] array, int lower, int upper) {
        // Check if array is empty
        if (upper >= lower) {
            int middle = (lower + upper) / 2;
            int pivot = array[middle];
            // Swap the element at the middle with the left element.
            array[middle] = array[lower];
            array[lower] = pivot;

            int left = lower + 1;
            int right = upper;

            boolean finished = false;
            while (!finished) {
                while (left <= right && array[left] <= pivot)
                    left++;
                while (array[right] > pivot)
                    right--;

                // The first inner loop terminates either when left > right or array[left] > pivot
                // The second inner loop terminates when array[right] < pivot.
                if (left < right) {
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                }
                if (left > right)
                    finished = true;
            }
            array[lower] = array[right];
            array[right] = pivot;
            return right;
        }
        return -1;
    }

    // Returns the smallest kth element
    public static int quickSelect(int[] array, int k) {
        return quickSelect(array, 0, array.length - 1, k);
    }
    private static int quickSelect(int[] array, int lower, int upper, int k) {
        // Check if array is empty.
        if (lower > upper)
            throw new NullPointerException("Array is empty.");
        // Check the bounds of k.
        if (k < 0 || k > array.length)
            throw new ArrayIndexOutOfBoundsException("k is out of bounds");
        // Check if array is a single element array
        if (lower == upper)
            return array[lower];
        else {
            int pivotIndex = HoaresPartition.partition(array, lower, upper);
            if (pivotIndex == k - 1)
                return array[pivotIndex];
            else if (pivotIndex < k - 1)
                return quickSelect(array, pivotIndex + 1, upper, k);
            else
                return quickSelect(array, lower, pivotIndex - 1, k);
        }
    }
}
