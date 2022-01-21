package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2960 {
    // 에라토스테네스의 체

    // 에라토스테네스의 체 알고리즘을 사용하여

    // 1. 2부터 N까지 모든 정수를 적는다.
    // 2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
    // 3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
    // 4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
    // N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.

    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer( br.readLine(), " ");

        int N = Integer.parseInt( token.nextToken() );
        int K = Integer.parseInt( token.nextToken() );

        ArrayList<Integer> list = new ArrayList<>();        // 2 이상 N 이하의 모든 정수를 담는 list
        ArrayList<Integer> removeList = new ArrayList<>();  // 지워진 값을 담는 removelist

        for (int i = 2; i <= N ; i++) {
           list.add( i );
        }

        // 리스트에 값이 있을 때까지 반복한다.
        while ( !list.isEmpty() ) {
            int P = Collections.min( list );        // 가장 작은 값을 P라고 한다, P는 소수이다.
            removeList.add( list.remove( list.indexOf( P ) ) ); // P의 값을 지우고 반환한 값을 소수 리스트에 추가. 지워지는 수는 P, 소수.

            // 리스트 안에 있는 P의 배수 중 작은 값부터 지운다.
            for (int i = 0; i < list.size(); i++) {
                // 리스트를 돌면서 만난 값이 P로 나눠지면 ?
                if( list.get(i) % P == 0 ) {
                    removeList.add( list.remove(i) );
                }
            }
        }

        System.out.println( removeList.get( K - 1 ) );

    }
}
