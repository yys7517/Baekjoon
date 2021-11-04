package BOJ_1000_5000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1292 {
    // 쉽게 푸는 문제
    // 수열.. 어떤 수열 ? 1은 1번, 2는 2번, 3은 3번, ......... N은 N번이 들어가있는 수열.
    // 이 수열에서 start와 end 사이의 합을 출력
    // start = 3, end = 7이라고 한다면
    // 수열의 3 4 5 6 7 번째 수의 합을 출력하는 문제이다.

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int start = sc.nextInt() ; // 3
        int end = sc.nextInt() ;  // 7

        ArrayList<Integer> list = new ArrayList<>();
        int number = 1;
        loop : while ( true ) {
            // 수열에 number 값을 number 번 만큼 추가하기 위한 for문.....
            // 어차피 3 ~ 7 사이의 합을 구하는 것이면 최대길이인 7 길이의 수열정보만 있어도 된다.
            for ( int i = 0; i < number; i++ ) {
                list.add( number );
                if ( list.size() == end )   // 최대길이가 7이면 loop 반복문을 탈출.
                    break loop;
            }
            number++;
        }
        //System.out.println( list );
        int sum = 0;
        // 3번째부터 7번째 값의 합이기 때문에
        // 인덱스로치면 3-1 ~ 7보다 작은 6까지의 값
        for (int i = start -1 ; i < end  ; i++) {
            sum += list.get(i);
        }
        System.out.println( sum );



    }
}
