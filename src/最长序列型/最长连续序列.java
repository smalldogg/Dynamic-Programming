package 最长序列型;

import java.util.Arrays;

public class 最长连续序列 {
		public int longestConsecutive( int[] nums ) {
				if( nums == null || nums.length == 0 ) {
						return 0;
				}
				Arrays.sort( nums );
				int result = 1;
				int tempMax = 1;
				for( int i = 1; i < nums.length; i++ ) {
						while( i < nums.length - 1 && nums[i] == nums[i - 1] ) {
								i++;
						}
						if( nums[i] == nums[i - 1] + 1 ) {
								tempMax++;
						} else {
								result = Math.max( result, tempMax );
								tempMax = 1;
						}

				}
				result = Math.max( result, tempMax );
				return result;
		}
}
