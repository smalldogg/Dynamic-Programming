package 最长序列型;

public class 最长连续上升子序列 {

    private int maxLength = 0;

    public int longestIncreasingContinuousSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        cal(nums, n);
        int i = 0, j = n - 1, t;
        while (i < j) {
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
        cal(nums, n);
        return maxLength;
    }

    private void cal(int[] nums, int n) {
        int[] dp = new int[n];
        int i;
        for (i = 0; i < n; i++) {
            dp[i] = 1;
            if (i >= 1 && nums[i - 1] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
    }

}
