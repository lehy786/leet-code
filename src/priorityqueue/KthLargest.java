package priorityqueue;

import java.util.PriorityQueue;

/**
 * Created by luozhenzhao on 2022/2/15
 * description: 703. 数据流中的第 K 大元素
 */
public class KthLargest {
    private PriorityQueue<Integer> queue;
    private int size;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        size = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < size) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
