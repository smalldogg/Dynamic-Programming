package 最长序列型;

/**
 * @author wangyh
 * @create 2021-01-31 20:45
 */


/**
 * dp[i][j] s[i..j]中最长回文子序列的长度
 * dp[i][j] = dp[i + 1][j - 1] + 2,
 * dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
 */
public class 最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        char[] chs = s.toCharArray();
        for (int i = 0; i < n; ++i) dp[i][i] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (chs[i] == chs[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
                else {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i + 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][n - 1];
    }
}

