package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14490 {
    // 백대열

    // 100 : 10 을 최대한 약분하면 ? 10 : 1

    // 두 수를 최대한 약분하여 결과를 출력한다.

    // 두 수의 최대공약수를 구해서, 최대공약수로 약분된 수를 출력해주면 될 것 같다.

    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer( br.readLine(), ":");

        int N = Integer.parseInt( token.nextToken() );
        int M = Integer.parseInt( token.nextToken() );

        // N : M이 주어졌을 때,
        // 최대로 약분된 비를 출력한다.
        sb.append( N / GCD(N,M) ).append(":").append( M / GCD(N,M) );

        System.out.println( sb );
    }

    private static int GCD( int A, int B ) {
        if( A < B ) {
            int tmp = A;
            A = B;
            B = tmp;
        }

        while ( true ) {
            int r = A % B;
            if( r == 0 )
                return B;
            else {
                A = B;
                B = r;
            }
        }
    }
}
