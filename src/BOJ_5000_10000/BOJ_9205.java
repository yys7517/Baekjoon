package BOJ_5000_10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
    // 맥주 마시면서 걸어가기

    static int t;
    static int n;

    static BufferedReader br;
    static StringBuilder sb;

    static class Dot{
        int x;
        int y;

        public Dot( int x, int y ) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Dot> queue;

    static Dot[] dots;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));
        sb = new StringBuilder();

        t = Integer.parseInt( br.readLine() );  // 테스트 케이스의 수

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt( br.readLine() );  // 편의점 수

            dots = new Dot[ n+2 ];
            visited = new boolean[ n+2 ];

            StringTokenizer st;

            // 상근이 집, 페스티벌, 편의점 수 n 줄 만큼 입력.
            for (int j = 0; j < n+2 ; j++) {
                st = new StringTokenizer( br.readLine(), " ");
                int x = Integer.parseInt( st.nextToken() );
                int y = Integer.parseInt( st.nextToken() );

                dots[j] = new Dot( x,y );   // 지점 목록에 저장.
            }

            Dot start = dots[0];                // 상근이 집
            Dot end = dots[ dots.length - 1  ]; // 페스티벌


            if( BFS( start , end ) )
                sb.append("happy").append("\n");
            else
                sb.append("sad").append("\n");
        }

        System.out.println( sb.toString().trim() );
    }

    // start에서 시작하여 end까지 탐색이 성공하면 true
    // 아니면 false를 반환하는 BFS 메서드
    private static boolean BFS( Dot start, Dot end ) {
        queue = new LinkedList<>();

        queue.add( start );
        visited[0] = true;                  // 0번째 지점은 출발지로 가정. 출발지 방문처리.

        while ( !queue.isEmpty() ) {
            Dot current = queue.poll(); // 현재 지점

            // 지점이 끝 지점( == 페스티벌 )이면 탐색 성공.
            if( current.equals( end ) )
                return true;

            // 인덱스 0인 지점은 출발점( == 상근이 집 )이므로
            for (int i = 1; i < n+2 ; i++) {
                if( visited[i] == false && Manhatten( dots[i] , current ) ) {
                    queue.add( dots[i] );
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    // 맨해튼거리 ==> 두 지점의 x좌표 값 차이와 y좌표 값 차이의 합이 두 지점의 거리가 된다.
    private static boolean Manhatten( Dot d1, Dot d2 ) {
        if( Math.abs( d2.x - d1.x ) + Math.abs( d2.y - d1.y ) <= 1000 )
            return true;
        else
            return false;
    }

}
