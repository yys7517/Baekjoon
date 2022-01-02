package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJ_1654 {
    // 랜선 자르기

    // K 개의 랜선을 N 개의 랜선으로 잘라내야 할 때,
    // N개의 랜선이 최대 길이로 잘려질 때, 랜선의 길이를 구하시오.

    // 매개변수 탐색
    // 이진 탐색

    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
    private static String[] token;

    static {
        try {
            token = br.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int K = Integer.parseInt( token[0] );
    private static int N = Integer.parseInt( token[1] );

    public static void main(String[] args) throws IOException{
        int [] arr = new int[ K ];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt( br.readLine() );
        }

        long result = ParameterSearch( arr , N );

        System.out.println( result );
    }

    private static long ParameterSearch( int[] arr , int N ) {
        Arrays.sort( arr );

        long start = 1;
        long end = arr[ arr.length -1 ];

        while ( start <= end ) {
            long mid = ( start + end ) / 2 ;
            long count = 0;

            for (int i = 0; i < arr.length; i++) {
                count += ( arr[i] / mid );
            }
            // 구하려고 하는 잘라낸 랜선의 개수보다 잘라낸 랜선의 개수가 작다면 ?
            // 잘라내는 단위가 큰 것.
            // mid가 작아져야 하므로, end 값 감소
            if ( count < N ) {
                end = mid - 1 ;
            }
            // 랜선을 N개 이상 만드는 것도 N개를 만드는 것에 포함이다.
            else {
                // 따라서, count == N을 만족할 때의 길이가 아니라
                // count >= N 일 때의 최대 길이를 구하는 것이다.
                // mid 값을 증가. ( 최대의 랜선을 잘라내는 길이(mid)를 구하기 위해 )
                // start가 end(마지노선)를 넘어서거나 같아질 때 까지 while문을 반복하면
                // 최대의 mid 길이를 구할 수 있다.
                start = mid + 1;
            }
        } // while

        // while 반복문이 끝났을 때의 end의 값이 최대 값이 된다.
        return end;
    }
}
