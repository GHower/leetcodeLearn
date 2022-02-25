package TEST;

import java.util.PriorityQueue;

/**
 * @author ghower
 * @date 2021/11/28 12:02
 */
public class QueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);
        queue.add(4);
        System.out.println(queue);
    }
}
