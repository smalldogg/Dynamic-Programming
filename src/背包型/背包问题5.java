package 背包型;

public class 背包问题5 {
    //找到能填满背包的方法数
    //最后一个物品用和不用
    public int backPackV(int[] nums, int target) {
        //前 i 个物品能拼出 0 ..... target
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        int i, j;
        dp[0][0] = 1;
        for (i = 1; i <= target; i++) {
            dp[0][i] = 0;
        }
        for (i = 1; i <= n; i++) {
            for (j = 0; j <= target; j++) {
                //不用最后一个物品
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    //用最后一个物品
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }

    public int backPackV2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        int i, j;
        dp[0] = 1;
        for (i = 1; i <= n; i++) {
            for (j = target; j >= 0; j--) {
                if (target >= nums[i - 1]) {
                    dp[j] += dp[j - nums[i - 1]];
                }
            }
        }
        return dp[target];
    }

}
