package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23080 {
    // 스키테일 암호
    // 문자열을 K개마다 끊고 첫글자만 따서 출력한다.
    // K = 3이라고 한다면.
    // 인덱스를 기준으로
    // 012 -> 0번 인덱스 값 출력
    // 345 -> 3번 인덱스 값 출력
    // 678 -> 6번 인덱스 값 출력..
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
