package BOJ_5000_10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9613 {
    // GCD 합

    // 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성.

    // 첫째 줄 테스트 케이스의 개수 T 를 입력.
    // 각 테스트 케이스는 한 줄로 이루어져있다.
    // 둘째 줄에는 수의 개수 n과 n개의 수들이 공백을 구분으로 입력된다.

    // 입력으로 주어지는 수는 1,000,000을 넘지 않는다.
    // ( 1 <= n <= 100 )

    private static BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt( br.readLine() );

        StringTokenizer tokenizer;
        for (int i = 0; i < T; i++) {
            tokenizer = new StringTokenizer( br.readLine(), " ");
            int n = Integer.parseInt( tokenizer.nextToken() );

            int [] arr = new int[n];


            for (int j = 0; j < n; j++)
                arr[j] = Integer.parseInt( tokenizer.nextToken() );
            // System.out.println(Arrays.toString( arr ));

            long GCD_sum = 0;

            // 모든 쌍에 대한 최대공약수의 합을 구한다.
            for (int j = 0; j < n-1 ; j++) {
                for (int k = j+1 ; k < n ; k++) {
                    GCD_sum += GCD( arr[j], arr[k] );
                }
            }

            sb.append( GCD_sum ).append('\n');

        }
        System.out.println( sb );

    }

    private static long GCD(int A, int B) {
        if( A < B ) {
            int tmp = A;
            A = B;
            B = tmp;
        }
        while ( true ) {
            int r = A % B;
            if ( r == 0 )
                break;
            else {
                A = B;
                B = r;
            }
        }
        return B;
    }
}
