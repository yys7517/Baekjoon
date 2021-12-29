package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11653 {
    // 소인수분해 ( 소수판정 )
    //              소수랑 무슨 상관이 있을까 ?

    // 정수 N이 주어졌을 때, 소인수분해하는 프로그램
    // N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력

    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt( br.readLine() );

        int i = 2;  // 제수 i

        // 소인수분해 과정

        // 제수를 2부터 시작한다.

        // 피제수가 제수로 나눠지지 않으면 제수를 1씩 증가시킨다.
        // 이 과정을 반복하다보면, 제수는 주어진 수를 나눠지는 값이 된다.
        // 피제수가 제수로 나눠질 때 그 때의 제수를 소인수에 포함시킨다.
        // 다시 제수를 2 값으로 초기화하고, 주어진 수를 i로 나눈값으로한다.

        while ( N != 1 ) {
            // 나눠진다면
            if( N % i == 0 ) {
                System.out.println( i );    // 소인수에 포함한다. 문제에서는 소인수를 출력하라고 하였다.
                N /= i;                     // 주어진 수를 i로 나눠진 수로 초기화한다.
                i = 2;                      // 제수 i는 다시 2로 초기화하여 2부터 다시 소인수를 찾기 시작.
            }
            // 나눠지지 않으면 제수 + 1
            else
                i++;
        }
    }
}
