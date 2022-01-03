package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2748 {
    // 피보나치 수 2

    private static long[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int n = Integer.parseInt( br.readLine() );

        arr = new long[ n + 1 ];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = -1;
        }
        // 반복문
        //        int f1 = 0;
//        int f2 = 1;
//        int sum = f1 + f2;
//
//        for (int i = 1; i < n; i++) {
//            sum = f1 + f2;
//            f1 = f2;
//            f2 = sum;
//        }
//
//        System.out.println( sum );

        // n은 90이하의 자연수이다.

        // n = 1 일때 sum = 1
        // n = 2 일때 sum = 1
        // n = 3 일때 sum = 2

        // n = 4 일때 sum = 3
        // n = 5 일때 sum = 5

        // 0 1 1 2 3 5

        System.out.println( Fibonacci(n) );

    }
    private static long Fibonacci( int n ) {
        if( arr[n] == -1 ) {
            arr[n] = Fibonacci(n-1) + Fibonacci(n-2);
        }
        return arr[n];
    }
}
