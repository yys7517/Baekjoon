import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String n = br.readLine();
        System.out.println( Integer.parseInt(n,16) );
    }
}

        // 16 진수 - > 10진수
        // n이 String, n이 int여도 된다.
        // Integer.parseInt( n, 16 );

        // 10 진수 -> 16진수
        // int n;
        //Integer.toHexString(n);

