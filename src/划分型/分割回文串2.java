package 划分型;

public class 分割回文串2 {
		public int minCut( String s ) {
				int n = s.length( );
				if( n <= 0 ) {
						return 0;
				}
				char[] chs = s.toCharArray( );
				int[] dp = new int[n + 1];
				boolean[][] isp = new boolean[n][n];

				int i, j, t;
				//生成回文串数组
				for( t = 0; t < n; t++ ) {
						i = j = t;
						while( i >= 0 && j < n && chs[i] == chs[j] ) {
								isp[i][j] = true;
								i--;
								j++;
						}

						i = t;
						j = t + 1;
						while( i >= 0 && j < n && chs[i] == chs[j] ) {
								isp[i][j] = true;
								i--;
								j++;
						}
				}

				dp[0] = 0;
				for( i = 1; i <= n; i++ ) {
						dp[i] = Integer.MAX_VALUE;
						for( j = 0; j < i; j++ ) {
								if( isp[j][i - 1] ) {
										dp[i] = Math.min( dp[i], dp[j] + 1 );
								}
						}
				}

				return dp[n] - 1;

		}
}
