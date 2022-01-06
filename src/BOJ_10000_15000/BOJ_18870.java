package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18870 {
    // 좌표 압축

    private static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt( br.readLine() );
        StringTokenizer token = new StringTokenizer(br.readLine()," ");

        int [] arr = new int[N];
        HashMap< Integer, Integer > map = new HashMap<>();

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken() );

        // arr = [ 2, 4, -10, 4, -9 ]
        int [] tmp = Arrays.copyOfRange( arr , 0, arr.length );
        // arr 의 0번 인덱스부터 arr.length -1 인덱스까지 복사.



        // 순위 정하기

        // 가장 작은 값이 순위가 높다. 가장 높은 순위 = 0
        // 중복된 값은 같은 순위를 갖는다. HashMap을 활용하여 하나의 값이 같은 순위를 갖게 한다.

        Arrays.sort( arr );
        // arr = [ -10, -9, 2, 4, 4 ]

        // arr를 오름차순 정렬하게 되면, 가장 앞에 있는 값부터 순위가 0부터 매겨지게 된다.

        int rank = 0;
        for (int i = 0; i < arr.length; i++) {
            // HashMap에 그 값에 대한 순위 정보가 없을 때 ?
            // 중복된 값이 나오게 된다면 if문에 걸리지 않게 된다. 그 값을 key로 한 정보가 map에 있으므로.
            if( ! map.containsKey(arr[i]) ) {
                map.put( arr[i], rank );
                rank++;     // 다음에 올 값을 위해 순위 값을 증가시켜준다.
            }
        }

        for( int value : tmp )
            sb.append( map.get(value) ).append(" ");


        System.out.println( sb );
    }
}
