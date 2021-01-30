package 最长序列型;

/**
 * @author wangyh
 * @create 2021-01-30 23:20
 */


/**
 * 最长递增子序列：定义dp数组
 * dp[i] 以 i结尾的最长递增子序列
 * dp[i] = math.max(dp[i], dp[j] + 1);
 */
public class 最长递增子序列 {
		public int lengthOfLIS(int[] nums) {
				int n = nums.length;
				int res = 1;
				int[] dp = new int[n];
				for (int i = 0; i < n; ++i) {
						dp[i] = 1;
						for (int j = 0; j < i; ++i)
								if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
						res = Math.max(dp[i], res);
				}
				return res;
		}
}
