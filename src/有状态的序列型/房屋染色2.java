package 有状态的序列型;

public class 房屋染色2 {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (costs == null || n == 0) {
            return 0;
        }
        int K = costs[0].length;
        int[][] dp = new int[n + 1][K];
        int min1, min2;
        int j1 = 0, j2 = 0;
        int i, j;

        int res = Integer.MAX_VALUE;
        for (i = 1; i <= n; i++) {
            min1 = min2 = Integer.MAX_VALUE;
            for (j = 0; j < K; j++) {
                if (dp[i - 1][j] < min1) {
                    min2 = min1;
                    j2 = j1;
                    min1 = dp[i - 1][j];
                    j1 = j;
                } else {
                    if (dp[i - 1][j] < min2) {
                        min2 = dp[i - 1][j];
                        j2 = j;
                    }
                }
            }
            for (j = 0; j < K; j++) {
                if (j != j1) {
                    dp[i][j] = dp[i - 1][j1] + costs[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j2] + costs[i - 1][j];
                }
            }
        }
        for (i = 0; i < K; i++) {
            res = Math.min(dp[n][i], res);
        }
        return res;
    }
}
