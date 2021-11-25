package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_10866 {
    /*
    push_front X: 정수 X를 덱의 앞에 넣는다.
    push_back X: 정수 X를 덱의 뒤에 넣는다.
    pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 덱에 들어있는 정수의 개수를 출력한다.
    empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int N = Integer.parseInt( br.readLine() );
        StringTokenizer st ;
        Deque<Integer> deque = new LinkedList<>();
        while ( N-- > 0 ) {
            st = new StringTokenizer( br.readLine() );
            String command = st.nextToken();
            int value;
            switch ( command ) {

                case "push_back" :
                    value = Integer.parseInt( st.nextToken() );
                    deque.offerLast( value );
                    break;

                case "push_front" :
                    value = Integer.parseInt( st.nextToken() );
                    deque.offerFirst( value );
                    break;

                case "pop_back" :
                    if ( deque.isEmpty() )
                        System.out.println( -1 );
                    else
                        System.out.println( deque.pollLast() );
                    break;

                case "pop_front" :
                    if ( deque.isEmpty() )
                        System.out.println( -1 );
                    else
                        System.out.println( deque.pollFirst() );
                    break;

                case "size" :
                    System.out.println( deque.size() );
                    break;

                case "empty" :
                    if( deque.isEmpty() )
                        System.out.println( 1 );
                    else
                        System.out.println( 0 );
                    break;

                case "front" :
                    if ( deque.isEmpty() )
                        System.out.println( -1 );
                    else
                        System.out.println( deque.peekFirst() );
                    break;

                case "back" :
                    if ( deque.isEmpty() )
                        System.out.println( -1 );
                    else
                        System.out.println( deque.peekLast() );
                    break;
            }
        }
    }
}
