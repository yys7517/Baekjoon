package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1568 {
    // 새
    // N 마리의 새가 있을 때
    // K 의 노래를 부르기 위해선 K 마리의 새가 날아간다.

    // 이 때 남은 새가 K보다 작을 때는 1부터 다시 올라간다,
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int N = Integer.parseInt(br.readLine() );
        int time = 0;
        int K = 1;

        while ( N > 0 ) {
            if ( K > N ) {
                K = 1;
                continue;
            }
            N -= K;
            time++;
            K++;
        }
        System.out.println( time );
    }
}
