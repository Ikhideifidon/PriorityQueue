import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {6, 4, 1, 7, 4, 7, 3, 6, 5};
        int[] quickArray = { 10, 4, 5, 8, 6, 11, 26 };
        System.out.println(Arrays.toString(array));
        System.out.println(HoaresPartition.quickSelect(array, 8));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int data : array)
            priorityQueue.insert(data);
//        System.out.println(priorityQueue.remove());
//        System.out.println(priorityQueue.remove());
//        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.size());
    }
}
