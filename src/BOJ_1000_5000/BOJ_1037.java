package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1037 {
    // 약수

    // 진짜 약수란 ? 1과 자기 자신을 제외한 약수를 진짜 약수라고 한다.

    // 진짜 약수의 개수가 주어지고
    // 진짜 약수들이 주어진다.

    // 이 때 진짜 약수들을 가지는 숫자 N을 구하여라.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

        int count = Integer.parseInt( br.readLine() );

        int [] arr = new int[ count ];
        StringTokenizer tokens = new StringTokenizer( br.readLine(), " ");
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt( tokens.nextToken() );
        }

        // 진짜 약수의 최대 최소를 찾기 위해 정렬.
        Arrays.sort( arr );

        // 개수가 1개 일 때는, 1과 자기 자신을 제외한 진짜 약수가 한 개 이므로
        // 진짜 약수를 제곱한 것이 자기 자신이 된다.
        if ( count == 1 ) {
            System.out.println( arr[0] * arr[0] );
        }
        else {
            // 개수가 1개보다 많을 때는 진짜 약수의 최소값과 최대값의 곱이 자기 자신이 된다.
            System.out.println( arr[0] * arr[ arr.length -1 ] );
        }

    }
}
