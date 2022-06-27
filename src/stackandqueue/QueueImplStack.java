package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by luozhenzhao on 2022/2/14
 * description:
 */
public class QueueImplStack {
    Queue<Integer> a;
    Queue<Integer> b;
    public QueueImplStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void push(int x) {
        b.offer(x);
        while (!a.isEmpty()) {
            b.offer(a.poll());
        }
        Queue<Integer> temp = a;
        a = b;
        b = temp;
    }

    public int pop() {
        return a.poll();
    }

    public int top() {
        return a.peek();
    }

    public boolean empty() {
        return a.isEmpty();
    }

}
