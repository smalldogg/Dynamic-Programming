package 有状态的序列型;

public class 买卖股票的最佳时机4 {
		public int maxProfit( int K, int[] prices ) {
				if( prices == null || prices.length == 0 ) {
						return 0;
				}
				int n = prices.length;
				int i, j;

				if( K > n / 2 ) {
						// best time to buy and sell stock ii
						int tmp = 0;
						for( i = 0; i < n - 1; ++i ) {
								tmp += Math.max( 0, prices[i + 1] - prices[i] );
						}

						return tmp;
				}

				int[][] dp = new int[n + 1][2 * K + 1 + 1];

				dp[0][1] = 0;
				for( i = 2; i <= K; i++ ) {
						dp[0][i] = Integer.MIN_VALUE;
				}

				for( i = 1; i <= n; i++ ) {
						for( j = 1; j <= 2 * K + 1; j += 2 ) {
								dp[i][j] = dp[i - 1][j];
								if( j > 1 && i > 1 && dp[i - 1][j - 1] != Integer.MIN_VALUE ) {
										dp[i][j] = Math.max( dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2] );
								}
						}

						for( j = 2; j <= 2 * K + 1; j += 2 ) {
								dp[i][j] = dp[i - 1][j - 1];
								if( i > 1 && dp[i - 1][j] != Integer.MIN_VALUE ) {
										dp[i][j] = Math.max( dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2] );
								}
								if( j > 2 && i > 1 && dp[i - 1][j - 2] != Integer.MIN_VALUE ) {
										dp[i][j] = Math.max( dp[i][j], dp[i - 1][j - 2] + prices[i - 1] - prices[i - 2] );
								}
						}
				}
				int res = Integer.MIN_VALUE;
				for( j = 1; j <= 2 * K + 1; j += 2 ) {
						res = Math.max( res, dp[n][j] );
				}

				return res;
		}
}
