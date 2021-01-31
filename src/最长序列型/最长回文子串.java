package 最长序列型;

/**
 * @author wangyh
 * @create 2021-01-31 20:44
 */


/**
 * dp[i][j] 从i到j是否为回文
 *
 * 在这一步分类讨论（根据头尾字符是否相等），根据上面的分析得到：
 *
 *
 * dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
 * 说明：
 * 「动态规划」事实上是在填一张二维表格，由于构成子串，
 * 因此 i 和 j 的关系是 i <= j ，因此，只需要填这张表格对角线以上的部分。
 *
 * 看到 dp[i + 1][j - 1] 就得考虑边界情况。
 *
 * 边界条件是：表达式 [i + 1, j - 1] 不构成区间，
 * 即长度严格小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3。
 *
 * 这个结论很显然：j - i < 3 等价于 j - i + 1 < 4，
 * 即当子串 s[i..j] 的长度等于 2 或者等于 3 的时候，
 * 其实只需要判断一下头尾两个字符是否相等就可以直接下结论了。
 *
 * 如果子串 s[i + 1..j - 1] 只有 1 个字符，
 * 即去掉两头，剩下中间部分只有 11 个字符，显然是回文；
 * 如果子串 s[i + 1..j - 1] 为空串，那么子串 s[i, j] 一定是回文子串。
 *
 * 因此，在 s[i] == s[j] 成立和 j - i < 3 的前提下，
 * 直接可以下结论，dp[i][j] = true，否则才执行状态转移。
 */
public class 最长回文子串 {
		public String longestPalindrome(String s) {
			int n = s.length();
			char[] chs = s.toCharArray();
			boolean[][] dp = new boolean[n][n];
			String res = "";
			for (int i = 0; i < n; i++) dp[i][i] = true;
			int maxLen = 0, begin = 0;
			for (int i = 1; i < n; ++i) {
					for (int j = 0; j < i; ++j) {
							if (chs[i] != chs[j]) dp[i][j] = false;
							else {
									if (j - i < 3) dp[i][j] = true;
									else dp[i][j] = dp[i + 1][j - 1];
							}
							if (dp[i][j] && j - i + 1 > maxLen) {
									maxLen = j - i + 1;
				begin = i;
		}
}
			}
			return res;
		}
}
