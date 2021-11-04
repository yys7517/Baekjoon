package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_23303 {
    // D2
    // D다음에 2가 붙어있으면 "D2"를 출력하자
    // 아니면 "unrated"를 출력.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        String input = br.readLine();

        boolean d2 = false;
        int idx = 0;

        while ( idx != input.length() - 1 ) {
            if ( input.charAt( idx ) == 'D' || input.charAt( idx ) == 'd') {
                if ( input.charAt( idx + 1 ) == '2' ) {
                    d2 = true;
                    break;
                }
                else {
                    idx++;
                    continue;
                }
            }
            else
                idx++;
        }
        if ( d2 )
            System.out.print("D2");
        else
            System.out.print("unrated");
    }
}
