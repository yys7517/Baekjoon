package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1316 {
    // 그룹 단어 체커
    // 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고,
    // kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
    // aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt( br.readLine() );

        int count = 0;  // 그룹 단어의 개수.
        for (int i = 0; i < N; i++) {
            if ( GroupCheck( br.readLine() ) )
                count++;
        }

        System.out.println( count );
    }

    private static boolean GroupCheck( String word ) {
        // 단어의 길이가 1일 때와 2일 때는 다 그룹단어로 인정한다.
        if ( word.length() == 1 || word.length() == 2 )
            return true;
        else {  // 길이가 1과 2보다 클 때

            // 사용된 알파벳들을 담는 리스트
            ArrayList<Character> used = new ArrayList<>();

            // 첫 알파벳을 tmp에 넣는다.
            char tmp = word.charAt( 0 );

            // 그 다음 알파벳부터 단어 끝 알파벳까지 반복한다.
            for (int i = 1; i < word.length(); i++) {
                // 만약 이전 알파벳과 다르고, 사용되지 않았던 알파벳일 경우에
                if( tmp != word.charAt(i) && !used.contains( word.charAt(i) ) ) {
                    used.add( tmp );        // 이전 알파벳을 사용된 알파벳으로 취급.
                    tmp = word.charAt(i);   // 임시공간에 새로운 알파벳으로 초기화.
                }
                else if ( used.contains(word.charAt(i)) )   // 사용된 알파벳이 또 사용이 된다면.
                    return  false;                          // 그룹 단어가 아니므로 false를 반환.
            }
            // 위 반복문을 무사히 통과하였다면 그룹단어이므로 true 반환.
            return true;
        }

    }
}
