package BOJ_1000_5000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164 {
    // 카드2 같은 경우는
    // 카드1 문제에서
    // 남은 한장의 카드만 출력하면 정답이 된다.
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer( i );
        }

        // 결과를 담을 큐..
        Queue<Integer> result = new LinkedList<>();

        while ( queue.size() > 1 ) {
            int result_value = queue.poll();
            result.offer( result_value );
            if ( queue.size() == 1 )
                break;
            else {
                int value = queue.poll();
                queue.offer( value );
            }
        }

//        System.out.println( result );
//        System.out.println( queue );

//        while ( result.size() > 0 ) {
//            System.out.printf("%d ", result.poll());
//        }
        System.out.print(queue.peek());

//        for ( Integer val : result ) {
//            System.out.printf("%d ", val);
//        }
//        System.out.print(queue.peek());
    }
}
