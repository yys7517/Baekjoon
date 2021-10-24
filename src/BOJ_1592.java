import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*import java.util.Arrays;*/
import java.util.StringTokenizer;

public class BOJ_1592 {
    // 영식이와 친구들
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, L;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int result = 0;                 // 공이 총 던져진 횟수.
        int[] count = new int[N + 1];   // 공 받은 횟수.
        int ball;                       // 공의 위치.

        // 1번이 먼저 공을 받는다.
        ball = 1;
        count[ball] = 1;

        //System.out.println(Arrays.toString(count));

        while (check(count, M)) {                       // M 번 받은 사람이 있는지 확인.
            if ( count[ ball ] % 2 != 0 ) {             // 자기가 공을 받은 횟수가 홀수 이면 시계방향 L 번째

                if ( ball + L == N )                    // 공을 받은 사람이 마지막 번째 학생일 경우.
                    ball = N;
                else
                    ball = ( ball + L ) % N;            // 공을 받은 사람이 마지막 번째 학생이 아닐 경우

                count[ ball ]++;
                //System.out.println(Arrays.toString(count));
                result++;
            }

            else {                                  // 자기가 공을 받은 횟수가 짝수 이면 반시계방향 L 번째

                if ( ball - L == 0 ) {              // 값이 0이 나올경우는 마지막 사람으로.
                    ball = N;
                    count[ball]++;
                    //System.out.println(Arrays.toString(count));
                    result++;
                }
                else if ( ball - L > 0 ) {      // 값이 양수일 경우
                    ball = (ball - L) % N;
                    count[ball]++;
                    //System.out.println(Arrays.toString(count));
                    result++;
                }
                else {                          // 값이 음수일 경우.
                    ball = ball - L + N;
                    count[ball]++;
                    //System.out.println(Arrays.toString(count));
                    result++;
                }
            }
        }

        //System.out.println(Arrays.toString(count));
        System.out.println(result);
    }

    public static boolean check(int[] arr, int M) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == M) {
                return false;
            }
        }
        return true;
    }
}
