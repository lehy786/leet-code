package mid;

import java.util.HashSet;

/**
 * Created by luozhenzhao on 2021/9/3
 * description:
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aaaaab"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int left = 0, right = 0, max = 0;
        HashSet<Character> duplicated = new HashSet<>();
        while (right < s.length()) {
            if (duplicated.contains(s.charAt(right))) {
                max = Math.max(max, right - left);
                duplicated.remove(s.charAt(left++));
            } else {
                duplicated.add(s.charAt(right++));
            }
        }
        return Math.max(max, right - left);
    }
}
