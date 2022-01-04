package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_4150 {
    // 피보나치 수

    // 정수 n을 입력받아, n번째 피보나치 수를 출력하는 프로그램

    // ex) 100 -> 354224848179261915075
    // 모든 정답은 1000자를 넘지 않는다. ( f(20) = 6765 이므로 4자다. )

    private static BigInteger [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

        int n = Integer.parseInt( br.readLine() );

        // 음의 정수, 0, 양의 정수(=자연수)로 처리

        if ( n >= 0 ) {
            if ( n == 0 )
                System.out.println( 0 );
            else {
                arr = new BigInteger[ n+1 ];
                arr[0] = BigInteger.ZERO;   // 0
                arr[1] = BigInteger.ONE;    // 1
                for (int i = 2; i <= n; i++) {
                    arr[i] = arr[i-2].add(arr[i-1]);
                }
                System.out.println( arr[n] );
            }
        }
    }
}
