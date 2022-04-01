import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static java.lang.System.out;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriorityQueueExercisesTest {

    @Test
    void topKFrequentPriorityQueue() {
        int[] nums = {1,1,1,2,2,3, 6, 6, 6, 6};
        int k = 2;
        Assertions.assertEquals("[1, 6]", Arrays.toString(PriorityQueueExercises.topKFrequentPriorityQueue(nums, k)));
    }

    @Test
    void topKFrequentBucketSort() {
        // {5, 13, 7, 1, 3, 8, 5, 7, 5, 1, 3, 8, 1};
        int[] nums = {5, 13, 7, 1, 3, 8, 5, 7, 5, 1, 3, 8, 1};
        int k = 3;
        Assertions.assertEquals("[5, 1, 7]", Arrays.toString(PriorityQueueExercises.topKFrequentBucketSort(nums, k)));
    }

    @Test
    void frequencySort() {
        int[] nums = {5, 13, 7, 1, 3, 8, 5, 7, 5, 1, 3, 8, 1};
        System.out.println(Arrays.toString(PriorityQueueExercises.frequencySort(nums)));
    }

    @Test
    void maxSubstring() {
        int[] nums = {2, 1, 5, 3, 3, 2, 1, 4};
        System.out.println(Arrays.toString(PriorityQueueExercises.maxSubstring(nums, 3)));
    }

    @Test
    void kClosest() {
        int[][] nums = {{2, 7}, {3, 4}, {1, 4}, {0, 8}};
        int k = 2;
        System.out.println(Arrays.deepToString(PriorityQueueExercises.kClosest(nums, k)));
    }

    @Test
    void partition() {
        int[][] numsOfList = {{3, 4}, {1, 4}, {0, 8}, {2, 7}};
        PriorityQueueExercises.partitionHoares(numsOfList, 0, numsOfList.length - 1);
        out.println(Arrays.deepToString(numsOfList));
    }

    @Test
    void quickSelection() {
        int[][] numsOfList = {{3, 4}, {0, 8}, {2, 7}, {1, 4}, {1, -1}};
        System.out.println(Arrays.deepToString(PriorityQueueExercises.kNearestToOrigin(numsOfList, 2)));
    }

    @Test
    void quickSelectionForKthSmallestElements() {
        int[] nums = {6, 4, 1, 7, 4, 7, 3, 6, 5};
        out.println(Arrays.toString(PriorityQueueExercises.quickSelectionForKthSmallestElements(nums, 7)));
    }

    @Test
    void quickSelectionForKthLargestElement() {
        int[] nums = {6, 4, 1, 7, 4, 7, 3, 6, 5};
        out.println(PriorityQueueExercises.quickSelectionForKthLargestElement(nums, 1));
    }

    @Test
    void quickSelectionForKthLargestElements() {
        int[] nums = {21,3,34,5,13,8,2,55,1,19};
        int[] array = {6, 4, 1, 7, 4, 7, 3, 6, 5};
        int[] nums2 = {-1,-2,3,4};
        out.println(Arrays.toString(PriorityQueueExercises.quickSelectionForKthLargestElements(nums2, 3)));
    }
 }