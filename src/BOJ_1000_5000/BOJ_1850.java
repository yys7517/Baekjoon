package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1850 {
    // 최대공약수
    // 두 수의 최대 공약수를 구하는 문제이다.

    // 두 수의 최대 공약수 1을 출력하는 문제 ( 모든 자연수가 1로 이루어져 있다. )

    // ex) 1 = 1
    //     2 = 11
    //     3 = 111
    //     4 = 1111 .........

    // 최대공약수와 최소공배수는 유클리드 호제법을 사용하자.

    
    // 유클리드 호제법이란 ? 
    // ********************
    // 두 수가 있을 때, 두 수를 나누는데
    // 나머지가 0이 될 때까지 반복해서 나눈다.
    // 나머지가 0이 아니면, 나누는 수가 나눠지는 수가 되고,
    // 나머지가 나누는 수가 된다.

    // 나머지가 0이 될 때, 나누는 수인 제수가 최대공약수가 된다.

    // 최소공배수? 두 수의 곱을 최대공약수로 나눈 값과 같다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
        StringTokenizer st = new StringTokenizer( br.readLine(), " ");
        long A = Long.parseLong( st.nextToken() );
        long B = Long.parseLong( st.nextToken() );

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < gcd(A,B); i++) {
            sb.append( 1 );
        }
        System.out.println( sb );
    }

    private static long gcd(long a, long b) {
        if ( a < b ) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        while ( true ) {
            long r = a % b;
            if ( r == 0 )
                break;
            else {
                a = b;
                b = r;
            }
        }

        return b;
    }
}
