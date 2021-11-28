package BOJ_10000_15000;

import java.util.Scanner;

public class BOJ_10829 {
    // 이진수 변환
    private static Scanner sc = new Scanner( System.in );
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        long n = sc.nextLong();

        while ( n != 0 ) {
            sb.append( n % 2 );
            n /= 2;
        }
        System.out.println( sb.reverse() );
    }
}
