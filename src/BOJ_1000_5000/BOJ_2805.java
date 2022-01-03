package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {
    // 나무 자르기
    // 이분 탐색 , 매개변수 탐색 문제

    // 나무의 수 N, 가져가려고 하는 나무 길이 M

    // 입력 첫째 줄 -> N , M
    // 입력 둘째 줄 -> 나무의 높이 ( 나무 개수 = N )

    // 톱날의 높이 : H

    // 나무의 높이가 H보다 크다면
    // 나무의 높이 - H 의 길이만큼 잘릴 것.

    // 나무의 높이가 H보다 작다면
    // 잘리지 않을 것이다.

    // 따라서 우리가 얻을 수 있는 나무의 길이 M은 ?

    // M += 나무의 높이 - H < 0 ? 0 : 나무의 높이 - H

    // 나무를 필요한 만큼만 집으로 가져가려고 한다.
    // 최대한 M의 나무만 가져가려고 한다.
    // 이 때 절단기에 설정할 수 있는 높이 H 의 최댓값을 구하는 프로그램을 작성하시오.

    // 나무의 높이의 합은 항상 M보다 크거나 같기 때문에,
    // 상근이는 집에 필요한 나무를 항상 가져갈 수 있다.

    private static BufferedReader br;
    private static String[] token;

    private static StringTokenizer trees;

    private static int N ;      // 나무의 개수   ( 1 <= N <= 1,000,000 )
    private static long M ;     // 구하고자 하는 나무의 길이 ( 1 <= M <= 2,000,000,000 )


    public static void main(String[] args) throws IOException{
        br = new BufferedReader( new InputStreamReader( System.in ));

        token = br.readLine().split(" ");

        N = Integer.parseInt( token[0] );
        M = Long.parseLong( token[1] );

        // 나무의 높이
        trees = new StringTokenizer( br.readLine(), " ");

        long [] arr = new long[ N ];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong( trees.nextToken() );
        }

        long result = ParameterSearch( arr );
        System.out.println( result );
    }

    // 나무의 높이 배열 arr가 주어졌을 때, 절단기에 설정할 수 있는 높이의 최댓값 H를 반환.
    private static long ParameterSearch( long[] arr ) {
        Arrays.sort( arr );

        long start = 0;
        long end = arr[ arr.length - 1 ];



        while ( start <= end ) {
            long H = ( start + end ) / 2;
            long current = 0;       // 현재까지 톱날로 잘린 나무들의 높이 합.

            for (int i = 0; i < arr.length; i++) {
                current += arr[i] - H <= 0 ? 0 : arr[i] - H;
            }

            if ( current > M ) // 잘린 나무들의 높이 합이 원하는 나무 길이 M보다 크다면 ? 절단 높이인 H를 높여야 한다.
                start = H + 1 ;
                // 절단 높이 H가 낮으니까 나무들이 많이 잘린 것이다.

            // 합이 구하는 나무 길이보다 작다면, 절단 높이인 H를 낮춰야 한다.
            else if( current < M ) {
                end = H - 1;
            }
            else
                return H;
        }
        return end;
    }
}
