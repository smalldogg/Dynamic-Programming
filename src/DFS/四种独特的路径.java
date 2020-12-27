package DFS;

public class 四种独特的路径 {
		boolean[][] visited;
		int res = 0;
		int[] dx = new int[]{ 0, 1, 0, -1 };
		int[] dy = new int[]{ 1, 0, -1, 0 };
		int m, n;


		private void dfs( int x, int y ) {
				if( x == m - 1 && y == n - 1 ) {
						res++;
						return;
				}

				int nx, ny;
				for( int i = 0; i < 4; i++ ) {
						nx = x + dx[i];
						ny = y + dy[i];
						if( nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] ) {
								visited[nx][ny] = true;
								dfs( nx, ny );
								visited[nx][ny] = false;
						}
				}

		}

		public int uniquePaths( int mm, int nn ) {
				m = mm;
				n = nn;
				int i, j;
				visited = new boolean[m][n];
				visited[0][0] = true;
				dfs( 0, 0 );
				return res;
		}
}
