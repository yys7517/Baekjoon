package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_22351 {

    private static BufferedReader br;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));
        sb = new StringBuilder( br.readLine() );

        // 한 자리 수 ?
        // 1 -> 1 1
        // 2 -> 2 2
        // 3 -> 3 3
        if( sb.length() == 1 )
            System.out.printf("%s %s", sb, sb );

        // 12 -> 1 2
        // 23 -> 2 3
        // 14 -> 14 14
        else if( sb.length() == 2 ) {
            char A = sb.charAt(0);
            char B = sb.charAt(1);
            if( B-A == 1 )
                System.out.printf("%c %c",A,B);
            else
                System.out.printf("%s %s",sb,sb);
        }

        else {
            // 998 -> 998 998
            boolean diff = false;   //

            char A = sb.charAt(0);

            for (int i = 1; i < sb.length(); i++) {
                if( sb.charAt(i) != A ) {
                    diff = true;
                    break;
                }
            }
            // 모든 자릿수가 같다면 ?
            // 모든 자릿수가 같을 때는 그 자체의 덧셈
            // 999 -> 999 999
            if( !diff )
                System.out.println( sb + " " + sb );

            else {
                StringBuilder res = new StringBuilder();

                for (int i = 1; i <= 999 ; i++) {
                    // 입력받은 값 sb가 i값으로 시작한다면 ?
                    if( sb.toString().startsWith( Integer.toString(i) ) ) {
                        String str = sb.toString();
                        for (int j = i; j <= 999 ; j++) {
                            if( str.startsWith( Integer.toString(j) ))
                                str = str.substring( Integer.toString(j).length() );
                            // j값의 길이 값부터 substring을 하면, 그 j값을 제외한 뒷 부분이 str로 들어오게 되고
                            // j값까지는 잘린다.
                            // 그러면 j까지는 잘렸으므로 다음 수도 검사할 수 있다.

                            else    // 수가 999 범위 내의 수에 포함되지 않으면
                                break;

                            // substr과정을 반복하다보면, str은 아무것도 남지 않게된다.
                            // 그 때 결과 값에 시작값과 마지막 값을 공백을 사이에 두고 삽입해준다.
                            if( str.length() == 0 ) {
                                res.append(i).append(" ").append(j);
                                break;
                            }
                        }
                        if( res.length() != 0 )
                            break;
                    }
                }

                System.out.println( res );
            }

        }

    }
}
