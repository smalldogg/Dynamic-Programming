package 背包型;

public class 背包问题 {
    //数组的大小和总承重有关
    //每个物品只有一个
    public int backPack(int m, int[] A) {
        int n = A.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        int i, j;
        for (i = 1; i <= n; i++) {
            for (j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - A[i - 1]];
                }
            }
        }

        for (i = m; i >= 0; i--) {
            if (dp[n][i]) {
                return i;
            }
        }

        return 0;
    }
}
