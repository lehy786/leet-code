package dp;

/**
 * Created by luozhenzhao on 2022/3/24
 * description: 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {
	public static int minCostClimbingStairs(int[] cost) {
		int [] dp = new int[cost.length];
		dp[0] = cost[0];
		dp[1] = cost[1];

		for (int i = 2; i < cost.length; i++) {
			dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
		}
		return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
	}

	public static void main(String[] args) {
		int [] a = {1,100,1,1,1,100,1,1,100,1};
		System.out.println(minCostClimbingStairs(a));
	}
}
