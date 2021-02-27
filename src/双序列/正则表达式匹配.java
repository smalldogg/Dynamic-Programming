package 双序列;

/**
 * @author wangyh
 * @create 2021-01-26 18:26
 */

public class 正则表达式匹配 {
    /**
     * dp[i][j] 代表 s 的前 i个字符是否匹配 p 的前 j 个字符
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        return true;
    }
}
