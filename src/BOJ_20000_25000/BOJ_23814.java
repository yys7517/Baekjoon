package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23814 {
    // 군만두 서비스의 개수를 최대로 하는 볶음밥의 개수는 몇 개 ?

    // 군만두를 가장 많이 받을 수 있으면서 주문할 수 있는 볶음밥의 최대 개수를 출력해라.

    // 입력되는 정수의 범위가 넓어 32비트 정수형으로 처리할 수 없음에 유의하라.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long D = Long.parseLong(br.readLine());    // 군만두 서비스가 나가는 같은 메뉴 주문 수
        // 같은 메뉴 D개 주문 당 군만두 서비스 1개
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken()); // 짜장면 수
        long M = Long.parseLong(st.nextToken()); // 짬뽕 수
        long K = Long.parseLong(st.nextToken()); // 남은 사람 수 ( 남은 주문 횟수 )

        // 값을 저장해놓는다.
        long tempN = N;
        long tempM = M;
        long tempK = K;


        long max = (N + M + K) / D;             // 최대로 받을 수 있는 군만두 서비스 수.

        long count = 0;  // 군만두 서비스 수

        // K 개만큼 볶음밥을 다 주문했을 때 적합한지 ?
        count = (N / D) + (M / D) + (K / D);
        if (count == max) {
            System.out.print(K);
        }

        else {
            long fN = N % D == 0 ? 0 : D - N % D;   // 서비스를 받기 위해 필요한 짜장면의 개수
            long fM = M % D == 0 ? 0 : D - M % D;   // 서비스를 받기 위해 필요한 짬뽕의 개수

            K = tempK - fN;
            N = tempN + fN;
            M = tempM;
            count = (N / D) + (M / D) + (K / D);
            if (count == max) {
                System.out.print(K);
            }
            else {
                K = tempK - fM;
                N = tempN;
                M = tempM + fM;
                count = (N / D) + (M / D) + (K / D);
                if (count == max) {
                    System.out.print(K);
                }
                else {
                    K = tempK - fN - fM;
                    N = tempN + fN;
                    M = tempM + fM;
                    count = (N / D) + (M / D) + (K / D);
                    if (count == max) {
                        System.out.print(K);
                    }
                }
            }
        }
    }
}

