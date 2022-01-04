package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_1788 {
    // 피보나치 수의 확장

    // 피보나치 수 F(n)을 n이 음수인 경우로도 확장시킬 수 있다.
    //  F(n) = F(n-1) + F(n-2)를 n ≤ 1일 때도 성립되도록 정의

    // 예를 들어 n = 1일 때 F(1) = F(0) + F(-1)
    // F(1) = 1이고, F(0) = 0이므로
    // F(-1) 은 1이 되어야 한다.

    // n = 0 일때 F(0) = F(-1) + F(-2)
    // F(0) = 0이고, F(-1) = 1 이므로, F(-2) = -1

    // n = -1 일때 F(-1) = F(-2) + F(-3)
    // F(-1) = 1, F(-2) = -1, F(-3) = 2

    // n = -2 일때 F(-2) = F(-3) + F(-4)
    // F(-2) = -1 이고, F(-3) = 2이므로
    // -1 = 2 + -3
    // F(-4) = -3

    // n이 음수일 때
    // F(-1) = 1, F(-2) = -1
    // F(-3) = 2, F(-4) = -3
    // F(-5) = 5, F(-6) = -8
    // F(-7) = 13, F(-8) = -21

    // n이 양수일 때
    // F(1) = 1, F(2) = 1
    // F(3) = 2, F(4) = 3
    // F(5) = 5, F(6) = 8
    // F(7) = 13, F(8) = 21

    // n을 입력받고, F(n)이 양수이면 1, 0이면 0, 음수이면 -1을 출력.

    // ********* n은 절댓값이 1,000,000을 넘지 않는 정수이다. ********

    private static long [] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int n = Integer.parseInt( br.readLine() );

        if( n == 0 ) {      // n이 0일 때,
            sb.append(n).append('\n');
            sb.append(n);
        }
        else {  // n이 음의 정수 또는 양의 정수 일때.
            if( n < 0 ) {   // 음의 정수
                        // 음수 중 -뒤에 홀 수가 올때는 양수 값 --> 1
                if( n % 2 == -1 )
                    sb.append(1).append('\n');
                else    // 음수 중 - 뒤에 짝수가 올 때는 음수 값 --> -1
                    sb.append(-1).append('\n');

                // n을 양수로.
                n *= -1;
            }
            else    // n이 양의 정수일때는 모두 양수 값 --> 1
                sb.append(1).append('\n');

            arr = new long[ n+1 ];
            arr[0] = 0;
            arr[1] = 1;
            for (int i = 2; i <= n ; i++) {
                arr[i] = -1;
            }
            sb.append( Fib(n) );
        }

        System.out.println( sb );
    }

    private static long Fib( int n ) {
        if( arr[n] == -1 ) {
            // arr[n] = Fib( n-2 ) + Fib( n-1 );

            // 이 수가 충분히 커질 수 있으므로, 절댓값을 1,000,000,000으로 나눈 나머지를 출력한다.
            arr[n] = ( Fib( n-2 ) + Fib( n-1 )  ) % 1000000000 ;

            // 모듈러 성질을 적용하면
            // arr[n] = ( Fib( n-2 ) % 1000000000 + Fib( n-1 ) % 1000000000 ) % 1000000000;
        }
        return arr[n];
    }


}
