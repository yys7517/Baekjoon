import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_1268 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       // N : 학생 수
        int[][] Problem = new int[N + 1][5 + 1];
        // int[][] count = new int[N + 1][5 + 1];
        // 1,1 = 1학년 때 1번 학생이 같은 반 이었던 학생의 수.
        // 1,2 = 2학년 때 1번 학생이 같은 반 이었던 학생의 수.
        // 1,3 = 3학년 때 1번 학생이 같은 반 이었던 학생의 수.

        // 0번 인덱스는 버려 ~
        int [] result = new int[N+1];
        // 최소 한 번이라도 같은 반 이었던 학생 수.
        // result[1] = 1번 학생이 5학년까지 최소 한 번이라도 같은 반이었던 학생의 수.
        // result[2] = 2번 학생이 5학년까지 최소 한 번이라도 같은 반이었던 학생의 수.
        // result[3] = 3번 학생이 5학년까지 최소 한 번이라도 같은 반이었던 학생의 수.
        // result[4] = 4번 학생이 5학년까지 최소 한 번이라도 같은 반이었던 학생의 수.
        // result[5] = 5번 학생이 5학년까지 최소 한 번이라도 같은 반이었던 학생의 수.

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 5; j++) {
                Problem[i][j] = sc.nextInt();
            }
        }
        /*
        for (int num = 1; num <= N; num++) {      // 몇 번 학생
            int temp = 0;
            for (int i = 1; i <= 5; i++) {       // 몇 학년
                for (int j = 1; j <= N; j++) {    // 다른 학생
                    if (j == num) continue;
                    if (Problem[num][i] == Problem[j][i] && temp != j ) {
                        temp = j;
                        //System.out.printf("(%d,%d)\n",num,j);
                        //System.out.println("temp = " + temp);
                        count[num][i]++;
                    }


                }
            }
        }*/

        // 중복을 제거하는 Set 인터페이스를 사용하자.
        // Set에는 무엇이 담기냐 ? Set에는 그 학생이 같은 반이었던 학생의 번호가 담긴다. (중복을 제거)

        // 중복 제거 ? 예를 들면 3번 학생이 2학년 때 2번 학생과 같은 반이었는데, 3학년 때도 2번 학생과 같은 반이면
        // 1명으로 쳐야되지만, 셈을 하게되면 2명으로 하게 되므로, 중복을 제거하는 Set 인터페이스를 활용하자.

        for (int num = 1; num <= N; num++) {      // 몇 번 학생
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= 5; i++) {       // 몇 학년
                for (int j = 1; j <= N; j++) {    // 다른 학생
                    if (j == num) continue;
                    if (Problem[num][i] == Problem[j][i] ) {
                        set.add( j );
                    }
                }
            }
            // System.out.println( set.toString() );
            result[num] = set.size();   // Set의 크기는 같은 반이었던 학생의 수가 된다.
                                        // Set 안에는 한 번이라도 같은 반 이었던 학생들의 번호가 있다.
        }

        // result = [0, 0, 1, 2, 3, 2]   0 번 인덱스는 제외하고 본다.
        // result = [0, 1, 2, 3, 2]
        // System.out.println("result = " + Arrays.toString( result ));


        /*
        for ( int i = 1; i <= N; i++ ) {
            for ( int j = 1; j <=5; j++ ) {
                result[i] += count[i][j];
            }
        }
        */

        // 최대값을 구하는 과정.

        int max = result[1];
        for ( int i = 2; i <= N; i++ ) {
            if ( result[i] > max ) {
                max = result[i];
            }
        }

        // 낮은 번호의 학생부터 for 문을 돌아
        // 한 번이라도 같은 반이었던 학생의 수가 최대인 학생이 겹치더라도
        // 순서대로 돌아 낮은 번호부터 걸리게 된다. ( break )
        for ( int i = 1; i <= N; i++ ) {
            if ( result[i] == max ) {
                System.out.println( i );
                break;
            }
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= 5; j++) {
//                System.out.printf("[%d] ", count[i][j]);
//            }
//            System.out.println();
//        }


    }
}
