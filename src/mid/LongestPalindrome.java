package mid;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int max = 1;
        int start= 0;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                max = 2;
                start = i;
                dp[i][i + 1] = true;
            }
        }

        for (int len = 3; len < length; len++) { // 子串长度
            for (int i = 0; i <= length - len; i++) { //起始地址
                int j = len + i - 1; // 结束地址
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    max = len;
                    start = i;
                }
            }
        }

        return s.substring(start, max);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

}
