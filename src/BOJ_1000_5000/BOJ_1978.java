package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {
    // 소수 찾기
    // 주어진 수 N개 중에서 소수가 몇 개인지 출력하는 프로그램.

    // N은 100이하이고, N개의 수는 1000 이하의 자연수이다.

    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt( br.readLine() );

        int count = 0; // 소수의 개수를 셀 변수 count

        StringTokenizer token = new StringTokenizer( br.readLine(), " ");
        while ( token.hasMoreTokens() ) {
            int value = Integer.parseInt( token.nextToken() );
            if( isPrime( value ) )
                count++;
        }
        System.out.println( count );
    }

    private static boolean isPrime( int number ) {
        if( number == 1 )
            return false;
        else if( number == 2 || number == 3 )
            return true;
        else {
            for (int i = 2; i <= Math.sqrt( number ) ; i++) {
                if( number % i == 0 )
                    return false;
            }
            return true;
        }
    }
}
