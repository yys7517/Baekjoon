package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23627 {
    // driip 문자열이 포함되어 있다면 cute
    // 아니면 not cute 출력.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        String input = br.readLine();

        // driip로 끝나는지 확인.
        if ( input.endsWith("driip") )
            System.out.print("cute");
        else
            System.out.print("not cute");

    }
}