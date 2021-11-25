package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1021 {
    // 회전하는 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        int N = Integer.parseInt( st.nextToken() ); // 큐의 크기
        int M = Integer.parseInt( st.nextToken() ); // 뽑을 수의 개수.
        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            deque.offer( i );
        }

        int count = 0;
        st = new StringTokenizer( br.readLine(), " ");
        for ( int i = 0; i < M; i++ ) {
            int num = Integer.parseInt( st.nextToken() );

            while ( num != deque.peekFirst() ) {
                count++;
                if ( deque.indexOf(num) <= deque.size() / 2 ) {
                    deque.offerLast( deque.removeFirst() );
                }
                else
                    deque.offerFirst( deque.removeLast() );
            }
            deque.removeFirst();
        }
        System.out.print( count );
    }
}
