package BOJ_20000_25000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_23348 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int [] difficulty = new int[3];
        for (int i = 0; i < 3; i++) {
            difficulty[i] = sc.nextInt();
        }
        int N = sc.nextInt();       // 동아리의 수
                                    // 동아리 = 3인당 1 동아리.
                                    // 3N 만큼 입력받는다.
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N ; i++) {  // 동아리
            int sum = 0;
            for (int j = 0; j < 3 ; j++) {  // 학생
                for (int k = 0; k < 3; k++) {   // 사용기술..
                    sum += difficulty[k] * sc.nextInt();
                }
            }
            // System.out.println( sum );
            result.add( sum );
        }

        int max = 0;
        for ( int value : result ) {
            if ( max < value )
                max = value;
        }
        System.out.println( max );
    }
}
