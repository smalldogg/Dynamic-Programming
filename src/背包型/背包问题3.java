package 背包型;

public class 背包问题3 {
    //每一个物品都有无限多
    public int backPackIII(int[] A, int[] V, int m) {
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        int i, j;
        dp[0][0] = 0;
        for (i = 1; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (i = 1; i <= n; i++) {
            for (j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
