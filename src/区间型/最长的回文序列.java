package 区间型;

public class 最长的回文序列 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        char[] chs = s.toCharArray();
        int[][] dp = new int[n][n];
        int i, j, len;

        for (i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = chs[i] == chs[i + 1] ? 2 : 1;
        }

        for (len = 2; len <= n; len++) {
            for (i = 0; i <= n - len; i++) {
                j = i + len - 1;
                dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                if (chs[i] == chs[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }
        return dp[0][n - 1];
    }
}
