package BOJ_5000_10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9184 {
    // 신나는 함수 실행

    /*
    다음과 같은 재귀함수 w(a, b, c)가 있다.

    if a <= 0 or b <= 0 or c <= 0,
    then w(a, b, c) returns : 1

    if a > 20 or b > 20 or c > 20,
    then w(a, b, c) returns : w(20, 20, 20)

    if a < b and b < c,
    then w(a, b, c) returns : w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)

    otherwise it
    returns:
    w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
     */

    // 메모이제이션 기법 ?

    static int a ;
    static int b ;
    static int c ;

    static BufferedReader br;
    static StringBuilder result = new StringBuilder();

    static int arr[][][];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));
        StringTokenizer st;

        // 수가 0이하인 수가 하나라도 있을 경우
        // 함수 w는 1을 return 하고
        // 20을 초과하는 수가 하나라도 있을 경우 w(20,20,20)을 호출하므로
        // a,b,c가 0 ~ 20의 값을 만족할 때 의 값만 저장하여 사용한다.
        arr = new int[ 21 ][ 21 ][ 21 ];

        while ( true ) {
            st = new StringTokenizer( br.readLine() , " ");
            a = Integer.parseInt( st.nextToken() );
            b = Integer.parseInt( st.nextToken() );
            c = Integer.parseInt( st.nextToken() );

            if (a == -1 && b == -1 && c == -1)
                break;

            int ret = w(a,b,c);

            result.append( String.format("w(%d, %d, %d) = ",a,b,c) ).append(ret).append("\n");
        }

        System.out.println( result.toString().trim() );
    }



    // 메모이제이션 기법 ( 동적계획법 )

    // 처음방문하는 재귀라면 계산을 통해 얻은 값을 메모리에 저장하고,
    // 이 후 재방문을 할 경우, 계산을 다시 하지 않고 메모리에 저장된 값을 사용하는 것.

    private static int w(int a, int b, int c) {

        if( a <= 0 || b <= 0 || c <= 0 )
            return 1;

        // 하나라도 20을 초과할경우, w(20,20,20)을 호출하게 되므로,
        // 배열 w(20,20,20)의 값 까지만 우리는 저장하면 된다.
        // 따라서 배열 arr의 마지막 값은 arr[20][20][20]이 되므로
        else if( a > 20 || b > 20 || c > 20 )
            return arr[20][20][20] = w(20,20,20);

        // 초기화된 arr의 기본 값인 0이 아닌 어떤 값이 있고,
        // a,b,c의 범위가 0 <= a,b,c <= 20 이라면 메모리에 저장된 값을 반환한다.
        else if( inRange(a,b,c) && arr[a][b][c] != 0 )
            return arr[a][b][c];

        else if( a < b && b < c )
            return arr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);

        else
            return arr[a][b][c] = w(a-1, b, c)
                    + w(a-1, b-1, c)
                    + w(a-1, b, c-1)
                    - w(a-1, b-1, c-1);


    }

    // 0
    private static boolean inRange( int a, int b, int c ) {
        if( a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20 )
            return true;

        return false;
    }
}
