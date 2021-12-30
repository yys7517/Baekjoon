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
        long N = Long.parseLong(st.nextToken()); // 짜장면 주문한 수
        long M = Long.parseLong(st.nextToken()); // 짬뽕 주문한 수
        long K = Long.parseLong(st.nextToken()); // 남은 사람 수 ( 남은 주문 횟수 )

        long fN = N % D == 0 ? 0 : D - (N % D);   // 서비스를 받기 위해 필요한 짜장면의 개수
        long fM = M % D == 0 ? 0 : D - (M % D);   // 서비스를 받기 위해 필요한 짬뽕의 개수

        long max = (N + M + K) / D;             // 최대로 받을 수 있는 군만두 서비스 수.


        // 값을 저장해놓는다.
//        long tempN = N;
//        long tempM = M;
//        long tempK = K;

        long [] casearr = new long[4];
        long [] caseksize = new long[4];

        // case 1. K명의 사람 모두 볶음밥을 주문한다.
        caseksize[0] = K;
        casearr[0] = N/D + M/D + K/D ;

        // case 2. K명의 사람 중 fN의 인원은 짜장면을 주문하고, 나머지 K-fN의 인원은 볶음밥을 주문한다.
        caseksize[1] = K-fN;
        casearr[1] = (N+fN)/D + M/D + (K-fN)/D ;

        // case 3. K명의 사람 중 fM의 인원은 짬뽕을 주문하고, 나머지 K-fM의 인원은 볶음밥을 주문한다.
        caseksize[2] = K-fM;
        casearr[2] = N/D + (M+fM)/D + (K-fM)/D ;

        // case 4. K명의 사람 중 fN의 인원은 짜장면, fM의 인원은 짬뽕을 추가적으로 주문했을 때
        //          남은 K-fN-fM의 인원은 볶음밥을 주문한다.
        caseksize[3] = K-fN-fM;
        casearr[3] = (N+fN)/D + (M+fM)/D + (K-fN-fM)/D ;

        long result = 0;

        for (int i = 0; i < 4; i++) {
            // 최대의 개수를 만족하면서 최대의 K 값을 구하여야 되므로 result에는 최대의 K 값만 남게된다.
            if( casearr[i] == max && caseksize[i] > result ) {
                result = caseksize[i];
            }
        }
        System.out.println( result );

//        ArrayList<Long> result = new ArrayList<>();
//        long count = 0;     // 받을 수 있는 군만두의 서비스 수
//        // 초기 입력받은 값
//        // K 개만큼 볶음밥을 다 주문했을 때 적합한지 ?
//        count = (N / D) + (M / D) + (K / D);
//        if (count == max) {     // 군만두 서비스 수가 최대로 받을 수 있다면 ?
//            // K 값 리스트에 담기.
//            result.add(K);
//        }
//
//        else {
//            K = tempK - fN;
//            N = tempN + fN;
//            M = tempM;
//            count = (N / D) + (M / D) + (K / D);
//            if (count == max) {     // 군만두 서비스 수가 최대로 받을 수 있다면 ?
//                // K 값 리스트에 담기.
//                result.add(K);
//            }
//            else {
//                K = tempK - fM;
//                N = tempN;
//                M = tempM + fM;
//                count = (N / D) + (M / D) + (K / D);
//                if (count == max) {     // 군만두 서비스 수가 최대로 받을 수 있다면 ?
//                    // K 값 리스트에 담기.
//                    result.add(K);
//                }
//                else {
//                    K = tempK - fN - fM;
//                    N = tempN + fN;
//                    M = tempM + fM;
//                    count = (N / D) + (M / D) + (K / D);
//                    if (count == max) {     // 군만두 서비스 수가 최대로 받을 수 있다면 ?
//                        // K 값 리스트에 담기.
//                        result.add(K);
//                    }
//                }
//            }
//        }
//
//        System.out.println(Collections.max( result ) );
    }
}

