package BOJ_20000_25000;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_21756 {
    // 지우개
    // 홀 수 번째의 칸에 있는 수들을 모두 지우고..
    // 왼쪽으로 다 모은다.
    // 수가 하나 남을 때 까지.. 진행한다..
    // 하나 남았을 때의 수를 반환하자
    public static void main(String[] args) {
        // 1 <= N <= 100
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt();
        int count = 0;
        while ( N != 1 ) {
            N /= 2;
            count++;
        }
        int result = (int) Math.pow( 2, count );
        System.out.print( result );
        // N이 2의 지수이면, 그대로 출력.
        // N은 1,2,4,8,16,32,64 중 하나이다.
        // N이 32이면 32, 32 <= N < 64, 32

        // N = 1	    1

        // N = 2	    2
        // N = 3 	    2

        // N = 4	    4
        // N = 5	    4
        // N = 6	    4
        // N = 7	    4

        // N = 8 	    8
        // N = 15	    8

        // N = 16       16

        // N = 32       32

        // N = 64       64

    }
}
