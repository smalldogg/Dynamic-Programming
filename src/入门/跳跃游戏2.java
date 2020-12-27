package 入门;

public class 跳跃游戏2 {
		public int jump( int[] A ) {
				//使用最少的步数跳到最后一个位置
				//使用最少的步数跳到  n - A[i](i ->0..n - 1)
				if( A == null || A.length == 0 ) {
						return 0;
				}
				int n = A.length;
				int[] dp = new int[n];
				dp[0] = 0;
				int i, j;
				for( i = 1; i < n; i++ ) {
						dp[i] = Integer.MAX_VALUE;
						for( j = 0; j < i; j++ ) {
								if( dp[j] != Integer.MAX_VALUE && A[j] + j >= i ) {
										dp[i] = Math.min( dp[i], dp[j] + 1 );
								}
						}
				}
				return dp[n - 1];
		}
}
