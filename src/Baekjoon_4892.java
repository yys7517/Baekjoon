import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_4892 {
    // 숫자 맞추기 게임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int TestCase = 0;
        while ( true ) {
            int n0 = Integer.parseInt( br.readLine() );

            if ( n0 == 0 )
                break;
            else {
                TestCase++;
                sb.append(TestCase+". ");   // "1. "
                int n1 = n0 * 3;
                if ( n1 % 2 == 0 ) {
                    sb.append("even ");     // "1. even "
                }
                else
                    sb.append("odd ");      // "1. odd "
                n0 = n1 % 2 == 0 ? n1/2 : (n1+1)/2; // n2 = n1/2 : n1+1/2

                n0 *=3;         // n3 = 3 * n2;
                n0 /= 9;        // n4 = n3 / 9 ( 나눗셈의 몫 = 정수 값 )

                sb.append(n0).append("\n");  // "1. even(or odd) n4\n"

                n0 = n1 % 2 == 0 ? 2*n0 : 2*n0 + 1;

            }
        }
        System.out.println( sb );
    }
}
