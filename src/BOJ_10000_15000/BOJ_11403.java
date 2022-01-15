package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403 {
    // 경로 찾기

    static int N;

    // 방향 그래프 G
    static int[][] G;

    static int[][] result;
    static boolean[] visited;

    static BufferedReader br;
    static StringBuilder sb;

    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));
        sb = new StringBuilder();

        N = Integer.parseInt( br.readLine() );

        G = new int[ N+1 ][ N+1 ];
        result = new int[ N+1 ][ N+1 ];
        visited = new boolean[ N+1 ];


        // 방향 그래프 G에 i -> j 인 간선이 있다면 1
        //                                  아니라면 0

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer( br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                G[i][j] = Integer.parseInt( st.nextToken() );
            }
        }

        // 그래프의 모양과 똑같이 N*N 인접행렬 형태로 출력한다.
        // i,j로 가는 "경로"가 있다면 1, 없으면 0으로 출력한다.


        // if( BFS( i,j ) == true )
        //      result[i][j] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                if( BFS(i,j)  ) {
                    result[i][j] = 1;
                }
                System.out.printf("%d ", result[i][j] );
            }
            System.out.println();
        }



    }

    // i에서 출발하여 j로 탐색이 성공하면 true반환
    //                          아니면 false 반환
    private static boolean BFS(int i, int j) {
        queue = new LinkedList<>();
        // i에서 j로 가는 경로가 있는지 확인하는 BFS이므로
        // 매 실행마다 정점이 방문되었는지 배열을 새로 만들어 줘야한다.
        visited = new boolean[ N+1 ];
        // visited[i] = true;
        // cycle 이 있는지도 파악 해야하기 때문에
        // 시작점 i를 방문 처리를 해주지 않는다.

        queue.add( i );

        while ( ! queue.isEmpty() ) {
            int poll = queue.poll();

            for (int k = 1; k <= N ; k++) {
                if( G[poll][k] == 1 && visited[k] == false ) {
                    visited[k] = true;
                    queue.add( k );
                    if( k == j )
                        return true;
                }
            }
        }
        return false;
    }
}
