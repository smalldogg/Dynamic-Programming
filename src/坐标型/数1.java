package 坐标型;

public class 数1 {
		//序列 +  位操作的动态规划
		//一般用值做状态
		public int[] countBits( int num ) {
				int[] dp = new int[num + 1];
				int i;
				dp[0] = 0;
				for( i = 1; i <= num; i++ ) {
						dp[i] = dp[i >> 1] + ( i % 2 );
				}
				return dp;
		}
}
