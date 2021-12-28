package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816 {
    // 숫자 카드 2
    // N 개의 숫자카드 중 M 개의 숫자 카드를 찾는 문제
    // M 개의 숫자카드의 인덱스 번호를 출력.

    // 해시를 활용한 풀이

    // HashMap cards< 값, 개수 >

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> cards = new HashMap<>();
        StringBuilder result = new StringBuilder();

        // 입력
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token1 = new StringTokenizer(br.readLine(), " ");
        String input;       // 입력 값.

        for (int i = 0; i < N; i++) {
            input = token1.nextToken();
            // 입력 값의 개수가 없다면, 1로 초기화.
            if (cards.get(input) == null)
                cards.put(input, 1);
            else    // 입력 값이 있는 값이라면, 중복된다면 개수를 증가시켜줌.
                cards.put(input, cards.get(input) + 1);
        }


        int M = Integer.parseInt(br.readLine());
        StringTokenizer token2 = new StringTokenizer(br.readLine(), " ");
        String find;            // 찾는 값.
        Integer count;          // 찾는 값 개수.

        for (int i = 0; i < M; i++) {
            find = token2.nextToken();  // 찾는 숫자 카드
            count = cards.get(find);    // 개수
                    // 찾는 숫자 카드가 있다면 ? 개수를 추가.
            if (count != null)
                result.append(count).append(" ");
            else    // 찾는 숫자 카드가 없다면 ? 개수가 0이라고 하고 추가.
                result.append(0).append(" ");
        }

        System.out.println(result);
    }
}
