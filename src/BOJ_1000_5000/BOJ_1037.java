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
        Arrays.sort( arr );

        if ( count == 1 ) {
            System.out.println( arr[0] * arr[0] );
        }
        else {
            System.out.println( arr[0] * arr[ arr.length -1 ] );
        }

    }
}
