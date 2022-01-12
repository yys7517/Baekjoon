package BOJ_5000_10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
    // 토마토

    // 7576 번 토마토 문제와 유사.
    // 이 문제는 상자가 층을 지어 여러 개의 상자를 가지고 있음
    // 3차원 배열

    private static int M;
    private static int N;

    // 쌓아 올려지는 상자의 수 H
    private static int H;

    // M * N 의 상자가 H 개만큼 쌓아 올려져 있다.
    // private static int[][] box;
    private static int[][][] tomatoes;

    private static BufferedReader br;
    private static StringTokenizer st;

    static int[] dx = { 1, -1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, 1, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1 };

    // 좌표 값과 그 좌표 값에 해당하는 일 수.
    private static class Dot {
        int x;
        int y;
        int z;
        int day;

        public Dot( int x, int y, int z, int day ) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    private static Queue<Dot> queue;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader(System.in));
        st = new StringTokenizer( br.readLine(), " ");

        M = Integer.parseInt( st.nextToken() );
        N = Integer.parseInt( st.nextToken() );
        H = Integer.parseInt( st.nextToken() );

        // 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100

        // [ 면 ][ 행 ][ 열 ]
        tomatoes = new int[ H ][ N ][ M ];

        for (int k = 0; k < H ; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    tomatoes[ k ][ i ][ j ] = Integer.parseInt(st.nextToken());
                    //System.out.printf("%d ", tomatoes[k][i][j]);
                }
                //System.out.println();
            }
            //System.out.println();
        }
        // 모든 칸이 익어있는 토마토이거나 비어있는 칸이라면 0을 출력.
        if( checkTomatoBox( tomatoes ) ) {
            System.out.println( 0 );
            return;
        }
        // 익지 않은 토마토가 하나라도 있다면
        else {
            // 탐색 => 익은 것을 찾아서 인접한 익지 않은 토마토를 익게 하는 과정. 그래프 탐색과 유사.

            // 1. 탐색을 진행하여 모두 익을 때 까지 최소 일수를 구한다. (최소 일수 출력)
            // 2. 최소 일수를 구할 수 없을 경우, -1을 출력한다.

            queue = new LinkedList<>();

            for (int k = 0; k < H ; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        // 익은 토마토가 있는 칸에서 탐색이 시작.
                        if( tomatoes[k][i][j] == 1 )
                            queue.offer( new Dot( i, j, k, 0 ) );
                        // 탐색이 시작되는 지점이므로 0일
                        // System.out.printf("%d %d\n", i , j );
                    }
                }
            }

        }

        // 탐색 => 익은 것을 찾아서 인접한 익지 않은 토마토를 익게 하는 과정. 그래프 탐색과 유사.
        int day = BFS();

        // 탐색을 진행했음해도 불구하고,
        // 안 익은 토마토가 발견되면 -1을 출력.
        // 안 익은 토마토가 더 이상 없다면 ? 최소 일 수 출력.

        // checkTomatoBox 메서드
        // box에 익지 않은 토마토가 하나라도 있다면 false를 반환한다.
        // box에 토마토가 모두 익거나 비어있는 칸 이라면 true를 반환

        if ( checkTomatoBox( tomatoes ) )
            System.out.println( day );
        else
            System.out.println( -1 );

    }

    private static int BFS( ){
        int day = 0;

        while ( !queue.isEmpty() ) {
            Dot dot = queue.poll();
            day = dot.day;

            for( int i = 0; i < 6; i++ ) {
                int nx = dot.x + dx[i];     // 행 번호의 변화된 값. ( 0 <= nx < 세로길이 )
                int ny = dot.y + dy[i];     // 열 번호의 변화된 값. ( 0 <= ny < 가로길이 )
                int nz = dot.z + dz[i];

                if( nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H ) {  // 유효한 인덱스 범위
                    if( tomatoes[nz][nx][ny] == 0 ) {    // 이동할 값이 익지 않은 토마토일 때
                        tomatoes[nz][nx][ny] = 1;        // 익은 토마토로 변경
                        queue.add( new Dot( nx, ny, nz, day+1 ));
                        // 한 칸 이동하므로 이전 일 수에서 +1
                    }
                }
            }
        }
        return day;
    }

    // checkTomatoBox()
    // 상자 내에 안 익은 토마토가 있는 지 확인하는 메서드.
    private static boolean checkTomatoBox( int[][][] tomatoes ) {
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M ; j++) {
                    // 익은 토마토 -> 1
                    // 빈 칸 -> -1
                    // 익지 않은 토마토 -> 0

                    if( tomatoes[k][i][j] == 0 )
                        return false;
                }
            }
        }

        // 익지 않은 토마토가 없다면 위 for문에서 false를 return 하지 않고
        // true를 return할 것이다.
        return true;
    }



}
