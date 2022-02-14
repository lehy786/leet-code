package easy;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray_1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int sum = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > 0)
                dp[i + 1] = nums[i] + dp[i];
            else
                dp[i + 1] = nums[i];
            max = Math.max(max, dp[i + 1]);
        }
        return max;
    }
}
