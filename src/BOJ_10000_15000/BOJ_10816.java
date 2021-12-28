package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816 {
    // 숫자 카드 2
    // N 개의 숫자카드 중 M 개의 숫자 카드를 찾는 문제
    // M 개의 숫자카드가 주어지는데
    // 이 M개의 숫자 카드가 있다면, 그 숫자 카드의 개수를 순서대로 출력하는 문제이다.

    // 해시맵과 이진 탐색을 활용하여 풀이할 수 있다.

    // 자바에서의 binarySearch 함수는 lower-bound (하한) 을 사용하는 이진 탐색을 사용한다.
    // 이 때, binarySearch 는 값이 존재한다면, 값의 인덱스 값을 반환하고, 존재하지 않는다면 음수 값을 반환한다.

    // 이 문제에서는 값이 존재하냐 ? 존재한다면 개수는 몇 개 인가? 를 구하는 문제이므로
    // 우리는 upper-bound(상한), lower-bound(하한)을 사용한 이진 탐색을 통하여 문제를 풀이할 수 있다.

    // lower-bound(하한)
    // 찾고자 하는 값을 key라고 할 때,
    // key 이상의 값이 처음으로 나타나는 위치를 lower-bound(하한) 이라고 한다.
    // 따라서 찾고자 하는 숫자 카드의 이상의 값이 처음으로 나타나는 위치이다.
    // 찾고자 하는 값이 있다면, 그 중복된 숫자 카드들 중 제일 첫 번째 위치를 lower-bound가 가리키게 되고,
    //             값이 없다면, 그 값 바로 다음 값을 가리키게 된다.


    // upper-bound(상한)
    // 찾고자 하는 값을 key라고 할 때,
    // key값을 초과하는 값이 처음으로 나타나는 위치를 upper-bound(상한) 이라고 한다.
    // 따라서 찾고자 하는 숫자 카드의 초과의 값이 처음으로 나타나는 위치이다.

    // 찾고자 하는 key값이 있든 없든, 그 key 값을 초과하는 처음 값을 가리키게 된다.

    // 따라서 우리는 찾고자 하는 key값인 숫자 카드의 개수를 (상한-하한)을 사용하여 구할 수 있다.
    // 값이 없다면, 하한과 상한은 같은 위치를 가리키게 된다. ( lower-bound == upper-bound )

    // 이 원리를 사용하여 이진 탐색을 사용해보자.


    private static StringBuilder result = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        // 1. 해시맵을 활용한 풀이.
        /*
        // HashMap cards< 값, 개수 >
        HashMap<String, Integer> cards = new HashMap<>();

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
//            count = cards.get(find);    // 개수
//                    // 찾는 숫자 카드가 있다면 ? 개수를 추가.
//            if (count != null)
//                result.append(count).append(" ");
//            else    // 찾는 숫자 카드가 없다면 ? 개수가 0이라고 하고 추가.
//                result.append(0).append(" ");

            // getOrDefault 메소드를 활용.
            // key에 따른 value 값이 있다면, 가져오고, 없다면 defaultValue값을 반환하는 함수이다.

            // 즉, 찾는 숫자 카드(find)가 있다면, 개수를 가져오고, 없다면 기본 값인 0의 개수 값을 반환한다.
            result.append( cards.getOrDefault( find, 0 ) ).append(" ");
        }
         */

        // 2. 이진 탐색을 사용한 풀이 ( lower-bound , upper-bound )

        int N = Integer.parseInt( br.readLine() );
        int [] cards = new int[ N ];
        StringTokenizer token1 = new StringTokenizer( br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt( token1.nextToken() );
        }

        Arrays.sort( cards );   // 이진 탐색을 하기 전 미리 정렬을 하여야 한다.

        int M = Integer.parseInt( br.readLine() );
        StringTokenizer token2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int find = Integer.parseInt( token2.nextToken() );
//            System.out.println( Arrays.toString( cards ) );
//            System.out.println(upperBound( cards , find ) );
//            System.out.println(lowerBound( cards , find ));
            result.append( upperBound( cards , find ) - lowerBound( cards , find ) ).append(" ");
        }

        System.out.println(result);
    }
    // lowerBound

    // 찾고자 하는 값을 key라고 할 때,
    // key 이상의 값이 처음으로 나타나는 위치를 lower-bound(하한) 이라고 한다.
    // 따라서 찾고자 하는 숫자 카드의 이상의 값이 처음으로 나타나는 위치이다.
    // 찾고자 하는 값이 있다면, 그 중복된 숫자 카드들 중 제일 첫 번째 위치를 lower-bound가 가리키게 되고,
    //             값이 없다면, 그 값 바로 다음 값을 가리키게 된다.

    // 하한 값을 찾는 메서드이므로, 가장 왼쪽에 있는 key 값을 찾아야 한다.
    // 그러므로 상한선을 내려야 한다.
    private static int lowerBound( int[] arr, int key ) {
        int lo = 0;
        int hi = arr.length;

        while ( lo < hi ) {
            int mid = ( lo + hi ) / 2;

            // 오버플로우 방지.
            // int mid = lo + ( ( hi - lo ) / 2 );
            // 중간 값 = 시작점 + ( 거리 차 / 2 )
            // 중간 지점은 시작점으로 부터 거리차의 절반 만큼 간 지점이다.
            /*
             * key의 값이 중간위치보다 작거나 같을 경우
             * 왼쪽으로 탐색하기 위해 상한 값을 내린다.
             * 상한 값을 내리게 되면, mid값이 점점 왼쪽으로 가게 된다. ( 작아진다. )
             */
            if ( key <= arr[mid] ) {
                hi = mid;
            }
            else    // key값이 mid값보다 클 경우 ? 키 값보다 작은 값으로 온 것이다.
                lo = mid + 1; // 다시 오른쪽으로 탐색해야 한다.
        }   // lo 값이 hi값보다 같아지거나 커지면 while문이 종료.

        return lo;
    }

    // upperBound

    // 상한 값을 찾는 메서드이므로, key값의 가장 오른쪽에 있는 다음 값을 찾아야 한다.
    // 따라서 하한 값을 올려줘야 한다.
    private static int upperBound( int[] arr, int key ) {
        int lo = 0;
        int hi = arr.length;

        while ( lo < hi ) {
            int mid = ( lo + hi ) / 2;

            // 오버플로우 방지.
            //int mid = lo + ( ( hi - lo ) / 2 );
            // 중간 값 = 시작점 + ( 거리 차 / 2 )
            // 중간 지점은 시작점으로 부터 거리차의 절반 만큼 간 지점이다.
            /*
             * key의 값의 상한 값을 구하는 것이다.
             * 따라서 key의 값이 중간 값보다 작을 경우
             * 중간 값은 상한 값이 될 수 있다.
             */
            if( key < arr[mid] ) {
                hi = mid;
            }
            // key의 값이 중간값보다 크거나 같을 경우.
            // 상한 값을 찾기 위해 오른쪽으로 탐색한다.
            // 하한 값을 올려준다.
            else {
                lo = mid + 1;
            }
        }

        return hi;
    }
}
