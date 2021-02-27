package 博弈型;

public class 硬币排成线 {
    //博弈性问题  ： 通常从第一步开始分析，因为后面的情况越来越简单
    // dp[i]  面对第 i 个石子， 是否先手必胜


    public boolean firstWillWin(int n) {
        if (n == 0) {
            return false;
        }
        if (n <= 2) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        int i;
        for (i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] == false || dp[i - 2] == false;
        }
        return dp[n];
    }
}
