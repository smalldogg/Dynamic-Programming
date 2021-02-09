package 入门;

/**
 * dp[i] : 跳到 i 位置使用的最少步数
 * dp[i] = Math.min(dp[i], dp[j] + 1);
 */
public class 跳跃游戏2 {
		public int jump( int[] A ) {
				if( A == null || A.length == 0 ) return 0;
				int n = A.length;
				int[] dp = new int[n];
				dp[0] = 0;
				int i, j;
				for( i = 1; i < n; i++ ) {
						dp[i] = Integer.MAX_VALUE;
						for( j = 0; j < i; j++ ) {
								if( dp[j] != Integer.MAX_VALUE && A[j] + j >= i )
										dp[i] = Math.min( dp[i], dp[j] + 1 );
						}
				}
				return dp[n - 1];
		}
}
