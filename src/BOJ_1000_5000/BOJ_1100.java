package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1100 {
    // 하얀 칸

    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
    public static void main(String[] args) throws IOException {
        char [][] chess = new char[8][8];
        String input;
        for (int i = 0; i < 8; i++) {
             input = br.readLine();
            for (int j = 0; j < 8; j++) {
                chess[i][j] = input.charAt( j );
            }
        }

        // 2차원 배열 출력문
        /*
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("%c",chess[i][j]);
            }
            System.out.println();
        }
         */

        // 문제에서는 (0,0) 이 하얀색 칸이라고 하였다.
        // 문제에서 구하는 것은 하얀 칸위에 말이 몇 개 있는지 출력하는 것이다.

        int result = 0;         // 출력할 결과 값. ( 하얀색 칸 위에 있는 체스 말의 개수 )

        // (0,0)이 하얀색 ? 0 + 0 , 즉 인덱스의 합이 짝수 : 하얀색 칸.
        // (0,1)이 검은색 ? 0 + 1 , 즉 인덱스의 합이 홀수 : 검은색 칸.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ( ( i + j ) % 2 == 0 && chess[i][j] == 'F' )
                    result += 1;
            }
        }

        System.out.println( result );
    }
}
