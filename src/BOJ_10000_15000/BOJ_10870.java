package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10870 {
    // 피보나치 수 5

    // n은 20보다 작거나 같은 자연수 또는 0이다.

    private static long [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

        int n = Integer.parseInt( br.readLine() );
        if( n == 0 ) {
            System.out.println( 0 );
        }
        else {
            arr = new long[ n+1 ];

            arr[0] = 0;
            arr[1] = 1;
            for (int i = 2; i <= n ; i++) {
                arr[i] = -1;
            }
            System.out.println( Fibonacci(n) );
        }
    }

    private static long Fibonacci(int n) {
        if( arr[n] == -1 ) {
            arr[n] = Fibonacci( n-1 ) + Fibonacci( n-2 );
        }
        return arr[n];
    }
}
