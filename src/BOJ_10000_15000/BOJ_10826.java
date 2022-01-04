package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_10826 {
    // 피보나치 수 4

    // 피보나치 수 다른 번호 문제들과 문제는 동일하다.
    // 하지만 주어진 n의 범위가 다르다.

    // n은 10,000보다 작거나 같은 자연수 또는 0이다.
    // n의 값은 0 또는 1 ~ 10000

    //  다이나믹 프로그래밍
    //  임의 정밀도 / 큰 수( Java : BigInteger )  연산

    // BigInteger 자료형 배열 arr
    private static BigInteger [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int n = Integer.parseInt( br.readLine() );

        if( n == 0 )
            System.out.println( 0 );
        else {
            arr = new BigInteger[ n+1 ];

            arr[ 0 ] = BigInteger.ZERO; // 0
            arr[ 1 ] = BigInteger.ONE;  // 1

            // BigInteger.add( BigInteger b )
            for (int i = 2; i <= n; i++) {
                arr[ i ] = arr[i-2].add( arr[i-1] );
            }
            System.out.println( arr[n] );
        }
    }
}
