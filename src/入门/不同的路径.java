package 入门;

public class 不同的路径 {
    //最后一步 ： 要么是从 (m - 2,n - 1) 要么是从( m -1,n -2)
    //子问题 ： 有多少种方式 走到（m -2, n -1）
    //dp[i][j] 代表有多少种方式走到 (i ,j)
    //有多少种方式走到 (m - 1, n - 1)
    public static void main(String[] args) {
        int n = uniquePaths(10, 10);
        System.out.println(n);
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                    if (i - 1 >= 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
