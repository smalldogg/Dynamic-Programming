package 坐标型;

public class 比特位计数 {

    public static void main(String[] args) {
        countBits(7);
    }

    public static int[] countBits(int num) {
        if (num < 0) return new int[]{};
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= num; ++i) {
            if (i % 2 == 0) dp[i] = dp[i / 2];
            else dp[i] = dp[i - 1] + 1;
        }
        return dp;
    }
}
