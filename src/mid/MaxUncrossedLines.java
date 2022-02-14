package mid;

public class MaxUncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, max = 0;
        int [][]dp = new int[len1+1][len2+1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return max;
    }
}
