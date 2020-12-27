package 划分型;

public class 最大的交换 {
		public int maximumSwap( int num ) {
				int[] digit = new int[9];
				int d = 0;
				while( num > 0 ) {
						digit[d] = num % 10;
						num = num / 10;
						d++;
				}
				num = 0;
				for( int i = d - 1; i > 0; i-- ) {//从最高位开始, 对于每一位尝试从低位起寻找一个在它右边的最大的数, 若能找到, 直接交换即可.
						int max = i, j = 0;
						while( j < i ) {
								max = digit[j] > digit[max] ? j : max;
								j++;
						}
						if( max != i ) {
								int temp = digit[i];
								digit[i] = digit[max];
								digit[max] = temp;
								break;
						}
				}
				for( int i = d - 1; i >= 0; i-- ) {
						num = num * 10 + digit[i];
				}
				return num;
		}
}
