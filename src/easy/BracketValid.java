package easy;

import java.util.Stack;

public class BracketValid {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char target = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(target);
                continue;
            }
            Character c = stack.peek();
            if (c == '(' && target == ')')
                stack.pop();
            else if (c == '[' && target == ']')
                stack.pop();
            else if (c == '{' && target == '}')
                stack.pop();
            else
                stack.push(target);
        }
        return stack.isEmpty();
    }
}
