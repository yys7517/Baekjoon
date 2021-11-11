package BOJ_15000_20000;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BOJ_18258 {
    // 큐 2
    /*
    push X: 정수 X를 큐에 넣는 연산이다.
    pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 큐에 들어있는 정수의 개수를 출력한다.
    empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        int N =  Integer.parseInt( br.readLine() );

        Queue<Integer> queue = new LinkedList<>();
        int back = 0;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N ; i++) {

            StringTokenizer st = new StringTokenizer( br.readLine() );
            String command = st.nextToken();        // 명령어를 command에 담는다.

            if ( st.hasMoreTokens() ) {     // 명령어를 command에 담은 후에도 token이 더 존재한다면
                                            // push X 꼴.. 공백과 숫자를 Integer.parseInt로 정수값으로 바꿀 수 있음.
                int value = Integer.parseInt( st.nextToken() );
                //System.out.println( value );
                queue.offer( value );
                back = value;
                // 큐에 더해지는 값은 맨 뒤에 추가된다.
                // 따라서 제일 뒤에 값을 최근에 더해진 값으로 설정.
            }

            else if ( command.equals("pop") ) {
                if ( !queue.isEmpty() )
                    result.append( queue.poll() ).append('\n');
                else
                    result.append(-1).append('\n');
            }
            else if( command.equals("size") ) {
                //System.out.println( queue );
                result.append( queue.size() ).append('\n');
            }
            else if ( command.equals("empty") ) {
                if ( !queue.isEmpty() )
                    result.append( 0 ).append('\n');
                else
                    result.append( 1 ).append('\n');
            }
            else if ( command.equals("front") ) {
                if ( !queue.isEmpty() )
                    result.append( queue.peek() ).append('\n');
                else
                    result.append( -1 ).append('\n');
            }
            else if ( command.equals("back") ) {
                if ( !queue.isEmpty() ) {
                    result.append( back ).append('\n');
                }
                else
                    result.append( -1 ).append('\n');
            }
        }
        System.out.println( result );
    }
}
