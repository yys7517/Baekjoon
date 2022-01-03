package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2512 {
    // 예산

    // 이진 탐색 문제
    // 매개 변수 탐색 ????

    // * 문제 요약 *
    // 가능한 한 총 예산을 사용하는 것.

    // 모든 예산 요청이 배정될 수 있는 경우는 요청한 금액을 그대로 배정한다.
    // 만약 총 예산으로 모든 지방 자치 단체에 예산을 나눠줄 수 없는 경우, 상한액을 배정한다.


    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

    private static long budget;     // 현재 가진 총 예산
    private static int max = 0;    // 요청 예산 중 최대 값.

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt( br.readLine() );
        StringTokenizer token = new StringTokenizer( br.readLine() , " ");
        int [] arr = new int[ N ];

        long sum = 0;

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(token.nextToken() );
            arr[i] = tmp;
            sum += tmp;
            max = Math.max( max , tmp );
        }


        budget = Integer.parseInt( br.readLine() );
        // System.out.println(Arrays.toString(arr) );
        // 총 예산으로 모든 요청에 배정될 수 있다면
        // 배정된 예산의 최대값을 출력.

        int result;

        if ( sum <= budget )
            result = max;
        // 모든 예산을 다 배정을 할 수 있는 것.
        // 최대 요청 예산값이 정답.

        else {
            // 상한액 = 121
            //
            //tmp = 0;
            //if ( 예산 요청 값 < 상한액 )
            //   tmp += 상한액 - 예산;
            //   N--;
            //
            // 상한액 += tmp / N ;

//            long result = budget / N ; // 상한액 초기값 = 전체 예산 / N
//            // System.out.println("초기 상환액 : " + result);
//            // 상한액보다 예산이 적게 되는 지방 단체가 있다면 ?
//            long tmp = 0;
//            int count = N;
//
//            for (int i = 0; i < N; i++) {
//                if( arr[i] < result ) {
//                    tmp += result - arr[i];
//                    count--;
//                }
//            }
//
//            // System.out.println("남는 예산 : " + tmp);
//
//            result += ( tmp / count );
//
//            System.out.println( result );
            result = ParameterSearch( arr );
            // 총 예산으로 모든 요청에 배정될 수 없다면
            // 상한액을 정해야 함.
        }

        System.out.println( result );
    }

    private static int ParameterSearch( int[] arr ) {
        // 최소값
        int start = 0;

        // 최대값 ( 마지노선 )
        int end = max;

        while ( start <= end ) {        // 최소값이 마지노선과 일치해지거나 높아지면 반복을 중단한다.
            int mid = ( start + end ) / 2;  //  현재 상한가

            long current = 0;       // 총 사용 예산

            for (int i = 0; i < arr.length; i++) {
                // 상한가보다 요청 예산이 적다면 ?
                // 필요 예산만 더해준다.
                if( arr[i] < mid ) {
                    current += arr[i];
                }


                // 상한가보다 요청 예산이 크다면 ?
                // 상한가만 더해준다.
                // Why? 상한가를 더해주는 이유는.. 모든 예산 요청이 배정될 수 없는 경우이므로
                // 그 이상인 예산 요청에는 모두 상한액을 배정
                else
                    current += mid;

            }

            if( current < budget ) {
                start = mid + 1;
                // 가지고 있는 예산 budget이 더 클 때, 상한가를 더 높여도 된다.
                // 어차피 이 과정을 반복하는 while문은 마지노선(최대값)을 만나거나 넘어설 때, 종료한다.
            }
            else if ( current > budget ){   // 가지고 있는 예산 budget보다 사용될 예산 current 가 많을 때 ?
                end = mid - 1;              // budget보다 많은 예산 current는 나눠줄 수 없다.
                // 상한가 mid 를 내리기 위해, 마지노선인 end 값을 낮춘다.
            }
            // 상한가를 통해 나눠준 예산의 합이 우리가 가지고 있는 총 예산 budget과 일치할 때
            // 일치할 때, 이 때가 최대 상한액이 될 것이다.

            // 이 경우가 걸리지 않더라도, start가 end 값을 넘어서는 시점에서 while문은 종료된다.
            else
                return mid;

        }   // while

        // 반복문이 종료되는 조건 == start > end
        // 마지노선 값, 최대 값인 end를 return
        return end;

        // start가 upper bound가 되는 것.
        // upper bound - 1인 start - 1의 값을 return 해줘도 된다.
        // return start - 1;

    }
}
