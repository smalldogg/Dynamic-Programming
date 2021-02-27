package 博弈型;

public class 硬币排成线3 {
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        if (n == 0) {
            return true;
        }
        int[][] dp = new int[n][n];
        int i, j, len;
        for (i = 0; i < n; i++) {
            dp[i][i] = values[i];
        }
        for (len = 2; len <= n; len++) {
            for (i = 0; i <= n - len; i++) {
                j = i + len - 1;
                dp[i][j] = Math.max(values[i] - dp[i + 1][j], values[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
