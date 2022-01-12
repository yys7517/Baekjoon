package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    // 숨바꼭질

    // 수빈이는 N 위치에 있고
    // 동생은 K 위치에 있다.

    // 수빈이의 위치를 X라고 할 때, 수빈이는 1초 후에 X-1 또는 X+1 또는 2*X의 위치로 이동.

    // 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간을 구하시오.
    // 몇 초 후?

    static int N;   // 수빈이 위치
    static int K;   // 동생 위치

    // N = 5

    // 정점 5는 정점 4, 6, 10과 연결되어 있다.
    // 정점 4는 정점 3, 5, 8과 연결되어 있다.

    static BufferedReader br;

    static boolean [] visited;

    // 위치에 따른 시간 값을 저장할 수 있는 자료형 Dot
    static class Dot {
        int loc;
        int time;

        public Dot( int loc, int time ) {
            this.loc = loc;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));

        StringTokenizer st;
        st = new StringTokenizer( br.readLine(), " ");

        N = Integer.parseInt( st.nextToken() );
        K = Integer.parseInt( st.nextToken() );

        visited = new boolean[ 100001 ];

        // 시작 지점 N, 시작 시간 0으로
        // BFS 실행.
        int result = BFS( N,0 );

        System.out.println( result );
    }

    // 시작 지점 V, 시작 시간 t
    // BFS 메서드
    private static int BFS( int V, int t ) {
        Queue<Dot> q = new LinkedList<>();

        // 시작 구간 처리
        q.add( new Dot( V,t ) );
        visited[ V ] = true;

        while ( !q.isEmpty() ) {
            Dot dot = q.poll();
            int loc = dot.loc;
            int time = dot.time;

            // 지점이 K일 때, K 위치에 갈 수 있는 시간 값 return 하고 함수 종료.
            if( loc == K )
                return time;

            // nv : 현재 위치 v에서 갈 수 있는 경우의 수 3가지
            int [] nv = new int[3];
            nv[0] = loc-1;
            nv[1] = loc+1;
            nv[2] = loc*2;

            for (int i = 0; i < 3; i++) {
                if( nv[i] >= 0 && nv[i] <= 100000 ) {
                    if ( visited[ nv[i] ] == false ) {
                        visited[ nv[i] ] = true;
                        q.add( new Dot( nv[i], time+1 ) );
                    }
                }
            }
        }
        return 0;
    }
}
