package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {
    // 소수 구하기
    // 자연수 M과 N이 주어진다.

    // M이상 N이하의 소수를 모두 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        StringTokenizer token1 = new StringTokenizer( br.readLine(), " ");
        int M = Integer.parseInt( token1.nextToken() );
        int N = Integer.parseInt( token1.nextToken() );

        for (int i = M; i <= N; i++) {
            if( isPrime( i ) )          // M이상 N이하의 수 i 중 i가 소수이면 행을 개행하면서 i 값을 출력한다.
                System.out.println( i );
        }
    }
    // 소수 : 1과 자기 자신으로만 나누어 지는 수..
    // 2,3,5,7,11,13,17,19 .....
    private static boolean isPrime( int number ) {
        if( number == 1 )                       // 1은 소수가 아니다.
            return false;
        else if( number == 2 || number == 3 )   // 2와 3은 소수이다.
            return true;
        else {
            // 소수를 나눌 때, 1과 자기 자신을 제외한 수로 나눠지는 지 확인해본다.
            // 2부터 자기 자신 number 까지 나눠지는 지 확인을 해봐도 되긴하는데,
            // 2부터 number의 제곱근까지의 수로 나눠지는지만 확인해도 된다. - 에라스토테네스의 체 -
            for (int i = 2; i <= Math.sqrt( number ) ; i++) {
                if( number % i == 0 )
                    return false;
            }
        }
        return true;
    }
}
