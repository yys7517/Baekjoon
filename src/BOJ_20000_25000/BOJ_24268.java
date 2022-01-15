package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24268 {
    // 2022는 무엇이 특별할까 ?

    // Hello, BOJ 2022 ! A번

    static boolean[] arr ;  // 진법의 수가 사용되었는지 확인하는 배열
    static int[] count;     // 진법의 수가 사용되었다면 몇 회 사용되었는지 개수 값을 갖는 배열


    static int N;
    static int d;

    // N보다 큰 d 진법의 수 중, d 진법의 모든 숫자가 1번씩만 사용된 수 중
    // 가장 작은 수를 구하는 문제.
    // N의 값보다 큰 수인 N+1 부터 해서 max까지 브루트포스 한다.
    // 조건을 만족할 때 그 N값을 출력.

    static int max; // 진법의 모든 수가 한 번 씩 사용될 때 가장 큰 수.
    // 5진법 -> 43210
    // 6진법 -> 543210
    // 7진법 -> 6543210

    // 일의 자리는 항상 0이다.

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));

        StringTokenizer st = new StringTokenizer( br.readLine(), " ");
        N = Integer.parseInt( st.nextToken() );
        d = Integer.parseInt( st.nextToken() );

        // 9진법에서 계산이 오래 걸린다.. ( 시간초과 )
        // 9진법인데, N이 44317196 이 수 보다 작다면
        // N보다 큰 가장 작은 9진법의 수를 모두 가지고 있는 수는 44317196이 된다.
        // 따라서 44317196를 출력하고, 그 외에는 계산을 해준다.
        if ( d == 9 && N < 44317196 )
            System.out.println( 44317196 );

        else {
            max = 0;

            // 진법의 수를 모두 한 번 씩 사용할 때 최대의 수는 다음과 같이 구할 수 있다.
            for (int i = 1; i < d; i++) {
                max += i * Math.pow( d, i );
            }

            boolean escape = false;

            while ( N >= 1 && N <= max ) {
                N++;
                boolean skipN = false;

                arr = new boolean[ d ];
                count = new int[ d ];

                int temp = N;
                while ( temp != 0 ) {
                    int r = temp % d;
                    arr[ r ] = true;
                    count[r]++;

                    // 진법의 숫자의 개수가 1개를 넘어서는 N의 값은 skip 한다.
                    if( count[r] > 1 ) {
                        skipN = true;
                        break;
                    }
                    temp /= d;
                }
                if( skipN )
                    continue;   // while문 다음 반복.

//            System.out.println("N : " + N);
//            System.out.println( Arrays.toString( arr ));

                // arr[0] ~ arr[d-1] 값이 모두 true이면 while문 break
                for (int i = 0; i < d; i++) {
                    // 진법의 수가 모두 사용되지 않았다면, while문을 다시 반복한다.
                    if( arr[i] == false  ) {
                        escape = false;
                        break ;
                    }
                    else {
                        if ( count[i] == 1 )
                            escape = true;
                        else {
                            escape = false;
                            break;
                        }
                    }
                }

                // escape의 값이 true값이 유지되면 while문의 반복을 끝내고 N 값을 출력한다.
                // escape의 값이 true로 유지되려면, 진법의 모든 수가 사용되어야 하고
                // 개수가 1개씩, 즉 한 번 씩 사용되어야 한다.
                // 그 수가 N 보다 큰 수 중 문제의 조건을 만족하는 수 이다.
                if( escape )
                    break;
            }

            // 최대의 N의 범위 안에 있을 때
            if(  N >= 1 && N <= max )
                System.out.println( N );
            else    // N의 범위를 넘어서는 순간 진법의 모든 수가 1개를 초과해서 사용된다.
                System.out.println(-1);
        }

    }


}
