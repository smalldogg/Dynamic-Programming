package 有状态的序列型;

public class 打劫房屋2 {
    //房子  0  和  n - 1不能同时偷
    public int houseRobber2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        // case 1 : 不打劫 n - 1
        int[] dp = new int[n];
        dp[1] = nums[0];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        //case 2 : 不打劫 0
        int[] dp2 = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i - 1]);
        }
        return Math.max(dp[n - 1], dp2[n]);
    }
}
