package BOJ_5000_10000;

import java.util.Scanner;

public class BOJ_9625 {
    // 버튼을 누를 때마다
    // 화면의 모든 B는 BA로 바뀌고, A는 B로 바뀐다는 사실을 알게되었다.
    // 초기 화면에는 A 하나만 있다.

    // 버튼을 눌렀을 때 B의 개수 = 이전의 A의 개수 + 이전의 B의 개수.
    // 버튼을 눌렀을 때 A의 개수 = 이전의 B의 개수.
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int K = sc.nextInt();
        int countA = 1;
        int countB = 0;

        // 버튼을 눌렀을 때 A의 개수 = 이전의 B의 개수.
        // 버튼을 눌렀을 때 B의 개수 = 이전의 A의 개수 + 이전의 B의 개수.

        while ( K-- > 0 ) {
            int tmp = countA;
            countA = countB;
            countB += tmp;
        }
        System.out.println(countA+" "+countB);

    }


}
