package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2309 {
    // 일곱 난쟁이..
    // 아홉 난쟁이의 키가 주어졌을 때,
    // 일곱 난쟁이를 찾아서 출력하라.
    // 일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.
    // 일곱 난쟁이들의 키의 합은 100이다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int tmp = Integer.parseInt( br.readLine());
            list.add( tmp );
            sum += tmp;
        }

        // System.out.println( list );
        // System.out.println( sum );
        // 아홉 난쟁이들의 키의 합을 구하고, 아홉 난쟁이의 키의 합 - 100 = 일곱 난쟁이를 제외한 두 난쟁이들의 키의 합.
        // 두 난쟁이들의 키의 합을 두 난쟁이가 만족하는 경우의 수를 구하자.
        // 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
        // 두 난쟁이를 제외한 일곱 난쟁이의 키를 오름차순으로 출력.

        int twosum = sum - 100;
        int listsize = list.size();


        loop : for (int i = 0; i < listsize - 1; i++) {
            for (int j = i+1; j < listsize ; j++) {
                if ( list.get(i) + list.get(j) == twosum ) {
                    list.remove(i);             // list의 i번째 요소를 지웠기 때문에
                    list.remove(j-1);    // list의 j번째 값은 1칸 앞으로 당겨져 있으므로 j-1번째 요소를 삭제.
                    break loop;
                }
            }
        }
        // list 오름차순 정렬
        Collections.sort( list );

        // 출력
        for ( int value : list ) {
            System.out.println( value );
        }

    }
}
