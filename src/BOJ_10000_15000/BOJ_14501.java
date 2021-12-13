package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
    // 퇴사
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int N = Integer.parseInt( br.readLine() );
        int [][] array = new int[ N+1 ][ 2 ];
        // 1 ~ N 일차까지 상담 일정 ( 소요 일 수, pay )

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer( br.readLine(), " ");
            // i 일
            array[i][0] = Integer.parseInt( st.nextToken() );   // 소요 일 수
            array[i][1] = Integer.parseInt( st.nextToken() );   // pay
        }

        int day = 1;
        int pay = 0;
        while ( day != N+1 ) {

        }
    }
}
