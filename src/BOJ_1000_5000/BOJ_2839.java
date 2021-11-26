package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
    // 설탕 배달
    // N 킬로그램을 최소 봉지 개수로 배달해라.
    // 봉지는 3킬로그램 , 5킬로그램을 담을 수 있는 봉지 2가지 이다.
    // 상근이가 배달하는 봉지의 최소 개수를 출력한다.
    // 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int N = Integer.parseInt( br.readLine() );

        int count = 0;  // 봉지 개수

        // only 5kg
        if ( N % 5 == 0 ) {

            count = N / 5;
            System.out.println( count );
            return;
        }

        // 5kg + 3kg
        else {
            int N5 = N / 5;
            for (int i = N5; i > 0; i--) {
                int temp = N - ( i * 5 );
                count = i;
                if ( temp % 3 == 0 ) {
                    count += temp / 3;
                    System.out.println( count );
                    return;
                }
            }
        }

        // only 3kg
        if ( N % 3 == 0) {
            count = N / 3;
            System.out.println( count );
        }

        else
            System.out.println( -1 );

        return;

    }
}
