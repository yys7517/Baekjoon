package BOJ_5000_10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7568 {
    // 덩치
    public static void main(String[] args) throws IOException {
         /*
        이름	(몸무게, 키)	덩치 등수
        A	    (55, 185)	    2
        B	    (58, 183)	    2
        C	    (88, 186)	    1
        D	    (60, 175)	    2
        E	    (46, 155)	    5


         */
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int N = Integer.parseInt( br.readLine() );
        StringTokenizer st;

        int [][] People = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer( br.readLine(), " ");
            People[ i ][ 0 ] = Integer.parseInt( st.nextToken() );  // 몸무게
            People[ i ][ 1 ] = Integer.parseInt( st.nextToken() );  // 키
        }

        int [] result = new int[ N ];       // 덩치 등 수 배열.


        // 만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1
        for (int i = 0; i < N; i++) {
            int bigger = 0 ;    // 자신보다 덩치가 더 큰 사람 수.
            int weight = People[i][0];
            int height = People[i][1];
            for (int j = 0; j < N; j++) {
                if( i == j ) continue;
                else if( People[j][0] > weight && People[j][1] > height ) bigger++;
            }
            result[i] = bigger + 1 ;
        }
        // System.out.println( Arrays.toString( result ));

        for ( int value : result ) {
            System.out.printf("%d ", value );
        }

   }
}
