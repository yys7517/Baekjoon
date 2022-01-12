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
        // 함수 w는 1을 return하므로
        // 우리는 1 ~ 50의 인덱스만 필요로 한다.
        // 0 ~ 50
        arr = new int[ 51 ][ 51 ][ 51 ];

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



    // 메모이제이션 기법

    private static int w(int a, int b, int c) {

        if( a <= 0 || b <= 0 || c <= 0 )
            return 1;

        else if( a > 20 || b > 20 || c > 20 )
            return arr[20][20][20] = w(20,20,20);

        // 초기값 0이 아닐 경우, 값을 출력.
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

    private static boolean inRange( int a, int b, int c ) {
        if( a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20 )
            return true;

        return false;
    }
}
