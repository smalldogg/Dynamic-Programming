package online;

public class 最大公约数和最小公倍数 {
		public int gcd( int m, int n ) {
				if( m % n == 0 ) {
						return n;
				} else {
						return gcd( n, m % n );
				}
		}

}
