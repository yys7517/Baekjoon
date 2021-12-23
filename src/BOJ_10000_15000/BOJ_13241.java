package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13241 {
    // 최소공배수

    // 유클리드 호제법
    // 두 수 중 큰 수를 작은 수로 나눈다.
    // 작은 수가 큰 수가 되고..
    // 나눈 나머지가 작은 수가 된다.
    // 이 과정을 나머지가 0일 때까지 반복한다.
    // 나머지가 0일 때, 나누는 수가 처음 두 수의 최대 공약수가 된다.


    // *** 최소공배수 = 두 수의 곱 / 두 수의 최대 공약수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        StringTokenizer st = new StringTokenizer( br.readLine(), " ");
        long a = Long.parseLong( st.nextToken() );
        long b = Long.parseLong( st.nextToken() );

        long big = a > b ? a : b;
        long small = a > b? b : a;

        while ( true ) {
            long r = big % small;
            if ( r == 0 )
                break;
            else {
                big = small;
                small = r;
            }
        }

        System.out.println( a*b / small );
    }
}
