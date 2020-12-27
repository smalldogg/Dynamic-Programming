package 坐标型;

public class 炸弹袭击 {
		public int maxKilledEnemies( char[][] grid ) {
				if( grid == null || grid.length == 0 || grid[0].length == 0 ) {
						return 0;
				}
				int m = grid.length;
				int n = grid[0].length;
				int[][] res = new int[m][n];
				int[][] dp = new int[m][n];
				int i, j;
				for( i = 0; i < m; i++ ) {
						for( j = 0; j < n; j++ ) {
								res[i][j] = 0;
						}
				}

				//up
				for( i = 0; i < m; i++ ) {
						for( j = 0; j < n; j++ ) {
								if( grid[i][j] == 'W' ) {
										dp[i][j] = 0;
								} else {
										dp[i][j] = 0;
										if( grid[i][j] == 'E' ) {
												dp[i][j] = 1;
										}
										if( i - 1 >= 0 ) {
												dp[i][j] += dp[i - 1][j];
										}
								}
								res[i][j] += dp[i][j];
						}
				}

				//dwon
				for( i = m - 1; i >= 0; i-- ) {
						for( j = 0; j < n; j++ ) {
								if( grid[i][j] == 'W' ) {
										dp[i][j] = 0;
								} else {
										dp[i][j] = 0;
										if( grid[i][j] == 'E' ) {
												dp[i][j] = 1;
										}
										if( i + 1 < m ) {
												dp[i][j] += dp[i + 1][j];
										}
								}
								res[i][j] += dp[i][j];
						}
				}

				//left
				for( i = 0; i < m; i++ ) {
						for( j = 0; j < n; j++ ) {
								if( grid[i][j] == 'W' ) {
										dp[i][j] = 0;
								} else {
										dp[i][j] = 0;
										if( grid[i][j] == 'E' ) {
												dp[i][j] = 1;
										}
										if( j - 1 >= 0 ) {
												dp[i][j] += dp[i][j - 1];
										}
								}
								res[i][j] += dp[i][j];
						}
				}
				//right
				for( i = m - 1; i >= 0; i-- ) {
						for( j = n - 1; j >= 0; j-- ) {
								if( grid[i][j] == 'W' ) {
										dp[i][j] = 0;
								} else {
										dp[i][j] = 0;
										if( grid[i][j] == 'E' ) {
												dp[i][j] = 1;
										}
										if( j + 1 < n ) {
												dp[i][j] += dp[i][j + 1];
										}
								}
								res[i][j] += dp[i][j];
						}
				}
				int result = 0;
				for( i = 0; i < m; i++ ) {
						for( j = 0; j < n; j++ ) {
								if( grid[i][j] == '0' ) {
										if( res[i][j] > result ) {
												result = res[i][j];
										}
								}
						}
				}
				return result;
		}
}
