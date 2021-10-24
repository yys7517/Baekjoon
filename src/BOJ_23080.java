import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23080 {
    // 스키테일 암호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt( br.readLine() );
        StringBuilder sb = new StringBuilder( br.readLine() );
        int length = sb.length();

        for ( int i = 0; i < length; i++ ) {
            if ( i % K == 0 ) {
                System.out.print( sb.charAt(i) );
            }
        }
    }
}
