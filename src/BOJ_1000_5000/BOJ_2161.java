package BOJ_1000_5000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2161 {
    // 카드1
    // 제일 위에있는 카드를 버리고, 그 다음으로 위에 있는 카드를 카드 제일 밑으로 넣는다.
    // 이 과정을 카드 한 장이 남을 때 까지 반복한 후.
    // 버려진 카드를 순서대로 출력하고, 남은 한장의 카드도 출력하라.


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

        while ( result.size() > 0 ) {
            System.out.printf("%d ", result.poll());
        }
        System.out.print(queue.peek());

//        for ( Integer val : result ) {
//            System.out.printf("%d ", val);
//        }
//        System.out.print(queue.peek());



    }
}
