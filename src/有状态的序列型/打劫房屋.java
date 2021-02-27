package 有状态的序列型;

public class 打劫房屋 {
    //相邻的房子不能偷
    public long houseRobber(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = A[0];
        dp[2] = Math.max(A[0], A[1]);
        int i;
        for (i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i - 1]);
        }
        return dp[n];
    }
}
