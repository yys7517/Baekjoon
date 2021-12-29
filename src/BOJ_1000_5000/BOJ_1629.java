package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    // 곱셉
    // A를 B번 곱한 수를 C로 나눈 나머지를 출력하는 문제..

    // 시간제한 : 0.5초

    // A를 B번 곱하는 거듭제곱 O(N)
    // 분할정복을 이용한 거듭제곱 O(log2N)

    // 분할정복을 이용하여 거듭제곱을 하는 방법
    // N이 짝수이면 ?
    // 어떤 수 A의 N 승 = A^(N/2) * A^(N/2)

    // N이 홀수이면 ?
    // 어떤 수 A의 N 승 = A^(N-1/2) * A^(N-1/2) * A

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer token1;

    static {
        try {
            token1 = new StringTokenizer( br.readLine(), " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int A = Integer.parseInt(token1.nextToken());
    private static int B = Integer.parseInt(token1.nextToken());
    private static int C = Integer.parseInt(token1.nextToken());
    public static void main(String[] args) throws IOException {

        long result = pow( A,B );

        System.out.println(result);
    }


    /*
    private static long fpow(int C, int n) {
        // 재귀를 활용한 방식
        if (n == 1) {
            return C;
        } else {
            long x = fpow(C, n / 2);

            if (n % 2 == 0) {
                return x * x;
            } else {
                return x * x * C;
            }
        }
    }
     */

    private static long pow( int A, int B ) {
        if ( B == 1 ) {
            return A % C;
        }
        else {
            long x = pow( A, B/2 );
            // 짝수 승
            if( B % 2 == 0 ) {
                // return ( x * x ) % C;   // 숫자의 값이 커지면서 오버 플로우 발생 가능.
                // 모듈러 성질
                return ( x%C * x%C ) % C;
                // return x * x % C;
            }
            // 홀수 승
            else {
                // return ( x * x * A ) % C;   // 숫자의 값이 커지면서 오버 플로우 발생 가능.
                // 모듈러 성질
                return ( x%C * x%C * A%C ) % C;
                // return ( x * x % C ) * A % C;
            }
        }
    }
}
