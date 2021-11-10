package BOJ_10000_15000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11866 {
    // 요세푸스 문제 0
    // 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있다.
    // 순서대로 K번째 사람을 제거한다.
    // N명의 사람이 모두 제거될 때까지 계속
    // 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
    // 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
    // N과 K를 입력받은 후 (N,K) 요세푸스 순열을 구하여라.

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        if ( K <= N ) {
            /*



            while ( ! queue.isEmpty() ) {
                if ( queue.size() < K ) {
                    int result_value = queue.poll();
                    result.offer( result_value );
                }
                else {
                    int count = 1;
                    while ( count < K ) {
                        int value = queue.poll();
                        queue.offer( value );
                        count++;
                    }
                    int result_value = queue.poll();
                    result.offer( result_value );
                }
            }

             */
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                queue.offer( i );
            }
            Queue<Integer> result = new LinkedList<>();

            while ( ! queue.isEmpty() ) {

                for (int i = 0; i < K - 1 ; i++) {
                    int val = queue.poll();
                    queue.offer( val );
                } // K 번째 수 전까지의 수를 큐의 뒤로 보낸다.

                // K 번째 수가 제일 앞에 오게 되고, poll 하게 되면 그 수가 제거된다.
                // result라는 이름의 queue에 제거된 순서대로 담게 된다.
                int val = queue.poll();
                result.offer( val );
            }


            // 출력
            System.out.print("<");
            while ( result.size() > 0 ) {
                if ( result.size() == 1 ) {
                    System.out.printf("%d",result.poll());
                }
                else
                    System.out.printf("%d, ", result.poll());
            }
            System.out.print(">");

        }
        else {
            System.exit(0);
        }




    }
}
