package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {
    // 분해합
    // 브루트포스 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /*
        int M = 1;
        int cnt = 0;
        while (true) {
            int temp = M;       //  1
            //System.out.println( "M : " + M);
            int sum = 0;        //  0

            while ( temp >= 1 ) {
                cnt++;
                //System.out.println("cnt : " + cnt);
                temp = temp / 10;
                //System.out.println("temp : " + temp );
            }

            sum += M;
            int temp1 = M;

            while ( cnt > 0 ) {
                cnt--;
                int bubun =  M / square(10,cnt);
                M -= square(10,cnt) * bubun;
                sum += bubun;
            }
            M = temp1;

            if ( sum == N )
                break;
            else
                M++;
        }*/ // while 문으로 한 풀이 방식 - 시간 초과

        int result = 0;

        for ( int i = 0; i < N; i++ ) {
            int number = i;
            int sum = 0;

            // 자릿수 합하기
            while ( number != 0 ) {
                sum += number % 10;
                number /= 10;
            }

            // 자릿수에 본 숫자 더한 값이 N 이면
            if ( sum + i == N ) {
                result = i;
                break;
            }
        }
        System.out.println( result );
    }
    /*
    public static int square(int a,int b) {
        int sum = 1;
        for ( int i = 0 ; i < b; i++ ) {
            sum *= a;
        }
        return sum;
    }
    */  //  내가 만든 제곱 메서드.
}
