package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        String input = br.readLine();
        int length = input.length();

        StringBuffer result = new StringBuffer("");

        /*
        ‘В’는 ‘B’처럼 보이지만 ‘v’로 읽는다.
        ‘Е’는 ‘E’처럼 보이지만 ‘ye’로 읽는다.
        ‘Н’은 ‘H’처럼 보이지만 ‘n’으로 읽는다.
        ‘Р’은 ‘P’처럼 보이지만 ‘r’으로 읽는다.
        ‘С’는 ‘C’처럼 보이지만 ‘s’로 읽는다.
        ‘У’는 ‘Y’처럼 보이지만 ‘u’로 읽는다.
        ‘Х’는 ‘X’처럼 보이지만 ‘h’로 읽는다.
         */

        for (int i = 0; i < length; i++) {
            char tmp = input.charAt(i);
            switch ( tmp )  {
                case 'B' :
                    result.append("v");
                    break;
                case 'E' :
                    result.append("ye");
                    break;
                case 'H' :
                    result.append('n');
                    break;
                case 'P' :
                    result.append('r');
                    break;
                case 'C' :
                    result.append('s');
                    break;
                case 'Y' :
                    result.append('u');
                    break;
                case 'X' :
                    result.append('h');
                    break;
                default:
                    // 아스키코드 값을 32만큼 더하면 대문자 -> 소문자 변환.
                    tmp = (char)( tmp+32 );
                    result.append( tmp );
                    break;
            }
        }

        System.out.print( result );
    }
}
