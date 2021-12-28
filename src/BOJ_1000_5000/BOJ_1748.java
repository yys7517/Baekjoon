package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748 {
    // 수 이어쓰기 1
    // N 을 입력받고, 1부터 N까지의 수를 이어썼을 때 ?
    // 몇 자리의 수가 되는 지 그 수의 자릿수를 출력하는 문제
    // Ex) N = 15?
    //      123456789101112131415

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int N = Integer.parseInt( br.readLine() );

        int result = 0;

        // 규칙을 활용한 방법.
//        for (int i = 1; i <= N ; i *= 10) {
//            result += N - i + 1;
//        }

        // N = 15 ?
        // result += 15         1의 자리를 가지는 수의 개수
        //                      1의 자리를 가지는 수의 개수가 15개 이므로 15를 더한다.

        // result += 6          10의 자리를 가지는 수의 개수
        //                      10의 자리를 가지는 수의 개수의 10의 자리를 더해준다.


        // N = 1억 ?
        // 1억까지 의 수 중 1의 자리를 가지는 수의 개수 1억개이므로, 1억개의 수가 1의 자리를 가진다. 자릿수 + 1억

        // 1억까지 의 수 중 10의 자리를 가지는 수의 개수는 1억에서 10의 자리를 가지지 않는 수인 9개를 빼준다.
        // 10의 자리를 가지는 수의 개수는 1억 - 10 + 1 개가 되므로, 이 수들의 10의 자리를 더 해준다.
        //  .......... 이 과정들을 반복.
        // 노가다 방법

        for (int i = 1; i <= N ; i++) {
            if ( i < 10 ) result += 1;
            else if( i < 100 ) result += 2;
            else if( i < 1000 ) result += 3;
            else if ( i < 10000 ) result += 4;
            else if ( i < 100000 ) result += 5;
            else if( i < 1000000 ) result += 6;
            else if( i < 10000000 ) result += 7;
            else if( i < 100000000 ) result += 8;
            else result += 9;
        }

        System.out.println( result );
    }
}
