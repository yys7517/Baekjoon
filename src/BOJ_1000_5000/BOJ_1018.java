package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1018 {
    // 브루트포스 알고리즘
    // 체스판 다시 칠하기
    static char [][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        StringTokenizer st = new StringTokenizer( br.readLine(), " ");
        int N = Integer.parseInt( st.nextToken() );
        int M = Integer.parseInt( st.nextToken() );

        arr = new char[ N ][ M ];
        // N행 M열 arr
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt( j );
            }
        }
        // N : 행 번호
        // M : 열 번호

        int result = Integer.MAX_VALUE;

        // 8 * 8 크기로 자를 때, 자르기 시작하는 시작 점..

        // 시작점은 0번 행 부터 전체 행 - 8까지

        // ex) 9행 16열 짜리 배열을 입력 받았다면
        // 8 * 8 크기로 자를 때, 시작하는 행 번호는 0과 1이 된다.
        //                       각 행 번호마다 자르기 시작하는 열 번호는 0부터 9까지의 수가 된다.
        //                          0 1 2 3 4 5 6 7
        //                                            9 10 11 12 13 14 15 16
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                result = Math.min( result, find(i,j) );
            }
        }
        System.out.println( result );
    }

    private static int find(int i, int j) {
        int B = 0;  // B부터 시작하는 체스판일 때 다시 칠해야하는 정사각형의 수
        int W = 0;  // W부터 시작하는 체스판일 때 다시 칠해야하는 정사각형의 수

        for (int k = i ; k < i + 8 ; k++) {
            for (int l = j; l < j + 8; l++) {
                // k와 l의 합, 세로와 가로 인덱스의 합을 말한다.
                // 이 인덱스의 합이 짝수일 때는 시작점과 같음.

                if( (k+l) % 2 == 0 ) {
                    // 시작점이 B라면
                    // W로 시작할 때 다시 칠해야하는 정사각형의 수가 증가한다.
                    if ( arr[k][l] == 'B' )
                        W++;
                    // 시작점이 W라면
                    // B로 시작할 때 다시 칠해야 하는 정사각형의 수가 증가한다.
                    else
                        B++;

                }
                else { // (k+l) % 2 == 1
                    // 시작점이 아닌 값이 B라면 ? W로 시작하는 것을 의미.
                    // 따라서 B로 시작할 때 다시 칠해야하는 정사각형의 수가 증가한다.
                    if( arr[k][l] == 'B' )
                        B++;
                    // 시작점이 아닌 값이 W라면 ? B로 시작하는 것을 의미.
                    // 따라서 W로 시작할 때, 다시 칠해야 하는 정사각형의 수가 증가한다.
                    else
                        W++;
                }
            }
        }
        return Math.min( B, W );
    }
}
