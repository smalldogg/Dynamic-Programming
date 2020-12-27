package 背包型;

public class 凑N分钱的方案数 {
		public int waysNCents( int n ) {
				int[] coins = { 1, 5, 10, 25 };
				int[] dp = new int[n + 1];
				dp[0] = 1;
				for( int i = 0; i < coins.length; i++ ) {
						for( int j = 1; j <= n; j++ ) {
								if( j >= coins[i] ) {
										dp[j] += dp[j - coins[i]];
								}
						}
				}
				return dp[n];
		}
}
