package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
    // 수 찾기
    // 이진 탐색 문제..

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt( br.readLine() );
        int[] A = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        for ( int i = 0; i < A.length; i++ ) {
            A[i] = Integer.parseInt( st1.nextToken() );
        }

        // 탐색할 배열은 반드시 정렬되어 있어야 한다.
        Arrays.sort(A);

        int M = Integer.parseInt( br.readLine() );
        int[] B = new int[M];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for ( int i = 0; i < B.length; i++ ) {
            B[i] = Integer.parseInt( st2.nextToken() );
        }

        // System.out.println(Arrays.toString( A ));
        // System.out.println(Arrays.toString( B ));

        // 이진 탐색 알고리즘을 이용하면 시간 단축.
        for ( int i = 0; i < B.length; i++ ) {
            if ( binarySearch( A, B[i] ) )
                System.out.println(1);
            else
                System.out.println(0);
        }

        /*
        int[] result = new int[B.length];

        for ( int i = 0; i < B.length; i++ ) {
            for ( int j = 0 ; j < A.length; j++ ) {
                if ( B[i] == A[j] ) {
                    result[i] = 1;
                }
            }
        }

        for ( int i = 0; i < result.length; i++ ) {
            System.out.println( result[i] );
        }
        */

    }
    public static boolean binarySearch( int[] arr, int n ) {
        int start = 0;
        int end = arr.length - 1;
        int middle = ( start + end ) / 2;

        while( start <= end ) {

            if ( arr[middle] == n )
                return true;

            else {
                if ( arr[middle] > n )
                    end = middle - 1;
                else
                    start = middle + 1;
            }
            middle = ( start + end ) / 2;
        }
        return false;
    }
}
