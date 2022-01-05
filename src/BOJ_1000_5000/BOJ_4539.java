package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4539 {
    // 반올림

    // 정수 x가 주어졌을 때, 10보다 크다면, 1의 자리에서 반올림.
    // 결과가 100보다 크다면, 10의 자리에서 반올림.
    // 1000보다 크다면 100의 자리에서 반올림..

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수 T

        int input;

        for (int i = 0; i < T; i++) {
            // 입력 받은 값 : input
            input = Integer.parseInt(br.readLine());

            int div = 10;
            // 만약 10으로 나눠서 0이 된다면 일의 자리만 있는 값.
            // while문을 거치지 않는다.

            // 만약 10으로 나눈 값이 0이 아니라면 10보다 큰 값.
            // 문제에서 제시한 반올림을 while문을 통해 순서대로 진행.
            while (input / div != 0) {
                // 초기값 10이 들어가서 r에는 1의 자리가 들어간다.
                int r = input % div;
                int half = div / 2;

                // 반올림.
                if (r >= half)
                    input += div - r;
                else
                    input -= r;
                div *= 10;
            }
            sb.append(input).append('\n');
        }
        System.out.println( sb );
    }
}
