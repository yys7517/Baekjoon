package BOJ_1000_5000;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int L = sc.nextInt(); // 케이크 조각 수
        int N = sc.nextInt(); // 방청객 수

        // 0 ~ 10 까지의 케이크 배열
        // 0번 인덱스는 사용 X, 1 ~ 10
        int [] cake = new int[L+1];

        // 방청객들이 받고싶어하는 케이크의 개수를 담는 배열.
        // 방청객의 번호 = 인덱스
        // 그 방청객이 받고싶어하는 개수 = 값.
        int [] count = new int[N+1];

        // 실제 케이크의 개수를 담는 배열
        // 방청객의 번호 = 인덱스
        // 실제 그 방청객이 받은 개수 = 값
        int [] realcount = new int[N+1];

        int customerNum = 1;     // 방청객 번호, 1번 방청객 .... 3번 방청객

        // 방청객에게 종이 받는 과정.
        for ( int i = 0 ; i < N; i++ ) {
            // 방청객 수 만큼 반복.
            int start = sc.nextInt();
            int end = sc.nextInt();

            // 그 방청객이 받고싶어하는 케이크의 개수
            count[ customerNum ] = end - start + 1;

            // 실제 받은 개수를 세기 위해 초기화.
            int realcountNum = 0;

            for( int j = start; j <= end; j++ ) {
                // int형 배열을 선언만 해줬으므로 초기값인 0으로 채워져있음.
                // 다른 값으로 채워져 있다는 것은 다른 방청객이 그 케이크를 이미 받음을 의미함.
                if ( cake[j] == 0 ) {
                    cake[j] = customerNum;          // 방청객 번호를 넣어서 그 케이크의 조각이 '품절'되었음을 의미.
                    realcountNum++;                 // 실제 받은 개수 증가.
                }

                else
                    continue;
            }
            realcount[ customerNum ] = realcountNum;
            customerNum++;                          // 다음 방청객.
        }
        // [0, 0, 1, 1, 1, 0, 3, 2, 2, 3, 0]
//        System.out.println(Arrays.toString(cake));
//
//        // [0, 3, 2, 4]
//        System.out.println( Arrays.toString( count ) );
//
//        // [0, 3, 2, 2]
//        System.out.println( Arrays.toString( realcount ));


        // 케이크의 개수를 가장 많이 받을 것 같은 사람 ( 기대되는 사람 ) 의 개수
        int countmax = 0;
        for ( int i = 1; i <= N; i++ ) {
            countmax = countmax < count[i] ? count[i] : countmax;
        }

        // 실제 케이크를 가장 많이 받은 사람의 개수
        int realcountmax = 0;
        for ( int i = 1; i <= N; i++ ) {
            realcountmax = realcountmax < realcount[i] ? realcount[i] : realcountmax;
        }


        // 가장 많이 받을것으로 기대되는 사람의 번호 i 출력 break
        // 가장 많은 조각을 받도록 예상되는 방청객이 여러 명인 경우에는 번호가 작은 사람을 출력한다.
        // for문이 작은 번호부터 반복한다.
        for ( int i = 1; i <= N; i++ ) {
            if (count[i] == countmax) {
                System.out.println( i );
                break;
            }

        }

        // 실제로 가장 많이 받은 사람의 번호 i 출력 후 break
        for ( int i = 1; i <= N; i++ ) {
            if ( realcount[i] == realcountmax ) {
                System.out.println( i );
                break;
            }

        }

    }
}
