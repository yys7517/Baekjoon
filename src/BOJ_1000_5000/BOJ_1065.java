package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1065 {
    // 한수
    // 각 자릿수가 등차수열을 이루는 수를 한수라고 한다.

    // N을 입력받고 1 <= (정수) <= N 범위의 정수 중 한수의 개수를 구하는 문제이다.

    // 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다
    // N은 1000보다 작은 자연수.
    // N은 1 ~ 999 를 만족한다.

    // EX ) 111 - 등차 0
    //      753 - 등차 -2
    //      123 - 등차 +1
    //      246 - 등차 +2

    // 그렇다면 한 자릿수와 두 자릿수는 ?
    // EX )     두 자릿수 - 등차를 하나 가지게 된다. 등차가 하나이므로 뭐가 되었던 간에 한수로 인정.
    //          한 자릿수 - 등차를 가지지 않는다. 등차를 가지지 않음을 한수로 인정. ????

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int N = Integer.parseInt( br.readLine() );
        int count = 0;      // 한수를 만족하는 정수의 개수.

        int number = 1;
        // number 값을 1부터 N까지 증가시키며, 한수를 만족할 시 count 의 개수를 증가시킬 것이다.

        while( number <= N ) {
            // number이 100보다 작을 경우, 한 자릿수와 두 자릿수의 정수.
            // 이 수들은 모두 한수이다.
            if( number < 100 )
                count++;
            else {
                // N의 값은 1000보다 작으므로, 이 else에서 다루는 수는 무조건 3자리 수이다.
                // 위에 100보다 작은 경우, 한 자리수와 두 자리수일 때 한수를 모두 처리하였으므로.

                // 100의 자리와 10의 자리의 등차 == 10의 자리와 1의 자리의 등차 ? count++
                int first = number / 100;       // 100의 자리
                int second = ( number - ( 100 * first ) ) / 10; // 10의 자리.
                int third = number % 10;                    // 1의 자리.

                if ( first - second == second - third )
                    count++;
            }
            number++;
        }
        System.out.println( count );

    }
}
