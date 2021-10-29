import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_1259 {
    // 팰린드롬수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        StringBuilder result = new StringBuilder();
        int N;
        while ( (N = Integer.parseInt( br.readLine() )) != 0  ) {
            String input = String.valueOf(N);
            StringBuilder sb = new StringBuilder( input );
            //System.out.println( "input : " + input);

            //System.out.println( "right : " +sb );
            //System.out.println( "reverse : " +sb.reverse() );
            if ( sb.toString().equals( sb.reverse().toString() ))
                result.append("yes").append("\n");
            else
                result.append("no").append("\n");
        }
        System.out.println( result.toString() );
    }
}
