package 有状态的序列型;

public class 房屋染色 {
    //不知道的状态，需要记录下来
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][2] = 0;
        int i, j, k;
        for (i = 1; i <= n; i++) {
            for (j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (k = 0; k < 3; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i - 1][j]);
                }
            }
        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}
