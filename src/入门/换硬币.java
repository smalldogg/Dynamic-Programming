package 入门;

public class 换硬币 {
		//最后一枚硬币是amount - ak
		//子问题： 用最少的硬币拼出ak
		//状态 ： dp[i] 代表用最少的硬币可以拼出 i 元钱
		//dp[i] = dp[i - nums[0]....nums[i]] + 1
		public int coinChange( int[] coins, int amount ) {
				int[] dp = new int[amount + 1];
				dp[0] = 0;
				for( int i = 1; i <= amount; i++ ) {
						dp[i] = Integer.MAX_VALUE;
						for( int j = 0; j < coins.length; j++ ) {
								if( i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE ) {
										dp[i] = Math.min( dp[i], dp[i - coins[j]] + 1 );
								}
						}
				}
				return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
		}
}
