package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2747 {
    // 피보나치 수

    // 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다.
    // 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.

    // 입력 값 n 은 90보다 작거나 같은 자연수이다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( br.readLine() );
        int [] arr = new int[ 91 ];

        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= 90 ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println( arr[n] );
    }
}
