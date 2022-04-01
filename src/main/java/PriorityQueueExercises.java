import java.util.*;
import java.util.PriorityQueue;


// Top K Frequent Elements Using Priority Queue.
public abstract class PriorityQueueExercises {

    public static int[] topKFrequentPriorityQueue(int[] nums, int k) {
        Map<Integer, Integer>  table = new HashMap<>();
        for (int data : nums)
            table.put(data, table.getOrDefault(data, 0) + 1);

        // Natural ordering
        // Make entry with less frequency the top element.
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k+1, Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Integer> data : table.entrySet()) {
            queue.add(data);
            if (queue.size() > k)
                // Remove entry with a lesser frequency
                queue.poll();
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = queue.remove().getKey();
        return result;

    }

    public static int[] topKFrequentBucketSort(int[] nums, int k) {
        // Create a frequency based map
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int maximumFrequency = 0;
        for (int data : nums) {
            map.put(data, map.getOrDefault(data, 0) + 1);
            maximumFrequency = Math.max(maximumFrequency, map.get(data));
        }
        // Create an array of List called bucket
        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = new List[maximumFrequency + 1];

        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();

            bucket[frequency].add(key);
        }

        int[] result = new int[k];
        int resultIndex = 0;
        for (int position = bucket.length - 1; position >= 0 ; position--) {
            if (bucket[position] != null) {
                for (int bucketIndex = 0; bucketIndex < bucket[position].size(); bucketIndex++) {
                    if (resultIndex < k) {
                        result[resultIndex] = bucket[position].get(bucketIndex);
                        resultIndex++;
                    } else break;
                }
            }
        }
        return result;

    }

    public static String frequencySort(String string) {
        // Create a frequency map
        Map<Character, Integer> map = new HashMap<>();
        int maximumFrequency = 0;
        for (char letter : string.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
            maximumFrequency = Math.max(maximumFrequency, map.get(letter));
        }

        // Create a bucket of List of array
        @SuppressWarnings("unchecked")
        List<Character>[] bucket = new List[maximumFrequency + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int position = bucket.length - 1; position >= 0; position--) {
            if (bucket[position] != null) {
                for (char c : bucket[position]) {
                    stringBuilder.append(String.valueOf(c).repeat(position));
                }
            }
        }
        return stringBuilder.toString();
    }

    // Sort Array by Increasing Frequency
    public static int[] frequencySort(int[] nums) {
        // Create a frequency Map
        Map<Integer, Integer> map = new HashMap<>();
        for (int data : nums)
            map.put(data, map.getOrDefault(data, 0) + 1);

        //  If multiple values have the same frequency, sort them in decreasing order.
        Comparator<Map.Entry<Integer, Integer>> comp = (o1, o2) -> o1.getValue() > o2.getValue() ? 1 : o1.getValue() < o2.getValue() ? -1 : o2.getKey().compareTo(o1.getKey());

        // Construct an ArrayList  of Map.Entry Collection.
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        // list: [1=3, 3=2, 5=3, 7=2, 8=2, 13=1]

        list.sort(comp);

        int[] result = new int[nums.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            int count = entry.getValue();
            int key = entry.getKey();

            for (int i = 0; i < count; i++)
                result[index++] = key;
        }
        return result;
    }

    public static int[] maxSubstring(int[] nums, int k) {
        int
                low = 0,
                high = 0,
                left = 0,
                right = 0,
                sum = 0,
                maxSoFar = 0;
        while (high < nums.length) {
            sum += nums[high];
            if (high - low == k - 1) {
                if (maxSoFar < sum) {
                    left = low;
                    right = high;
                    maxSoFar = sum;
                    sum -= nums[low++];
                }
            }
            high++;
        }
        return Arrays.copyOfRange(nums, left, right + 1);
    }

//    public static int[] maxSubsequence(int[] nums, int k) {
//        int[][] twoDimensionNums = new int[nums.length][2];
//        int index = 0;
//        while (index < nums.length) {
//            twoDimensionNums[index] = new int[]{nums[index], index};
//            index++;
//        }
//
//        Comparator<int[]> comp = Comparator.comparingInt(o -> o[0]);
//
//        // Minimum PriorityQueue
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k, comp);
//        for (int[] list : twoDimensionNums) {
//            priorityQueue.offer(list);
//            if (priorityQueue.size() > k)
//                priorityQueue.poll();
//        }
//        int[] result = new int[k];
//        int resultIndex = 0;
//        while (!priorityQueue.isEmpty()) {
//            int[] sublist = priorityQueue.poll();
//            result[sublist[1]] =
//
//        }
//
//
//    }

    public static int[][] kClosest(int[][] points, int k) {
        // Build a Maximum Heap PriorityQueue
        Comparator<int[]> comp = (list1, list2) -> Integer.compare(list2[0] * list2[0] + list2[1] * list2[1], list1[0] * list1[0] + list1[1] * list1[1]);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k+1, comp);
        for (int[] list : points) {
            priorityQueue.offer(list);
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }

        int[][] result = new int[k][2];
        int index = 0;
        while(!priorityQueue.isEmpty())
            result[index++] = priorityQueue.poll();
        return result;
    }

    public int[][] kClosestUsingArraySort(int[][] points, int K) {
        Comparator<int[]> comp = (list1, list2) -> Integer.compare(list2[0] * list2[0] + list2[1] * list2[1], list1[0] * list1[0] + list1[1] * list1[1]);
        Arrays.sort(points, comp);
        return Arrays.copyOfRange(points, 0, K);
    }


    // K Closest Points to Origin
    public static int[][] kNearestToOrigin(int[][] points, int k) {
        return quickSelection(points, k);
    }

    public static int squareDistance (int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    // Hoares' Partition on a 2D array.
    public static int partitionHoares(int[][] nums, int lower, int upper) {
        if (lower <= upper) {
            int middle = (lower + upper) / 2;
            int[] pivot = nums[middle];
            nums[middle] = nums[lower];
            nums[lower] = pivot;
            int pivotalDistance = squareDistance(pivot);

            int left = lower + 1;
            int right = upper;

            boolean finished = false;
            while (!finished) {

                while (left <= right && squareDistance(nums[left]) <= pivotalDistance)
                    left++;

                while (squareDistance(nums[right]) > pivotalDistance)
                    right--;

                if (left < right) {
                    int[] temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }

                finished = left > right;
            }
            nums[lower] = nums[right];
            nums[right] = pivot;
            return right;
        }
        return -1;
    }

    public static int[][] quickSelection(int[][] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int pivotIndex;

        while (left <= right) {
            pivotIndex = partitionHoares(nums, left, right);

            if (pivotIndex > k)
                right = pivotIndex - 1;
            else if (pivotIndex < k)
                left = pivotIndex + 1;
            else break;
        }
        return Arrays.copyOf(nums, k);
    }

    // Kth Smallest elements;
    public static int partitionHoaresForKthSmallestElements(int[] nums, int lower, int upper) {
        if (lower <= upper) {
            int middle = (lower + upper) / 2;
            int pivot = nums[middle];
            nums[middle] = nums[lower];
            nums[lower] = pivot;

            int left = lower + 1;
            int right = upper;

            boolean finished = false;
            while (!finished) {

                while (left <= right && nums[left] <= pivot)
                    left++;

                while (nums[right] > pivot)
                    right--;

                if (left < right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }

                finished = left > right;
            }
            nums[lower] = nums[right];
            nums[right] = pivot;
            return right;
        }
        return -1;
    }

    public static int[] quickSelectionForKthSmallestElements(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int pivotIndex;

        while (left <= right) {
            pivotIndex = partitionHoaresForKthSmallestElements(nums, left, right);

            if (pivotIndex > k)
                right = pivotIndex - 1;
            else if (pivotIndex < k)
                left = pivotIndex + 1;
            else break;
        }
        return Arrays.copyOf(nums, k);
    }

    // Kth Largest Elements
    public static int partitionHoaresForKthLargestElements(int[] nums, int lower, int upper) {
        if (lower <= upper) {
            int middle = (lower + upper) / 2;
            int pivot = nums[middle];
            nums[middle] = nums[lower];
            nums[lower] = pivot;

            int left = lower + 1;
            int right = upper;

            boolean finished = false;
            while (!finished) {

                while (left <= right && nums[left] <= pivot)
                    left++;

                while (nums[right] > pivot)
                    right--;

                if (left < right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }

                finished = left > right;
            }
            nums[lower] = nums[right];
            nums[right] = pivot;
            return right;
        }
        return -1;
    }

    public static int[] quickSelectionForKthLargestElements(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int pivotIndex;
        k = nums.length - k;

        while (left <= right) {
            pivotIndex = partitionHoaresForKthSmallestElements(nums, left, right);

            if (pivotIndex > k)
                right = pivotIndex - 1;
            else if (pivotIndex < k)
                left = pivotIndex + 1;
            else break;
        }
        return Arrays.copyOfRange(nums, k, nums.length);
    }

    // Kth Largest Element
    public static int partitionHoaresForKthLargestElement(int[] nums, int lower, int upper) {
        if (lower <= upper) {
            int middle = (lower + upper) / 2;
            int pivot = nums[middle];
            nums[middle] = nums[lower];
            nums[lower] = pivot;

            int left = lower + 1;
            int right = upper;

            boolean finished = false;
            while (!finished) {

                while (left <= right && nums[left] <= pivot)
                    left++;

                while (nums[right] > pivot)
                    right--;

                if (left < right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }

                finished = left > right;
            }
            nums[lower] = nums[right];
            nums[right] = pivot;
            return right;
        }
        return -1;
    }

    public static int quickSelectionForKthLargestElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int pivotIndex;
        k = nums.length - k;

        while (left <= right) {
            pivotIndex = partitionHoaresForKthLargestElement(nums, left, right);

            if (pivotIndex > k)
                right = pivotIndex - 1;
            else if (pivotIndex < k)
                left = pivotIndex + 1;
            else break;
        }
        return nums[k];
    }

}

class ListNode {
    int val;
    ListNode next;
    public ListNode() {};
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        //noinspection ConstantConditions
        if (lists.length == 0 || lists == null)
            return null;

        Comparator<ListNode> comp = Comparator.comparingInt(o -> o.val);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, comp);

        for (ListNode node : lists) {
            if (node != null)
                queue.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.offer(tail.next);
        }
        return dummy.next;
    }
}

class Solution2 {
    public static ListNode mergeKLists(ListNode[] lists) {
        //noinspection ConstantConditions
        if (lists.length == 0 || lists == null)
            return null;
        return divideKLists(lists, 0, lists.length - 1);

    }
    private static ListNode divideKLists(ListNode[] lists, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            ListNode left = divideKLists(lists, low, middle);
            ListNode right = divideKLists(lists, middle + 1, high);
            return merge(left, right);
        }
        else if (low == high) return lists[low];
        return null;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode tail = result;
        while (left != null || right != null) {
            if (left != null && right != null) {
                if (left.val <= right.val) {
                    tail.next = left;
                    left = left.next;
                } else {
                    tail.next = right;
                    right = right.next;
                }
            } else if (left == null) {
                tail.next = right;
                right = right.next;
            } else {
                tail.next = left;
                left = left.next;
            }
            tail = tail.next;
        }
        return result.next;
    }
}

