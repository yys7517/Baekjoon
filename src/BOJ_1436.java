import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 666, 1666, 2666, 3666, 4666, 5666, 6660, 6661, 6662, ⋯, 6669, 7666, 8666, 9666, ⋯
5666 다음 6666이 아니라 6660 부터 시작해야한다.

5자릿수도 마찬가지다.
10666, 11666, 12666, 13666, 14666, 15666, 16660, 16661, 16662, ⋯, 16669, 17666, ⋯
즉, 5자리 수에서도 4자수의 구간을 똑같이 반복하는 식이다.

다만 5자릿수의경우는 경우의 수가 더 추가된다. 바로 5번째 자릿수가 6일 경우, 즉 아래와 같을경우도 생각해야한다.
60666, 61666, 62666, 63666, 64666, 65666, 66600, 66601, ⋯, 66659, 66660, ⋯

 */
public class BOJ_1436 {
    // 영화감독 숌
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int N = Integer.parseInt( br.readLine() );

        int count = 1;
        int num = 666;

        while ( count != N ) {
            num++;
            if ( String.valueOf( num ).contains("666") )
                count++;
        }
        System.out.println( num );

    }
}
