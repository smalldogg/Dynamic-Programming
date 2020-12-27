package 背包型;

public class 零钱兑换2 {


		public int change( int amount, int[] coins ) {

				if( coins == null || coins.length == 0 ) {
						return 0;
				}
				int n = coins.length;
				int[][] dp = new int[n + 1][amount + 1];
				int i, j;
				for( i = 0; i <= n; i++ ) {
						dp[i][0] = 1;
				}
				for( i = 1; i <= n; i++ ) {
						for( j = 1; j <= amount; j++ ) {
								dp[i][j] = dp[i - 1][j];
								if( j >= coins[i - 1] ) {
										dp[i][j] += dp[i][j - coins[i - 1]];
								}
						}
				}
				return dp[n][amount];
		}
}
