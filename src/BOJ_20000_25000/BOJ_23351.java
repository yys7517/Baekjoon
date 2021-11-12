package BOJ_20000_25000;

import java.util.Scanner;

public class BOJ_23351 {
    public static void main(String[] args) {
        // N, K , A , B
        // 일직선에 있는 N 개의 화분.
        // 각 화분의 초기 수분 K
        // 매일 A개의 화분에
        // B만큼의 수분을. 준다.
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt();
        int K = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        int [] pots = new int[N];
        for (int i = 0; i < N; i++) {
            pots[i] = K;
        }
        // N개의 화분 초기 수분 K..

        // 매일 아래와 같은 일이  ******순서대로****** 일어난다.

        // A개의 화분에 수분을 B만큼 준다.
        // 모든 화분의 수분이 1씩 감소한다.

        // days++

        // 수분이 0이 된 화분에 있는 캣닢은 죽는다
        // 첫 캣닢이 죽는 날짜를 출력

        int days = 1;       // 첫 날은 1일이다.
        int start = 0;      // 물 주는 시작점..

        loop : while( true ) {
            // A개의 화분에 B만큼 수분 주고.
            for (int i = start; i < start + A; i++) {
                pots[i] += B;
            }
            // 시작점을 A만큼 올린다.
            start += A;
            // 끝 화분까지 물을 준 이후가 시작지점이라면, 인덱스 값을 크기만큼 나눈 나머지로
            if ( start >= pots.length )
                start %= pots.length;

            // 수분 -1
            for (int i = 0; i < pots.length; i++) {
                pots[i] -= 1;
                if ( pots[i] == 0 )
                    break loop;
            }

            // 하루 지남.
            days++;
        }

        System.out.println( days );

    }
}
