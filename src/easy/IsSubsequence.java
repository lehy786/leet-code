package easy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length(), len2 = t.length(), max = 0;
        int [][]dp = new int[len1+1][len2+1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return max == s.length();
    }
}
