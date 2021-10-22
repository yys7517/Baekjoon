import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_1247 {
    // N개의 정수가 주어지면, 이 정수들의 합 S의 부호를 구하는 프로그램을 작성하시오.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in) );
        BigInteger zero = new BigInteger("0");
        int N;          // 숫자 개수.

        // 3개의 테스트 셋.
        for ( int i = 0; i < 3; i++ ) {
            N = Integer.parseInt( br.readLine() );
            BigInteger s = zero;
            for( int j = 0 ; j < N; j++ ) {
                BigInteger input = new BigInteger(br.readLine());
                s = s.add(input);
            }
            // compareTo
            ///두 수 비교 compareTo
            // 값이 동일하면 0
            // 오른쪽이 크면 -1
            // 왼쪽이 크면 1
            // s.compareTo(zero) == > 0과 합을 비교.
            if ( s.compareTo( zero ) == 0 ) {   // 합이 0이랑 같은가 ?
                System.out.println("0");
            }
            else if ( s.compareTo(zero) == 1 )  // 합이 0보다 더 큰가 ?
                System.out.println("+");
            else                                // 0이 합보다 더 큰가 ?
                System.out.println("-");
        }
    }
}
