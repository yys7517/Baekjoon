package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1485 {
    // 정사각형
    // 테스트케이스 별로 4개의 점이 주어진다.
    // 4개의 점이 정사각형이 될 수 있으면 1, 아니면 0을 출력하라.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

        int T = Integer.parseInt( br.readLine() ); // 테스트 케이스 수

        while( T-- > 0 ) {
            int result = 1;
            int[] x = new int[4];
            int[] y = new int[4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer( br.readLine(), " ");
                x[i] = Integer.parseInt( st.nextToken() );
                y[i] = Integer.parseInt( st.nextToken() );
            }

            double [] len = new double[6];
            int idx = 0;
            for (int i = 0; i < 3; i++) {
                // x[0], y[0] -- x[1],y[1] , x[2],y[2] , x[3],y[3]
                // x[1], y[1] -- x[2],y[2] , x[3],y[3]
                // x[2], y[2] -- x[3],y[3]
                for (int j = i+1; j < 4; j++) {
                    int xdist = x[j] - x[i];
                    int ydist = y[j] - y[i];
                    len[idx] = Math.sqrt( Math.pow( xdist, 2 ) + Math.pow( ydist, 2 ) );
                    idx++;
                }
            }
            Arrays.sort( len );
            //System.out.println( Arrays.toString( len ));

            // 네 변의 길이가 모두 같지 않다면 ?
            for (int i = 1; i < 4; i++) {
                if( len[0] != len[i] ) result = 0;
            }

            // 두 대각선의 길이가 같지 않다면 ?
            if ( len[4] != len[5] )
                result = 0;

            // 두 조건 통과시 result == 1
            System.out.println( result );
        }
    }
}
