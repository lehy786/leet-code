package dp;

/**
 * Created by luozhenzhao on 2022/3/28
 * description: 343. 整数拆分
 */
public class IntegerBreak {
	public static int integerBreak(int n) {
		int[] dp = new int[n + 1];
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			for (int j = 1; j < i - 1; j++) {
				// dp[i]在当前循环中暂存了尝试划分j时的目前最优解，同时也要加入下一轮比较
				dp[i] = Math.max(dp[i], Math.max(dp[i-j] * j, (i - j) * j));
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(integerBreak(10));
	}
}
