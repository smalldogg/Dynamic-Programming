package 入门;

public class 跳跃游戏 {
		//最后一步：
		//dp[i]代表青蛙能不能调到 i 这个位置
		//
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
