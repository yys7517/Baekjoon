package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {
    // 피보나치 함수

    /*  ( C++ 코드 )
    int fibonacci(int n) {
        if (n == 0) {
            printf("0");
            return 0;
        } else if (n == 1) {
            printf("1");
            return 1;
        } else {
            return fibonacci(n‐1) + fibonacci(n‐2);
        }
    }
     */

    // 피보나치 함수가 다음과 같을 때

    // fibonacci(N)이 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성.

    // 첫째 줄에 테스트 케이스 T
    // 다음 줄 부터 테스트 케이스 수 만큼 N값들이 주어진다.
    // N값들이 주어지면, fibonacci(N)이 호출되는 것이다. 그 때, 0과 1이 각각 몇 번 출력되는지 구하라.

    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
    private static StringBuilder sb = new StringBuilder();

//    private static int count_0 = 0;
//    private static int count_1 = 0;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt( br.readLine() );

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt( br.readLine() );
            int [][] counts = new int[N+1][2];
            // counts[0][0] , counts[0][1] -> Fib(0)의 0의 개수 , Fib(0)의 1의 개수
            // counts[1][0] , counts[1][1] -> Fib(1)의 0의 개수 , Fib(1)의 1의 개수

            if( N == 0 ) {
                counts[0][0] = 1;
            }

            else if( N >= 1 ) {
                counts[0][0] = 1;
                counts[1][1] = 1;
            }

            for (int j = 2; j <= N; j++) {
                counts[j][0] = counts[j-1][0] + counts[j-2][0];
                counts[j][1] = counts[j-1][1] + counts[j-2][1];
            }
//            count_0 = 0;
//            count_1 = 0;
            sb.append(counts[N][0]).append(" ").append(counts[N][1]).append('\n');
            // sb.append(count_0).append(" ").append(count_1).append('\n');
        }

        System.out.println( sb );
    }

    /*
    private static int fibonacci( int N ) {
        if( N == 0 ) {
            //count_0++;
            return 0;
        }
        else if ( N == 1 ) {
            //count_1++;
            return 1;
        }

        else
            return fibonacci(N-1) + fibonacci( N-2 );
    }
     */

    // N = 0 일때 1 0
    // N = 1 일때 0 1
    // N = 2 일때 1 1
    // N = 3 일때 1 2
    // N = 4 일때 2 3
}
