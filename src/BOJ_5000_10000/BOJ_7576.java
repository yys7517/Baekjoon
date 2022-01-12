package BOJ_5000_10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    // 토마토

    // 토마토는 잘 익은 것과 익지 않은 것으로 구분된다.
    // 하루가 지나면 익지 않은 토마토는 익은 토마토의 영향을 받아 익게 된다.
    // 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.


    // 상자의 가로 칸의 수 M, 세로 칸의 수 N
    // 2 ≤ M,N ≤ 1,000

    // 토마토의 상태
    // 1 -> 익은 토마토
    // 0 -> 익지 않은 토마토
    // -1 -> 토마토가 들어있지 않은 칸

    // 전체 토마토들이 모두 익는 최소 일수를 구하라.
    // 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
    // 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

    private static int M;
    private static int N;

    private static int[][] box;

    private static BufferedReader br;
    private static StringTokenizer st;

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    // 좌표 값과 그 좌표 값에 해당하는 일 수.
    private static class Dot {
        int x;
        int y;
        int day;

        public Dot( int x, int y, int day ) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    private static Queue<Dot> queue;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader(System.in));
        st = new StringTokenizer( br.readLine(), " ");

        M = Integer.parseInt( st.nextToken() );
        N = Integer.parseInt( st.nextToken() );

        box = new int[ N ][ M ];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer( br.readLine() , " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt( st.nextToken() );

                // System.out.printf("%d ", box[i][j]);
            }
            // System.out.println();
        }
        // 모든 칸이 익어있는 토마토이거나 비어있는 칸이라면 0을 출력.
        if( checkTomatoBox( box ) ) {
            System.out.println( 0 );
            return;
        }
        // 익지 않은 토마토가 하나라도 있다면
        else {
            // 탐색 => 익은 것을 찾아서 인접한 익지 않은 토마토를 익게 하는 과정. 그래프 탐색과 유사.

            // 1. 탐색을 진행하여 모두 익을 때 까지 최소 일수를 구한다. (최소 일수 출력)
            // 2. 최소 일수를 구할 수 없을 경우, -1을 출력한다.

            queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 익은 토마토가 있는 칸에서 탐색이 시작.
                    if( box[i][j] == 1 )
                        queue.offer( new Dot(i,j,0) );
                    // 탐색이 시작되는 지점이므로 0일
                    // System.out.printf("%d %d\n", i , j );
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

            if ( checkTomatoBox( box ) )
                System.out.println( day );
            else
                System.out.println( -1 );

        }

    private static int BFS( ){
        int day = 0;

        while ( !queue.isEmpty() ) {
            Dot dot = queue.poll();
            day = dot.day;

            for( int i = 0; i < 4; i++ ) {
                int nx = dot.x + dx[i];     // 행 번호의 변화된 값. ( 0 <= nx < 세로길이 )
                int ny = dot.y + dy[i];     // 열 번호의 변화된 값. ( 0 <= ny < 가로길이 )

                if( nx >= 0 && nx < N && ny >= 0 && ny < M ) {  // 유효한 인덱스 범위
                    if( box[nx][ny] == 0 ) {    // 이동할 값이 익지 않은 토마토일 때
                        box[nx][ny] = 1;        // 익은 토마토로 변경
                        queue.add( new Dot( nx, ny, day+1 ));
                        // 한 칸 이동하므로 이전 일 수에서 +1
                    }
                }
            }
        }
        return day;
    }
    /*
    private static int BFS( int i, int j ){
        int days = 0;

        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        xQueue.add( i );
        yQueue.add( j );

        while ( !xQueue.isEmpty() && !yQueue.isEmpty() ) {
            int x = xQueue.poll();
            int y = yQueue.poll();

            // ( 비어있는 칸이 아닐 경우 그 칸으로 이어서 탐색 )
            if( visited[x][y] == false && box[x][y] != -1 ) {
                // System.out.printf("%d %d\n", x,y );
                visited[x][y] = true;   // 방문 처리

                // 익지 않은 토마토 였다면 토마토가 익게 한다.
                if( box[x][y] == 0 )
                    box[x][y] = 1;

                // 상하좌우 인접 정점 값을 삽입.
                if( checkIdx(x-1,y) ) {
                    xQueue.add(x-1);
                    yQueue.add(y);
                }

                if( checkIdx(x+1,y) ) {
                    xQueue.add(x+1);
                    yQueue.add(y);
                }

                if( checkIdx(x,y+1) ) {
                    xQueue.add(x);
                    yQueue.add(y+1);
                }

                if( checkIdx(x,y-1) ) {
                    xQueue.add(x);
                    yQueue.add(y-1);
                }
            }
        }

        return days;
    }
     */


    // checkTomatoBox()
    // 상자 내에 안 익은 토마토가 있는 지 확인하는 메서드.
    private static boolean checkTomatoBox( int[][] box ) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M ; j++) {
                // 익은 토마토 -> 1
                // 빈 칸 -> -1
                // 익지 않은 토마토 -> 0

                // 익지 않은 토마토가 하나라도 있다면 탐색을 진행해야 한다.
                if( box[i][j] == 0 )
                    return false;
            }
        }
        // 익지 않은 토마토가 없다면 위 for문에서 false를 return 하지 않고
        // true를 return할 것이다.
        return true;
    }



}
