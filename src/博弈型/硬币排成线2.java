package 博弈型;

public class 硬币排成线2 {
		//取到总价值的一半就能获胜
		//面对第  i 个 数字，先手可以获得的最大价值
		public boolean firstWillWin( int[] values ) {
				int n = values.length;
				int[] dp = new int[n + 1];
				int i;
				int[] sum = new int[n + 1];
				for( i = 1; i <= n; i++ ) {
						sum[i] = sum[i - 1] + values[n - i];
				}
				dp[0] = 0;
				dp[1] = values[n - 1];
				for( i = 2; i <= n; i++ ) {
						dp[i] = sum[i] - Math.min( dp[i - 1], dp[i - 2] );
				}
				return dp[n] > sum[n] / 2;
		}
}
