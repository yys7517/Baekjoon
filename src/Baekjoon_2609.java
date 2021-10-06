import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2609 {
    // 최대공약수와 최소공배수
    // 유클리드 호제 알고리즘 사용.
    public static void main(String[] args) throws IOException {
        int a,b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt( stringTokenizer.nextToken() );
        b = Integer.parseInt( stringTokenizer.nextToken() );

        // 최소공배수 => a * b / a와 b의 최대공약수
        // a = 서로소 x 최대공약수
        // b = 서로소 x 최대공약수
        // 최소공배수 = 서로소 * 서로소 * 최대공약수
        // a*b = 서로소 * 서로소 * 최대공약수 * 최대공약수
        System.out.println( gcd(a,b) );
        System.out.println( a * b / gcd(a,b));
    }
    public static int gcd(int a, int b) {
        int r;
        while ( true ) {
            r = a % b;
            a = b;
            b = r;
            if ( b == 0 )
                break;
        }
        return a;
    }
}
