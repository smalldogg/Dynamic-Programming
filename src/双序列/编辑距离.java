package 双序列;

/**
 * @author wangyh
 * @create 2021-01-30 23:34
 */


/**
 * 将word1转换成word2的最少步数
 * dp[i][j] 含义 : word1 的前 i 个字符转换成 word2的前 j 个字符的最少步数
 * init:
 * dp[i][j] = dp[i - 1][j - 1]
 * 						word1[i - 1] = word2[j - 1] 相等的情况
 * 					  不相等的情况
 *
 */
public class 编辑距离 {
		public int minDistance(String word1, String word2) {
				char[] s = word1.toCharArray();
				char[] t = word2.toCharArray();
				int n = word1.length(), m = word2.length();
				int[][] dp = new int[n + 1][m + 1];
				for (int i = 0; i <= n; ++i) dp[i][0] = i;
				for (int j = 0; j <= m; ++j) dp[0][j] = j;
				for (int i = 1; i <= n; ++i) {
						for (int j = 1; j <= m; ++j) {
								if (s[i - 1] == t[j - 1]) dp[i][j] = dp[i - 1][j - 1];
								else {   // 1. 替换 2. 删除 3.增加
										dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,
												Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
								}
						}
				}
				return dp[n][m];
		}
}
