package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2546 {
    /*
    해당 학생의 IQ가

    C언어 수강생의 평균 IQ 보다 작고

    경제학 학생의 평균 IQ보다 큰

    경우의 수를 출력해주면 된다.

    따라서

    해당 학생의 IQ * C언어 수강생 수 < C언어 수강생의 총 IQ

    해당학생의 IQ * 경제학 수강생 수 > 경제학 수강생의 총 IQ

    의 경우의 수를 계산하면 된다.
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in) );
        int T = Integer.parseInt( br.readLine() );   // 테스트케이스 수.
        ArrayList<Integer> result = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            br.readLine();
            st = new StringTokenizer( br.readLine(), " ");
            int C = Integer.parseInt( st.nextToken() );
            int G = Integer.parseInt( st.nextToken() );
            long [] ciq = new long[C];


            long csum = 0;
            st = new StringTokenizer( br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                ciq[j] = Integer.parseInt( st.nextToken() );
                csum += ciq[j];
            }

            long gsum = 0;
            st = new StringTokenizer( br.readLine(), " ");
            for (int j = 0; j < G; j++) {
                gsum += Integer.parseInt( st.nextToken() );
            }

            Arrays.sort( ciq );

            int count = 0;
            for ( long value : ciq ) {
                if ( value * C < csum && value * G > gsum )
                    count++;
            }
            result.add(count);
        }
        for (int count : result) {
            System.out.println( count );
        }
    }
}
