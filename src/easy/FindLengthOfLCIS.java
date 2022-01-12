package easy;

public class FindLengthOfLCIS {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length, max = 1;
        int [] dp = new int[len];
        for (int i = 0; i < len; i++)
            dp[i] = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}
