import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23027 {
    // A가 있다면, B,C,D,F를 A로바꾸자.
    // A가 없고, B가 있다면 C,D,F를 B로 바꾸자.
    // A가 없고, B도 없고, C가 있다면 D,F를 C로 바꾸자.
    // A,B,C가 없으면 모든 글자를 A로 바꾸자.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        StringBuilder sb  = new StringBuilder( br.readLine() );
        int length = sb.length();
        StringBuilder result = new StringBuilder("");
        if ( sb.indexOf("A") != -1 ) {
            for (int i = 0; i < length; i++) {
                if ( sb.charAt(i) == 'B' || sb.charAt(i) == 'C' || sb.charAt(i) == 'D' || sb.charAt(i) == 'F')
                    result.append("A");
                else
                    result.append(sb.charAt(i));
            }
        }
        else if ( sb.indexOf("A") == -1 && sb.indexOf("B") != -1 ) {
            for (int i = 0; i < length; i++) {
                if ( sb.charAt(i) == 'C' || sb.charAt(i) == 'D' || sb.charAt(i) == 'F')
                    result.append("B");
                else
                    result.append(sb.charAt(i));
            }
        }
        else if ( sb.indexOf("A") == -1 && sb.indexOf("B") == -1 && sb.indexOf("C") != -1) {
            for (int i = 0; i < length; i++) {
                if ( sb.charAt(i) == 'D' || sb.charAt(i) == 'F')
                    result.append("C");
                else
                    result.append(sb.charAt(i));
            }
        }
        else if (sb.indexOf("A") == -1 && sb.indexOf("B") == -1 && sb.indexOf("C") == -1 ) {
            for (int i = 0; i < length; i++) {
                result.append("A");
            }
        }
        System.out.println(result);
    }
}
