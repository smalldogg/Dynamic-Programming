package 最长序列型;

public class 解码方法 {
    public int numDecodings(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int i, t;
        for (i = 1; i <= n; i++) {
            dp[i] = 0;
            t = chs[i - 1] - '0';
            if (t >= 1 && t <= 9) {
                dp[i] += dp[i - 1];
            }
            if (i >= 2) {
                t = (chs[i - 2] - '0') * 10 + (chs[i - 1] - '0');
                if (t >= 10 && t <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}
