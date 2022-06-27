package stackandqueue;

import java.util.Stack;

/**
 * Created by luozhenzhao on 2022/2/15
 * description:
 */
public class StackImplQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    public StackImplQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.isEmpty()) {
            move();
        }
        return output.pop();
    }

    public void move() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }

    public int peek() {
        if (output.isEmpty()) {
            move();
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
