package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_10826 {
    // 피보나치 수 4

    // n은 10,000보다 작거나 같은 자연수 또는 0이다.
    // n의 값은 0 또는 1 ~ 10000

    //  다이나믹 프로그래밍
    //  임의 정밀도 / 큰 수( Java : BigInteger )  연산

    private static BigInteger [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int n = Integer.parseInt( br.readLine() );

        if( n == 0 )
            System.out.println( 0 );
        else {
            arr = new BigInteger[ n+1 ];

            arr[ 0 ] = BigInteger.ZERO;
            arr[ 1 ] = BigInteger.ONE;

            for (int i = 2; i <= n; i++) {
                arr[ i ] = arr[i-2].add( arr[i-1] );
            }
            System.out.println( arr[n] );
        }
    }
}
