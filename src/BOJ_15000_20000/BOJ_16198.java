package BOJ_15000_20000;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_16198 {
    // 에너지 모으기
    // X 번째 구슬을 제거하고, X-1 , X+1 번째 구슬의 무게 곱 만큼 에너지를 얻는다.
    // 구슬의 개수와, 각 구슬의 무게를 입력할 때,
    // 모을 수 있는 에너지의 최대 값을 출력.

    private static Scanner sc = new Scanner(System.in);
    private static int N = sc.nextInt();
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            list.add( sc.nextInt() );
        }
        int sum = 0;
        while ( N > 2 ) {
            sum += solution(1);
        }
        System.out.println( sum );
    }
    private static int solution (int x) {
        int sum = list.get( x-1 ) * list.get( x+1 );
        list.remove( x );
        N--;
        return sum;
    }
}
