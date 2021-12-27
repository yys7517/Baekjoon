package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051 {
    // 숫자 정사각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        String[] token = br.readLine().split(" ");
        int N = Integer.parseInt( token[0] );
        int M = Integer.parseInt( token[1] );


        // 값 입력
        int [][] arr = new int[ N ][ M ];

        for (int i = 0; i < arr.length; i++) {
            String[] token1 = br.readLine().split("");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt( token1[j] );
                // System.out.printf("%d ", arr[i][j] );
            }
            // System.out.println();
        }

        int result = 1;     // 정사각형 크기 최소값.
        if ( N > 1 && M > 1 ) {
            int minNM = Math.min( N, M );   // N과 M의 최소값 => 정사각형 한 변의 최대 길이.

            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < M ; j++) {
                    for (int k = 0; k < minNM; k++) {
                        if( i + k < N && j + k < M ) {
                            if( arr[i][j] == arr[i][j+k] ) {
                                if( arr[i][j] == arr[ i+k ][j] ) {
                                    if( arr[i][j] == arr[i+k][j+k] ) {
                                        int tmp = (k+1) * (k+1);
                                        result = Math.max( result, tmp );
                                    }
                                }
                                else
                                    continue;
                            }
                            else
                                continue;
                        }
                    }


                }
            }
        }

        System.out.println( result );


    }
}
