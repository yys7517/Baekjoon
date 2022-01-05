package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11047 {
    // 동전 0

    // 준규가 가지고 있는 동전은 총 N 종류이고, 각각의 동전을 매우 많이 가지고 있다.
    // ( 1 <= N <= 10 )

    // 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다.
    // 이 때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성.
    // ( 1 <= K <= 100,000,000 )

    // 이 때 K 금액을 만들기 위해 필요한 전체 동전 개수를 구하는 프로그램이다.
    // 하지만 이 때 전체 동전 개수가 최소로 되게 하려면 ? 큰 동전에서 작은 동전 순으로 금액을 채워나가야 한다.

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer( br.readLine(), " ");

        int N = Integer.parseInt(tokenizer.nextToken() );   // .. 동전의 종류 N
        int K = Integer.parseInt(tokenizer.nextToken() );   // .. 만들어야 될 목표 금액 K

        // 동전 정보를 담을 배열.
        // 입력
        int[] coins = new int[ N ];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt( br.readLine() );
        }

        // K 금액을 채우기 위해 동전에 따른 개수를 넣기 위한 배열.
        int [] counts = new int[N];

        // K 금액에 i 번째 동전이 필요한 개수는 K / coins[i] 이다.
        for (int i = N-1; i >= 0; i--) {
            counts[i] = K / coins[i] ;
            // K 값을 줄여준다. 개수 * 동전 값
            // Why? 그 금액만큼 우리는 이미 동전을 사용한 것.
            K -= ( K / coins[i] ) * coins[i];
        }

        // 동전의 개수의 합 -> sum
        int sum = 0;

        // counts 배열에는 할당되지 않은 동전의 개수는 0으로 되있을 것. -> 개수가 없다는 것. 이 동전은 사용되지 않았다.
        // 값이 0보다 크다면 ? 개수가 있다는 것.
        for (int i = 0; i < N; i++) {
            if( counts[i] > 0  )
                sum += counts[i];
        }

        System.out.println( sum );

    }
}
