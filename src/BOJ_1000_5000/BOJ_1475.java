package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1475 {
    // 방 번호
    // 입력받은 방 번호를
    // 최소 몇 개의 세트로 완성할 수 있는가 ?
    // 9는 6을 뒤집어서 표현할수 있다.
    // 나머지 숫자는 1세트에 1개씩 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in) );
        String input = br.readLine();
        int size = input.length();
        int [] count = new int[ 10 ];
        // 0~9까지의 개수를 셀 배열.

        int temp = 0;

        // '0' + 1 = '1'
        // '0' + k = 'k'
        // 숫자 k의 문자값에서 0의 문자값을 빼면 숫자 k 값이 나온다.
        for ( int i = 0; i < size; i++ ) {
            temp = input.charAt(i) - '0';
            count[temp]++;
        }
        //System.out.println(Arrays.toString( count ));
        // 6과 9는 뒤집어서 서로 같게 할 수 있다.
        // 따라서 9가 여러개 있어도 9와 6으로 대체할 수 있다.

        // 두 개수의 합이 짝수이면 그것의 절반만큼의 세트가 있으면 완성할 수 있다.
        int k  = count[6] + count[9];
        if ( k % 2 == 0 ) {
            count[6] = k / 2;
            count[9] = k / 2;
        }
        // 반면 홀수 일때는, 그것의 절반 값에 1을 더해주어야 한다.
        // 6이 2개 , 9가 3개라고 할 때, 2세트하고 1세트가 더 필요한 3세트가 필요할 것이다.
        // 그렇지만 합 5를 2로 나누면 정수인 2로 떨어지게 된다. 따라서 +1
        else {
            count[6] = k / 2 + 1;
            count[9] = k / 2 + 1;
        }
        // 0~9까지의 개수 중 최대값이 필요한 세트가 된다.
        int max = 0;
        for ( int i = 0; i < count.length; i++ ) {
            if ( max < count[i] )
                max = count[i];
        }
        //System.out.println(Arrays.toString( count ));
        System.out.print( max );
    }
}
