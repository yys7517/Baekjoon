package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10156 {
    // 과자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in) );
        StringTokenizer st = new StringTokenizer( br.readLine(), " ");
        int K = Integer.parseInt( st.nextToken() );  // 과자 한개의 가격
        int N = Integer.parseInt( st.nextToken() ); // 과자의 개수.
        int M = Integer.parseInt( st.nextToken() ); // 현재 가진 돈..

        int total = K * N;      // 필요한 돈.

        System.out.println( total - M < 0 ? 0 : total - M ) ;

    }
}
