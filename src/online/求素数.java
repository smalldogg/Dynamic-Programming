package online;

public class 求素数 {
		public boolean isPrim( int n ) {
				if( n <= 3 ) {
						return n > 1;
				}
				int i;
				for( i = 2; i <= Math.sqrt( n ); i++ ) {
						if( n % i == 0 ) {
								return false;
						}
				}
				return true;
		}

		public static int calPrime( int n ) {
				if( n <= 1 ) {
						return 0;
				}
				byte[] origin = new byte[n + 1];
				int count = 0;
				for( int i = 2; i < n + 1; i++ ) {
						if( origin[i] == 0 ) {
								count++;
								int k = 2;
								while( i * k <= n ) {
										origin[i * k] = 1;
										k++;
								}
						} else {
								continue;
						}
				}
				return count;
		}
}
