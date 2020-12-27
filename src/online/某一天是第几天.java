package online;

import java.util.Scanner;

public class 某一天是第几天 {
		public static void main( String[] args ) {
				int[] count = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
				Scanner sc = new Scanner( System.in );
				int year = sc.nextInt( );
				int month = sc.nextInt( );
				int day = sc.nextInt( );
				int i, sum = 0;
				for( i = 1; i < month; i++ ) {
						sum += count[i];
				}
				sum += day;
				if( month > 2 && ( year % 4 == 0 && year % 100 != 0 ) || ( year % 400 == 0 ) ) {
						sum++;
				}
				System.out.println( sum );
		}
}
