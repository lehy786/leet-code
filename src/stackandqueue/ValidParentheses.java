package stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by luozhenzhao on 2022/2/15
 * description:
 */
public class ValidParentheses {
    public static boolean valid(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(str.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(valid("{{[()]}}"));
    }
}
