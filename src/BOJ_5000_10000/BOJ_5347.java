package BOJ_5000_10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5347 {
    // LCM
    // LCM은 최소 공배수 라는 뜻.
    // 테스트 케이스 수가 주어지고,
    // 케이스 마다 두 수가 주어진다.
    // 케이스마다 주어지는 두 수의 최소공배수를 출력하는 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

        int T = Integer.parseInt( br.readLine() );
        while ( T-- > 0 ){
            StringTokenizer st = new StringTokenizer( br.readLine(), " ");
            long a = Long.parseLong( st.nextToken() );
            long b = Long.parseLong( st.nextToken() );

            System.out.println( a*b / gcd(a,b) );
        }
    }

    private static long gcd(long a, long b) {
        // a를 큰 수로 만든다.
        if ( a < b ) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        // 유클리드 호제법
        // 나머지가 0일 때 나누는 수가 최대공약수가 된다.
        while ( true ) {
            long r = a % b;
            if( r == 0 ) {
                break;
            }   // 두 수의 나머지가 0일 때
                // break, return b;
            else {
                a = b;
                b = r;
            }
        }

        return b;
    }
}
