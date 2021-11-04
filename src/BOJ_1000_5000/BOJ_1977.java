package BOJ_1000_5000;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int M = sc.nextInt();
        int N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        int start = (int)Math.sqrt(M);
        int end = (int) Math.sqrt(N);
        // M 이 제곱근부터 시작할 경우에 그 M의 값도 list에 추가해주어야 한다.
        // N이 99이면 end의 값은 (int) 9.xxxxxxx
        // 10의 제곱근인 100은 포함이 안되므로 i <= end까지 이다.
        if ( M == start ) {
            for ( int i = start; i <= end; i++ ) {
                list.add ( i * i );
            }
        }
        // N이 60이면
        // 60의 제곱근의 값보다 M이 더 크게 된다.
        // 그럴 때는 start의 값부터 해버리면
        // 60보다 더 작은 제곱근인 7부터 하게 되므로 시작이 60인데, 시작을 49로 하게된다.
        // 따라서 +1을 준 값을 시작으로 한다.
        // 10의 제곱근인 100은 포함이 안되므로 i <= end까지 이다.

        else if ( M > start ) {
            for ( int i = start + 1; i <= end; i++ ) {
                list.add( i * i );
            }
        }

        // 리스트의 합.
        int sum = 0;
        for ( Integer value : list )
            sum += value;

        // 리스트가 비어있다면,, 제곱근이 없다는 뜻.
        // -1을 출력.
        if ( list.isEmpty() ) {
            System.out.println(-1);
        }
        // 리스트가 비어있지 않다면, 합과 제곱근 중 가장 작은 수를 출력.
        // 왜 첫 번째 리스트의 값을 출력하냐 ? for문으로 순서대로 값을 집어넣기 때문에, 제일 처음에 들어왔던 값이
        // 제일 작은 최소 제곱근이 된다.
        else {
            System.out.println( sum );
            System.out.println( list.get(0) );
        }

    }
}
