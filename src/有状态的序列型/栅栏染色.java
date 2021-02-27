package 有状态的序列型;

public class 栅栏染色 {
    //dp[i]=(k-1)×(dp[i-1]+dp[i-2])
    //dp[i-1]×(k-1)代表当前格子的颜色和前一个不同的方案
    //dp[i-2]×(k-1)代表当前格子的颜色和前一个相同的方案
    public int numWays(int n, int k) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k * k;
        int i;
        for (i = 3; i <= n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
}
