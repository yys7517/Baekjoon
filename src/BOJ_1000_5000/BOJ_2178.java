package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    // 미로 탐색

    // N x M 크기의 배열로 표현되는 미로

    // 1,1에서 출발해서 N,M으로 이동할 때 지나야 하는 최소한의 칸 수를 구하는 프로그램.

    // 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸

    //일반적으로 깊이 우선 탐색보다 너비 우선 탐색쪽이 확률적으로 더 짧은 경로를 찾는다.
    // 모든 경로의 weight가 같은 경우에는 BFS탐색이 항상 최단 경로를 찾는다.

    // BFS 탐색 ?

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx ={ 0,0,1,-1 };
    static int[] dy ={ 1,-1,0,0 };

    private static class Dot {
        int x;
        int y;

        public Dot( int x, int y ) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Dot> queue = new LinkedList<>();

    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));
        StringTokenizer st;

        st = new StringTokenizer( br.readLine(), " ");
        N = Integer.parseInt( st.nextToken() );
        M = Integer.parseInt( st.nextToken() );

        map = new int[ N ][ M ];
        visited = new boolean[ N ][ M ];

        for (int i = 0; i < N; i++) {
            String[] token= br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt( token[j] );
            }
        }

        BFS();

        System.out.println( map[N-1][M-1] );
    }

    private static void BFS() {
        // 문제에서 주어진 1,1 => 배열 인덱스 0,0
        // 1,1 ~ N,M    => 0,0 ~ N-1,M-1

        // 0,0에서 시작.
        queue.add( new Dot(0,0) );
        visited[0][0] = true;

        while ( !queue.isEmpty() ) {
            Dot dot = queue.poll();
            int x = dot.x;
            int y = dot.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];     // 행 번호 값 ( 세로길이 )
                int ny = y + dy[k];     // 열 번호 값 ( 가로길이 )

                if( nx >= 0 && nx < N && ny >= 0 && ny < M ) {
                    if( map[nx][ny] == 1 && visited[nx][ny] == false ) {
                        visited[nx][ny] = true;
                        queue.add( new Dot( nx, ny ) );
                        map[nx][ny] = map[x][y] + 1;
                        // nx, ny는 x,y에서 1칸 이동한 것이다.
                    }
                }
            }
        }


    }
}
