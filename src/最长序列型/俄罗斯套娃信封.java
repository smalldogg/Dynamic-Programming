package 最长序列型;

import java.util.Arrays;
import java.util.Comparator;

public class 俄罗斯套娃信封 {
		public int maxEnvelopes( int[][] envelopes ) {
				if( envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2 )
						return 0;
				Arrays.sort( envelopes, new Comparator<int[]>( ) {
						public int compare( int[] arr1, int[] arr2 ) {
								if( arr1[0] == arr2[0] )
										return arr2[1] - arr1[1];
								else
										return arr1[0] - arr2[0];
						}
				} );
				int[] dp = new int[envelopes.length];
				int res = 0;
				for( int i = 0; i < envelopes.length; i++ ) {
						dp[i] = 1;
						for( int j = 0; j < i; j++ ) {
								if( envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1] ) {
										dp[i] = Math.max( dp[i], dp[j] + 1 );
								}
						}
						res = Math.max( dp[i], res );
				}
				return res;
		}
}
