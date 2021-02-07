package 入门;

/**
 * dp[i] ：青蛙能不能跳到 i 位置
 * dp[i] = dp[i - j] && j + a[j] >= i
 */
public class 跳跃游戏 {
		public boolean canJump( int[] A ) {
				int n = A.length;
				if( n <= 0 ) {
						return true;
				}
				boolean[] dp = new boolean[n];
				dp[0] = true;
				for( int i = 1; i < n; i++ ) {
						dp[i] = false;
						for( int j = 0; j < i; j++ ) {
								if( dp[j] && j + A[j] >= i ) {
										dp[i] = true;
										break;
								}
						}
				}
				return dp[n - 1];
		}
}
