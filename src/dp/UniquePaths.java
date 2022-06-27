package dp;

/**
 * Created by luozhenzhao on 2022/3/24
 * description: 62. 不同路径
 */
public class UniquePaths {
	public static int uniquePaths(int m, int n) {
		int [][] dp = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			dp[i][1] = 1;
		}
		for (int i = 1; i <= n; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= m; i++) {
			for (int j = 2; j <= n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(3,7));
	}
}
