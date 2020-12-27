package 背包型;

public class 背包问题4 {
		public int backPackIV( int[] nums, int target ) {
				int n = nums.length;
				int[][] dp = new int[n + 1][target + 1];
				int i, j;
				for( i = 0; i <= n; i++ ) {
						dp[i][0] = 1;
				}
				for( i = 1; i <= n; i++ ) {
						for( j = 0; j <= target; j++ ) {
								dp[i][j] = dp[i - 1][j];
								if( j >= nums[i - 1] ) {
										dp[i][j] += dp[i][j - nums[i - 1]];
								}
						}
				}
				return dp[n][target];
		}
}
