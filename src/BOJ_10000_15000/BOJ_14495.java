package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_14495 {
    // 피보나치 비스무리한 수열

    // 피보나치 비스무리한 수열은 f(n) = f(n-1) + f(n-3)이다.
    // f(1) = f(2) = f(3) = 1이다.

    // 1,1,1,2,3,4,6,9,13,19

    // 자연수 n을 입력받아 피보나치 비스무리한 수열의 n번째에 위치한 수를 출력.
    // ( 1 <= n <= 116 )

    // n = 116일때는, 엄청나게 큰 수가 된다.

    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
    private static BigInteger [] arr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt( br.readLine() );

        arr = new BigInteger[ n+1 ];

        // n은 1이상인 자연수.
        // 3보다 작거나 같을 때 n은 1,2,3
        if( n <= 3 )
            System.out.println( 1 );

        else {  // n이 4이상일 때
            arr[0] =BigInteger.ZERO;
            arr[1] = BigInteger.ONE;
            arr[2] = BigInteger.ONE;
            arr[3] = BigInteger.ONE;

            for (int i = 4; i <= n ; i++) {
                arr[i] = arr[i-1].add( arr[i-3] );
            }
            System.out.println( arr[n] );
        }


    }
}
