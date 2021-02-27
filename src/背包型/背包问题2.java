package 背包型;

public class 背包问题2 {
    public int backPackII(int m, int[] A, int[] V) {
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        int i, j;

        dp[0][0] = 0;

        for (i = 1; i <= m; i++) {
            dp[0][i] = -1;
        }

        for (i = 1; i <= n; i++) {
            for (j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]] != -1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (i = 0; i <= m; i++) {
            if (dp[n][i] != -1) {
                res = Math.max(dp[n][i], res);
            }
        }
        return res;
    }
}
