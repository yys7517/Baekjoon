package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1085 {
    // 직사각형에서의 탈출
    // 1 ≤ w, h ≤ 1,000
    // 1 ≤ x ≤ w-1
    // 1 ≤ y ≤ h-1
    // x, y, w, h는 정수
    // 왼쪽 아래 꼭짓점 ( 0,0 )
    // 오른쪽 위 꼭짓점 ( w,h )

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x,y;
        int w,h;

        // 문제좀 똑바로 읽자.

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int result = Math.min( Math.min(x, w-x) ,Math.min(h-y , y)  );

        System.out.println( result );
    }
}
