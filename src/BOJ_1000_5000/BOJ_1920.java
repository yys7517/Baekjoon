package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1920 {
    // 수 찾기
    // 이진 탐색 문제..

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 해시를 활용한 풀이.
        /*
        int N = Integer.parseInt( br.readLine() );
        StringTokenizer token1 = new StringTokenizer( br.readLine(), " ");

        HashMap<String, Integer> map = new HashMap<>();
        String input;

        for (int i = 0; i < N; i++) {
            input = token1.nextToken();
            if ( map.get( input ) == null )
                map.put( input , 1 );
            else
                map.put( input, map.get(input) + 1 );
        }

        int M = Integer.parseInt( br.readLine() );
        StringTokenizer token2 = new StringTokenizer( br.readLine() , " ");

        String find;
        for (int i = 0; i < M; i++) {
            find = token2.nextToken();
            if( map.get( find ) != null )
                System.out.println( 1 );
            else
                System.out.println( 0 );
        }
         */


        // 이진탐색을 활용한 풀이.
        int N = Integer.parseInt( br.readLine() );
        int[] A = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        for ( int i = 0; i < N; i++ ) {
            A[i] = Integer.parseInt( st1.nextToken() );
        }

        // 탐색할 배열은 반드시 정렬되어 있어야 한다.
        Arrays.sort(A);

        int M = Integer.parseInt( br.readLine() );
        int[] B = new int[M];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for ( int i = 0; i < M; i++ ) {
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

    }
    public static boolean binarySearch( int[] arr, int n ) {
        int start = 0;
        int end = arr.length - 1;
        int middle = ( start + end ) / 2;

        while( start <= end ) {
            if ( arr[middle] == n )
                return true;
            else {
                if ( arr[middle] > n )  // 찾고자 하는 값 n이 middle의 값보다 작다면, 그 밑 부분으로 탐색 범위를 좁힌다.
                    end = middle - 1;   // **
                else                    // 찾고자 하는 값 n이 middle의 값보다 크다면, 그 윗 부분으로 탐색 범위를 좁힌다.
                    start = middle + 1; // **
            }
            middle = ( start + end ) / 2;   // middle 값 갱신. ( start + end 값이 변경되므로 )
        }
        // while문 반복 == 이진 탐색
        // 탐색이 끝났음에도 true를 리턴하지 못하였다면, false를 리턴 == 탐색 실패
        return false;
    }
}
