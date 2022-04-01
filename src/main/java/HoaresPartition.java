public abstract class HoaresPartition {

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
        if (upper > lower) {
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
        else if (upper == lower)
            return lower;
        return -1;
    }

    // Returns the smallest kth element
    public static int findKthSmallest(int[] array, int k) {
        return findKthSmallest(array, 0, array.length - 1, k);
    }
    private static int findKthSmallest(int[] array, int lower, int upper, int k) {
        // Check if array is empty.
        if (lower > upper)
            throw new NullPointerException("Array is empty.");
        // Check the bounds of k.
        if (k <= 0 || k > array.length)
            throw new ArrayIndexOutOfBoundsException("k is out of bounds");
        // Check if array is a single element array
        if (lower == upper)
            return array[lower];
        else {
            int pivotIndex = HoaresPartition.partition(array, lower, upper);
            if (pivotIndex == k - 1)
                return array[pivotIndex];
            else if (pivotIndex < k - 1)
                return findKthSmallest(array, pivotIndex + 1, upper, k);
            else
                return findKthSmallest(array, lower, pivotIndex - 1, k);
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;

        if (k <= 0 || k > nums.length)
            throw new ArrayIndexOutOfBoundsException("k is out of bounds");

        k = nums.length - k;

        //While low is less than high keep partitioning, updating low and high to narrow in
        //on the location of k

        while (low < high){
            int pivotIndex = HoaresPartition.partition(nums, low, high);
            if (pivotIndex < k)
                low = pivotIndex + 1;
            else if (pivotIndex > k)
                high = pivotIndex - 1;
            else
                return nums[pivotIndex];
        }
        if (low == high)
            return nums[low];
        throw new NullPointerException("Array is empty");
    }
}
