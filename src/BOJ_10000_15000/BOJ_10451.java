package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10451 {
    // 순열 사이클

    static int T;
    static int N;

    static BufferedReader br;
    static StringBuilder sb;

    static int[][] graph;
    static boolean[] visited;

    static Queue<Integer> queue;

    // 그래프의 모든 정점 간 연결 쌍이 순열을 이룰 때 모든 노드는 연결관계를 갖는다.
    // 이를 순열 사이클이라고 한다.

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));
        sb = new StringBuilder();

        T = Integer.parseInt( br.readLine() );


        StringTokenizer st;


        for (int i = 0; i < T; i++) {
            N = Integer.parseInt( br.readLine() );

            graph = new int[ N+1 ][ N+1 ];
            visited = new boolean[ N+1 ];

            st = new StringTokenizer( br.readLine() , " ");

            for (int j = 1; j <= N ; j++) {
                int tmp = Integer.parseInt( st.nextToken() );
                graph[ j ][ tmp ] = 1;
            }

            int cycle_count = 0;

            for (int j = 1; j <= N ; j++) {
                if( ! visited[j]  ) {
                    cycle_count++;
                    BFS( j );
                }
            }

            sb.append( cycle_count ).append('\n');
        }

        System.out.println( sb.toString().trim() );
    }

    private static void BFS(int V) {
        queue = new LinkedList<>();
        queue.add( V );
        visited[ V ] = true;

        while ( !queue.isEmpty() ) {
            int poll = queue.poll();

            for (int i = 1; i <= N ; i++) {
                // queue에서 꺼내진 정점이 출발점이고, i가 도착지이다.
                // 이 문제에서 주어진 그래프는 방향 그래프.
                // poll = 5 , i = 0
                if( graph[poll][i] == 1 && !visited[i] ) {
                    visited[i] = true;
                    queue.add( i );
                }
            }
        }
    }
}
