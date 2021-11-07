package BOJ_1000_5000;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1026 {
    // 보물
    // S = A[0] × B[0] + ... + A[N-1] × B[N-1]
    // S의 최소값을 출력하도록.. A의 배열을 재배열하여 S의 최소값을 구하라.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer A [] = new Integer[ N ];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Integer [] B = new Integer[ N ];
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort( A, Collections.reverseOrder() );
        Arrays.sort( B );

        /*
        1 1 0 1 6
        2 7 8 3 1

        6 1 1 1 0
        1 2 3 7 8

        6 + 2 + 3 + 7 = 18


        A를 내림차순 정렬
        B를 오름차순 정렬
         */
        Integer sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i] * B[i];
        }
        System.out.print( sum );

    }
}
