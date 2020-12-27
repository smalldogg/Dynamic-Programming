package 划分型;

public class 完美平方 {
		public int numSquares( int n ) {
				if( n == 0 ) {
						return 0;
				}
				int[] dp = new int[n + 1];
				dp[0] = 0;
				int i, j;
				for( i = 1; i <= n; i++ ) {
						dp[i] = Integer.MAX_VALUE;
						for( j = 1; j * j <= i; j++ ) {
								if( dp[i - j * j] + 1 < dp[i] ) {
										dp[i] = dp[i - j * j] + 1;
								}
						}
				}
				return dp[n];
		}
}
