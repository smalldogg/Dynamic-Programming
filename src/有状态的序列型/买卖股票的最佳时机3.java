package 有状态的序列型;

public class 买卖股票的最佳时机3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n + 1][6];
        int i, j;
        //前 0 天阶段 1 最大获利 是 0
        dp[0][1] = 0;
        dp[0][2] = dp[0][3] = dp[0][4] = dp[0][5] = Integer.MIN_VALUE;

        for (i = 1; i <= n; i++) {

            for (j = 1; j <= 5; j += 2) {
                dp[i][j] = dp[i - 1][j]; //前一天的阶段
                if (j > 1 && i > 1 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] // 前一天在阶段4
                            + prices[i - 1] - prices[i - 2]);
                }
            }

            for (j = 2; j <= 5; j += 2) {
                dp[i][j] = dp[i - 1][j - 1];  //阶段3
                if (i > 1 && dp[i - 1][j] != Integer.MIN_VALUE) {
                    //阶段4
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
                if (j > 2 && i > 1 && dp[i - 1][j - 2] != Integer.MIN_VALUE) {
                    //阶段2
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 2] + prices[i - 1] - prices[i - 2]);
                }
            }
        }


        int res = Integer.MIN_VALUE;
        res = Math.max(Math.max(dp[n][1], dp[n][3]), dp[n][5]);
        return res;
    }
}
