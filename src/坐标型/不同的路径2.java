package 坐标型;

public class 不同的路径2 {

		//状态 dp[i][j] 代表从左上角到 (i,j)一共有多少种方式
		public int uniquePathsWithObstacles( int[][] obstacleGrid ) {

				int m = obstacleGrid.length;
				int n = obstacleGrid[0].length;
				if( obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1 ) {
						return 0;
				}
				int[][] dp = new int[m][n];
				int i, j;
				for( i = 0; i < m; i++ ) {
						for( j = 0; j < n; j++ ) {
								if( obstacleGrid[i][j] == 1 ) {
										dp[i][j] = 0;
								} else {
										if( i == 0 && j == 0 ) {
												dp[i][j] = 1;
										} else {
												dp[i][j] = 0;
												if( i - 1 >= 0 ) {
														dp[i][j] += dp[i - 1][j];
												}
												if( j - 1 >= 0 ) {
														dp[i][j] += dp[i][j - 1];
												}
										}
								}
						}
				}
				return dp[m - 1][n - 1];
		}
}
