package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        long N = Integer.parseInt( br.readLine() );
        long sum = 0 ;
        StringBuilder sb = new StringBuilder( String.valueOf( N ) );
        int length = sb.length();

        int start = 0;
        while ( start != length ) {
            sb = new StringBuilder(sb.charAt(length - 1) + sb.substring(0,length-1));
            // System.out.println(sb);
            sum += Integer.parseInt( sb.toString() );
            start++;
        }

        System.out.println(sum);
    }
}
