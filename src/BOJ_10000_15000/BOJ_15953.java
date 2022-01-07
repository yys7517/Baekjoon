package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15953 {
    // 카카오 코드 페스티벌 2018 예선 A번
    // 상금 헌터

    // 첫 번째 줄에는 테스트 케이스 T가 주어지고,
    // 다음 T 줄에는 1회 등수 a와 2회 등수 b가 공백을 사이로 주어진다.

    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt( br.readLine() );
        StringTokenizer ab;

        for (int i = 0; i < T; i++) {
            ab = new StringTokenizer( br.readLine(), " ");
            // (0 ≤ a ≤ 100) , (0 ≤ b ≤ 64)
            int sum = 0;        // 테스트 케이스 당 페스티벌 1,2회에서 획득한 총 상금.

            int a = Integer.parseInt( ab.nextToken() );     // 1회 등수

            if( a == 0 ) {
                sum += 0;
            }
            else {  // a > 0
                if( a == 1 )
                    sum += 500;
                else if( a == 2 || a == 3 )
                    sum += 300;
                else if( a >= 4 && a <= 6 )
                    sum += 200;
                else if( a >= 7 && a <= 10 )
                    sum += 50;
                else if( a >= 11 && a <= 15 )
                    sum += 30;
                else if( a >= 16 && a <= 21 )
                    sum += 10;
                else
                    sum += 0;
            }
            int b = Integer.parseInt( ab.nextToken() );     // 2회 등수

            if( b == 0 ) {
                sum += 0;
            }
            else {  // a > 0
                if( b == 1 )
                    sum += 512;
                else if( b == 2 || b == 3 )
                    sum += 256;
                else if( b >= 4 && b <= 7 )
                    sum += 128;
                else if( b >= 8 && b <= 15 )
                    sum += 64;
                else if( b >= 16 && b <= 31 )
                    sum += 32;
                else
                    sum += 0;
            }
            sb.append( sum * 10000 ).append("\n");
        }

        System.out.println( sb );
    }
}
