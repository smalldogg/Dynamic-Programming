package 背包型;

public class 组合总和6 {
		//枚举最后一个物品
		// dp[i] 有多少种方式能拼出 i
		//最后一步可能是 target - nums[0]...target - nums[i]
		public int backPackVI( int[] nums, int target ) {
				if( nums == null || nums.length == 0 ) {
						return 0;
				}
				int n = nums.length;
				int[] dp = new int[target + 1];
				int i, j;
				dp[0] = 1;
				//最后一个重量是多少
				for( i = 1; i <= target; i++ ) {
						//枚举每一种可能的方式
						for( j = 0; j < n; j++ ) {
								if( i >= nums[j] ) {
										dp[i] += dp[i - nums[j]];
								}
						}
				}
				return dp[target];
		}
}
