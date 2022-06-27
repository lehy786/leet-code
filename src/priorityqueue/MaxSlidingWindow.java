package priorityqueue;

import java.util.*;

/**
 * Created by luozhenzhao on 2022/2/15
 * description: 239. 滑动窗口最大值
 */
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0)
            return new int[0];
        Deque<Integer> window = new ArrayDeque<>(k);
        Deque<Integer> res = new ArrayDeque<>(nums.length - k + 1);
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && window.peek() <= i - k) {
                window.pollFirst();
            }
            while (!window.isEmpty() && nums[i] > nums[window.peekLast()]) {
                window.pollLast();
            }
            window.offer(i);
            if (i >= k - 1) {
                res.offer(nums[window.peek()]);
            }
        }
        int[] resArr = new int[nums.length - k + 1];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = res.pollFirst();
        }
        return resArr;
    }

    public static void main(String[] args) {
        int[] a = {1,3,1,2,0,5};
        int[] res = maxSlidingWindow2(a, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0)
            return new int[0];
        MonotonicQueue window = new MonotonicQueue();
        int [] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res[i - k + 1] = window.peek();
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    /**
     * 大顶的单调队列
     * 从队尾入队时，把比自己小的前面的元素都踢掉，知道自己落在第一个比自己大的元素后面，让整个队列单调递减
     * 出队时，指明队前要抛出的元素，如果已经在某次后续元素入队时被踢掉，则不用pop出元素
     * peek每次拿到队首都是最大值
     */
    private static class MonotonicQueue {
        Deque<Integer> data;

        public MonotonicQueue() {
            data = new ArrayDeque<>();
        }

        public void push(int n) {
            while (!data.isEmpty() && data.peekLast() < n) {
                data.pollLast();
            }
            data.offer(n);
        }

        public int peek() {
            return data.peekFirst();
        }

        public void pop(int n) {
            if (n == data.peek()) {
                data.pollFirst();
            }
        }
    }
}
