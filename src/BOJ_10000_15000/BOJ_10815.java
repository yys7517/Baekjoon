package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {
    // 숫자 카드
    // N 개의 숫자카드 중 M 개의 숫자 카드를 찾는 문제
    // M 개의 숫자카드가 주어지는데
    // 이 M개의 숫자 카드가 있다면, 그 숫자 카드의 존재 여부를 순서대로 출력하는 문제이다.
    // 있으면 1, 없으면 0
    private static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt( br.readLine() );
        int [] cards = new int[ N ];
        StringTokenizer token1 = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(token1.nextToken() );
        }

        Arrays.sort( cards );   // 이진탐색은 정렬된 배열에서 진행되어야 한다.
        //System.out.println( Arrays.toString( cards ));

        int M = Integer.parseInt( br.readLine() );
        StringTokenizer token2 = new StringTokenizer(br.readLine(), " ");
        while (token2.hasMoreTokens() ) {
            int tmp = Integer.parseInt( token2.nextToken() );
            // System.out.println( tmp );
            if( BinarySearch(cards,tmp) )
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }
        System.out.println( sb );
    }

    private static boolean BinarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;


        while( start <= end ) {
            int mid = ( start + end ) / 2 ;

            if( arr[mid] == key )
                return true;
            else if( arr[mid] < key ) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}
