import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798 {
    // 블랙잭
    // N 장의 카드 개수.
    // 3 장의 카드를 고름.
    // 3 장의 합이 M을 넘지 않으면서 M에 가장 가까운 값 을 출력.
    public static void main(String[] args) throws IOException {
        int N;      // 카드 개수.
        int M;      // 합. ( 합이 M을 넘지 말아야 함 )

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer NM = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());

        // System.out.println( "N : " + N);
        // System.out.println( "M : " + M);

        int[] cards = new int[N];
        int idx = 0;

        StringTokenizer cardstoken = new StringTokenizer(br.readLine(), " ");

        while (N-- > 0) {
            cards[idx] = Integer.parseInt(cardstoken.nextToken());
            idx++;
        }
        // System.out.println( "카드 전체의 합 : " + sum );
        // System.out.println( Arrays.toString(cards) );

        int result = 0;
        // result에 메서드 반환값.
        // 반환값이 0이면 M과 같은 값의 합을 못 찾았다.
        // 반환값이 있다면 M과 같거나 M과 차이 얼마 안나는 값..
        while (  ( result = solve( cards, M ) ) == 0  ) {
            M--;
            // M과 값은 값이 없으므로 M을 1씩 낮춰가면서 탐색 진행.
            // result가 0이 아니라면 반환 값이 있다는 것. while문 break.
        }

        System.out.println( result );

    }

    public static int solve ( int[] cards, int M ) {

        for ( int i = 0; i < cards.length - 2; i++ ) {
            for ( int j = i+1; j < cards.length -1; j++ ) {
                for ( int k = j+1; k < cards.length; k++ ) {
                    int cardsum = cards[i] + cards[j] + cards[k];
                    if ( cardsum == M )
                        return cardsum;
                }
            }
        }
        return 0;
    }


}

