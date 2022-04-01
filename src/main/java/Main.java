import java.util.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] array = {6, 4, 1, 7, 4, 7, 3, 6, 5};
        int[] quickArray = { 10, 4, 5, 8, 6, 11, 26 };
        System.out.println(HoaresPartition.partition(array));
        System.out.println(Arrays.toString(array));
//        System.out.println(HoaresPartition.quickSelect(array, 4));
        System.out.println(HoaresPartition.findKthLargest(array, 2));
        System.out.println(HoaresPartition.findKthSmallest(quickArray, 4));

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        for (int data : array)
//            priorityQueue.insert(data);
////        System.out.println(priorityQueue.remove());
////        System.out.println(priorityQueue.remove());
////        System.out.println(priorityQueue.remove());
//        System.out.println(priorityQueue.peek());
//        System.out.println(priorityQueue.size());


//        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
//        Map<String, Integer> map = new HashMap<>();
//        String[] stringArray = {"Ikhide", "Francis", "Samuel", "Thompson", "Reuben", "Philips", "Timothy"};
//        Integer[] integerArray = {31, 38, 35, 21, 45, 42, 29};
//        for (int i = 0; i < stringArray.length; i++)
//            map.put(stringArray[i], integerArray[i]);
//
//        queue.addAll(map.entrySet());
//        System.out.println(queue.remove());
//        System.out.println(queue.peek());
//        System.out.println(queue);

        int[] nums = {1,1,1,2,2,3, 6, 6, 6, 6};
        int k = 3;
        System.out.println(Arrays.toString(PriorityQueueExercises.topKFrequentPriorityQueue(nums, k)));
        List<Integer> list = new ArrayList<>();
        System.out.println(list);

        int[] data = {5, 13, 7, 1, 3, 8, 5, 7, 5, 1, 3, 8, 1};

        System.out.println(Arrays.toString(PriorityQueueExercises.topKFrequentBucketSort(data, 3)));

        String s = "Aabb";
        System.out.println(PriorityQueueExercises.frequencySort(s));

        // Sort Array by Increasing Frequency
        Integer[] integer = {5, 13, 7, 1, 3, 8, 5, 7, 5, 1, 3, 8, 1};
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : integer)
            map.put(num, map.getOrDefault(num, 0) + 1);

        System.out.println(map.entrySet());
        List<Map.Entry<Integer, Integer>> listOfEntry = new ArrayList<>(map.entrySet());
        System.out.println(listOfEntry);


        int[][] numsOfList = {{3, 4}, {1, 4}, {0, 8}, {2, 7}};
        System.out.println(Arrays.deepToString(PriorityQueueExercises.kClosest(numsOfList, 2)));

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};
        System.out.println(Solution.mergeKLists(lists).toString());



    }
}
