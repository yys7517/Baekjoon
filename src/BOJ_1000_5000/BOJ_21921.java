package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_21921 {
    // 블로그
    // 총 N일 중, X일 동안 가장 많이 들어온 방문자 수
    // 그 기간의 수를 구하여라.


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        StringTokenizer NX = new StringTokenizer( br.readLine(), " ");
        int N = Integer.parseInt(NX.nextToken() );
        int X = Integer.parseInt(NX.nextToken() );


        int [] visitors = new int[N];

        StringTokenizer st = new StringTokenizer( br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt( st.nextToken() );
        }

        int count = 0;
        long max = 0;
        long sum = 0;
        // X일 동안의
        // 최대 방문자 수를 구한다.
//        while ( start + X <= visitors.length ) {
//            long sum = 0;
//            for (int i = start; i < start + X; i++) {
//                sum += visitors[i];
//            }
//            // System.out.println( sum );
//            sumList.add( sum );
//            if ( max < sum )
//                max = sum;
//            start++;
//        }

//        if ( max == 0 ) {
//            System.out.print("SAD");
//        }
//        else {
//            System.out.println( max );
//            int count = 0;  // max의 값과 같은 기간의 수..
//            /*
//            start = 0;
//
//            while ( start + X <= visitors.length ) {
//                long sum = 0;
//                for (int i = start; i < start + X; i++) {
//                    sum += visitors[i];
//                }
//                //System.out.println( sum );
//                if ( sum == max )
//                    count++;
//                start++;
//            }
//            System.out.print( count );
//            */      /// --> 탐색 logic
//                        // 다시 탐색하지말자.. 시간초과..
//            // 어떻게 해야할까 ??
//            // System.out.println( sumList );
//
//            /*
//            for ( Long value : sumList) {
//                if ( max == value )
//                    count++;
//            }
//            */
//
//            System.out.println( count );
//            // System.out.println(Collections.frequency( sumList, max));
//            // frequency 함수도 결국엔 for문을 사용하여 요소를 방문하며 개수를 센다.
//
//            // 반복을 하지 않고 구해야 시간초과가 나지 않을 것 같다..
//
//        }

        for (int i = 0; i < X; i++) {
            sum += visitors[i];
        }
        // 초기 기간 누적 방문자 수..
        // 최대값을 구하기 위해 초기 방문자 수로 ..
        max = sum;

        if ( max == 0 )
            System.out.print("SAD");
        else {
            count = 1;      // 기본 값은 1이다. 왜냐하면 기간 단위 최대 방문자 수는 무조건 1개 이상이 나오기 때문..

            for (int i = X; i < N; i++) {
                sum += visitors[i];     // 다음 값 더해주고.
                sum -= visitors[i-X];   // 초기 값 빼주고..

                if ( sum > max ) {  // 다음 단위의 값이 더 크면 max값을 바꿔준다.
                    max = sum;
                    count = 1;      // 최대 방문자 수는 다시 1이된다.
                }

                else if ( sum == max )  // 최대 방문자 수가 같은 구간이 있으면 count값 증가.
                    count++;
            }
            System.out.println( max );
            System.out.print( count );
        }

    }

}
