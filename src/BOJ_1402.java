import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_1402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        int TestCase = Integer.parseInt( br.readLine() );

        /*
        for (int i = 0; i < TestCase; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int[] arr = new int[ Math.abs(A) ];
            int idx = 0;
            int temp = 2;
            while (A != 1) {
                if (A % temp == 0) {
                    arr[idx] = temp;
                    A = A / temp;
                    idx++;
                } else
                    temp++;
            }
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if ( arr[j] == 0 )
                    break;
                else {
                    sum += arr[j];
                }
            }
            if ( sum == B )
                System.out.println("yes");
            else
                System.out.println("no");
        }
        */
        for (int i = 0; i < TestCase; i++) {
            StringTokenizer st = new StringTokenizer( br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt( st.nextToken());
            // 하지만 모든 수 A = A*1*1*1....*1
            // 6 4
            // -1 * -1 * 6 = -1 + -1 + 6 = 4 가능
            // 모든 수가 -1이나 1을 필요한 만큼 곱해주면 가능하다.
            // 따라서 모든 경우에서 yes 가 출력된다.
            System.out.println("yes");
        }
    }
}
