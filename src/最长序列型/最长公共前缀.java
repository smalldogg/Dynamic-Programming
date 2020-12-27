package 最长序列型;

public class 最长公共前缀 {
		public String longestCommonPrefix( String[] strs ) {
				if( strs == null || strs.length == 0 ) {
						return "";
				}
				String prefix = strs[0];
				int n = strs.length;
				int i, j;
				for( i = 1; i < n; i++ ) {
						j = 0;
						while( j < strs[i].length( ) && j < prefix.length( ) && strs[i].charAt( j ) == prefix.charAt( j ) ) {
								j++;
						}
						if( j == 0 ) {
								return "";
						}
						prefix = prefix.substring( 0, j );
				}
				return prefix;
		}
}
