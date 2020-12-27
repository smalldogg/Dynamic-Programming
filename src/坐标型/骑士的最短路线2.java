package 坐标型;


public class 骑士的最短路线2 {
		public int shortestPath2( boolean[][] grid ) {
				int n = grid.length;
				if( n == 0 )
						return -1;
				int m = grid[0].length;
				if( m == 0 )
						return -1;

				int[][] dp = new int[n][m];

				dp[0][0] = 0;
				for( int j = 1; j < m; ++j ) {
						for( int i = 0; i < n; ++i ) {
								if( !grid[i][j] ) {
										dp[i][j] = Integer.MAX_VALUE;
										if( i >= 1 && j >= 2 && dp[i - 1][j - 2] != Integer.MAX_VALUE )
												dp[i][j] = Math.min( dp[i][j], dp[i - 1][j - 2] + 1 );
										if( i + 1 < n && j >= 2 && dp[i + 1][j - 2] != Integer.MAX_VALUE )
												dp[i][j] = Math.min( dp[i][j], dp[i + 1][j - 2] + 1 );
										if( i >= 2 && j >= 1 && dp[i - 2][j - 1] != Integer.MAX_VALUE )
												dp[i][j] = Math.min( dp[i][j], dp[i - 2][j - 1] + 1 );
										if( i + 2 < n && j >= 1 && dp[i + 2][j - 1] != Integer.MAX_VALUE )
												dp[i][j] = Math.min( dp[i][j], dp[i + 2][j - 1] + 1 );
								}
						}
				}
				return dp[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1][m - 1];
		}
}
