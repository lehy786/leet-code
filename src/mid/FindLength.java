package mid;

public class FindLength {
    public static int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, max = 0;
        int [][] dp = new int[len1+1][len2+1];

        for (int i = 0; i <= len1; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= len2; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int []a = {70,39,25,40,7};
        int []b = {52,20,67,5,31};
        System.out.println(findLength(a, b));
    }

    /**
     * [70,39,25,40,7]
     * [52,20,67,5,31]
     */
}
