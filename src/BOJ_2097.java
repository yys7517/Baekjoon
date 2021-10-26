import java.util.Scanner;

public class BOJ_2097 {
    // 조약돌
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt();

        // 최소로하려면 조약돌이 4개일 때, 둘레 4의 정사각형을 만들 수 있다.
        // 조약돌이 9개 일때, 둘레 8의 정사각형
        // 조약돌이 16개일때, 둘레 12의 정사각형.
        if ( N < 5 ) {
            System.out.println(4);
            return;
        }
        else {
            int rootN = (int) Math.sqrt(N);
            int result = 4 * (rootN - 1) ;

            // N이 제곱근일 경우, 출력 하고 종료.
            if ( N == rootN * rootN ) {
                System.out.println( result );
                return;
            }
            // result += 4  경우
            //  N
            // 7 8                  rootN = 2
            // 13 14 15             rootN = 3
            // 21 22 23 24          rootN = 4
            // 31 32 33 34 35       rootN = 5

            else if( N > rootN * (rootN+1) && N < ( (rootN + 1) * (rootN + 1) ) ) {
                result += 4;
            }
            else {
                result += 2;
            }

            System.out.println( result );
        }


    }
}
