package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_10757 {
    public static void main(String[] args) throws IOException {
        // 큰 수 A+B
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in) );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger A = new BigInteger( st.nextToken() );
        BigInteger B = new BigInteger( st.nextToken() );

        System.out.println( A.add(B) );

    }
}
