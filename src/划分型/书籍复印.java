package 划分型;

public class 书籍复印 {
    //枚举最后一段的起点
    public int copyBooks(int[] pages, int K) {
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int n = pages.length;
        int[][] dp = new int[K + 1][n + 1];

        int i, j, k;
        dp[0][0] = 0;
        for (i = 1; i <= n; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        int sum = 0;
        for (k = 1; k <= K; k++) {
            dp[k][0] = 0;
            for (i = 1; i <= n; i++) {
                dp[k][i] = Integer.MAX_VALUE;
                sum = 0;
                for (j = i; j >= 0; j--) {
                    dp[k][i] = Math.min(dp[k][i], Math.max(dp[k - 1][j], sum));
                    if (j > 0) {
                        sum += pages[j - 1];
                    }
                }
            }
        }
        return dp[K][n];
    }
}
