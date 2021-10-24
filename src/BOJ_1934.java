import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1934 {
    // 최소공배수
    // 유클리드 호제법
    // 최대공약수를 이용하여 최소공배수를 구할 수 있다.


    // 최대공약수의 성질.
    //  A = 서로소 x 최대공약수, B = 서로소 x 최대공약수...
    // 최대공약수를 d라고 할 때..
    // A = ad, B = bd;
    // 최소공배수는 abd
    // A x B = adbd
    // A x B / d == abd
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) ;

        StringBuilder sb = new StringBuilder("");
        int A;
        int B;
        int d; // 최대공약수

        while( N-- > 0 )  {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            d = gcd(A,B);
            sb.append( A*B / d +"\n");

            /*
            브루트포스 알고리즘을 이용하여봤는데.. 시간 초과.....
            min = Math.min( A,B );
            int j = min + 1;

            while(true) {
                if ( j % A == 0 && j % B == 0 ) {
                    answer += j+"\n";
                    break;
                }
                j++;
            }
            */

        }

        System.out.println( sb );

    }
    public static int gcd( int a, int b) {
        while( true ) {
            int r = a % b;
            a = b;
            b = r;
            if ( b == 0 )
                break;
        }
        return a;
    }
}
