package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1459 {
    // 걷기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        StringTokenizer st = new StringTokenizer( br.readLine(), " ");
        int X = Integer.parseInt( st.nextToken() );
        int Y = Integer.parseInt( st.nextToken() );
        int W = Integer.parseInt( st.nextToken() ); // 한 블록을 가는데 걸리는 시간 W
        int S = Integer.parseInt( st.nextToken() ); // 한 블록을 대각선으로 가로지르는 시간 S


        long result = 0;     // 목적지 X,Y 까지 걸리는 최소 시간을 구해서 담을 변수 result
        long dist = X+Y;
        // 가로지르는 것 보다 두 블럭 이동하는 시간이 더 짧은 경우,
        if ( W * 2 < S ) {
            result += W * dist; // 한 블럭씩 이동하여 목적지에 도착한다.
        }
        // 가로지르는 시간이 더 짧은 경우
        else {
            // X 와 Y의 차이
            long diffXY = Math.abs( X-Y );

            if ( X > 0 && Y > 0 ) {
                long minXY = X < Y ? X : Y;
                result += minXY * S;        // X와 Y의 최소값 만큼, 대각선 위 방향으로 이동.
                long tmp1 = result;         // 경우의 수 1
                long tmp2 = result;         // 경우의 수 2

                // 경우의 수 1 : 대각선으로 이동한 후, 남은 거리를, 한 블록씩 이동하여 간다.
                tmp1 += diffXY * W;

                // 경우의 수 2 : 대각선으로 이동한 후, 남은 거리를, 가로지르는 것과, 한 블록씩 이동하는 것을
                // 섞어서 이동한다.

                // 남은 거리가 짝수일 경우, 대각선으로 가로질러서 이동하여도 된다.
                // 올라갔다 내려갔다 or 올라가기만 or 내려가기만.
                if ( diffXY % 2 == 0 ) {
                    tmp2 += diffXY * S;
                }
                // 홀수인 경우, 짝수 경우만큼 대각선으로 가로질러 이동한 후,
                // 나머지 1 블럭은 W로 이동한다.
                else {
                    tmp2 += ( diffXY - 1 ) * S + W ;
                }

                // 둘 중 최소값이 결과값이 된다.
                result = Math.min( tmp1, tmp2 );
            }
            else {  // X 또는 Y가 0일 때
                // 차이가 짝수일 때
                if ( diffXY % 2 == 0 ) {
                    result += diffXY * S;
                }
                // 차이가 홀수 일때
                else {
                    result +=  S * (diffXY - 1) + W;
                }
            }
        }
        System.out.print( result );
    }
}
