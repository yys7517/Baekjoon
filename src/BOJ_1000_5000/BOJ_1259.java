package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_1259 {
    // 팰린드롬수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        StringBuilder result = new StringBuilder();
        int N;      // 입력받을 정수값.
        while ( (N = Integer.parseInt( br.readLine() )) != 0  ) {   // 입력받는 정수값이 아니면 while문 동작.
            String input = String.valueOf(N);                       // Integer.parseInt한 이유는 앞에 0이 붙은 입력값을 제거하기 위함
            // String으로 다시 변환.
            StringBuilder sb = new StringBuilder( input );
            //System.out.println( "input : " + input);

            //System.out.println( "right : " +sb );
            //System.out.println( "reverse : " +sb.reverse() );
            // 정방향으로 읽는것과 거꾸로 읽었을 때의 값이 동일하면 yes, 팰린드롬수.
            if ( sb.toString().equals( sb.reverse().toString() ))
                result.append("yes").append("\n");
            else
                result.append("no").append("\n");
        }
        System.out.println( result.toString() );
    }
}
