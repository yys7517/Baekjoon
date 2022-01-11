package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11724 {
    // 연결 요소의 개수

    // 방향 없는 그래프가 주어졌을 때, 연결 요소의 개수를 구하는 프로그램

    // 연결 요소의 개수란 ? 연결된 뭉텅이(tree)의 개수

    // 연결 요소의 개수는 어떻게 구하는가 ?

    // 1. 그래프를 어떤 정점을 기준으로 탐색을 진행한다.
    // 2. 탐색이 진행된 정점들은 방문 처리를 한다.
    // 3. 따라서 탐색이 진행이 되면, 그 정점을 포함한 뭉텅이(tree)를 구할 수 있다.
    // 4. 따라서 어떤 정점을 기준으로 탐색을 하게되면, 그 정점이 포함된 tree의 정점들은 모두 방문 처리.

    // ==> 어떤 정점을 시작점으로 하여 탐색을 진행했을 때, 탐색이 진행되면 tree가 존재하는 것. cnt++
    // ==> 탐색이 진행되지 않으면, 그 정점을 포함한 tree를 이미 셈을 한 것이다.

    // 탐색은 BFS, DFS 뭘로 해도 상관없다.

    // 정점의 개수 N, 간선의 개수 M
    // 1 <= N <= 1000
    // 0 <= M <= N * (N-1) / 2

    // N과 M을 입력
    // M 줄에 거쳐서 간선 정보 입력.

    private static int N;   // 정점의 개수 N
    private static int M;   // 간선의 개수 M

    private static BufferedReader br;

    private static int [][] graph ;
    private static boolean [] visited;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader(System.in));

        StringTokenizer st;
        
        st = new StringTokenizer( br.readLine(), " ");
        N = Integer.parseInt( st.nextToken() );
        M = Integer.parseInt( st.nextToken() );

        // 0번 인덱스를 사용하지 않기 위해
        // 1 ~ N번 인덱스만 사용.
        graph = new int[ N+1 ][ N+1 ];

        // graph의 방문된 정점을 구별하기 위한 visited 배열 초기화.
        visited = new boolean[ N+1 ];

        // 정점 u,v
        int u;
        int v;

        // 간선 정보 입력 (u-v) 정점 u와 정점 v가 연결되어 있다는 뜻.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer( br.readLine(), " ");
            u = Integer.parseInt( st.nextToken() );
            v = Integer.parseInt( st.nextToken() );

            // 정점 u와 v를 연결 , 값 = 1;
            // 연결되지 않음 = 기본 값 = 0
            graph[u][v] = graph[v][u] = 1;
        }

        int cnt = Solution( graph );

        System.out.println( cnt );
    }

    private static int Solution( int[][] graph ) {
        int cnt = 0;                // 연결 요소의 개수
        boolean searched = false;   // 탐색이 진행되었는지 ?

        for (int i = 1; i <= N; i++) {
            // 그 정점이 방문되지 않았다면 그 정점을 시작으로 탐색을 시작한다.
            if( !visited[i] ) {
                searched = BFS( i );    // BFS
                //searched = DFS( i );    // DFS

                // if ( 탐색이 진행되면 ? ) ==> cnt++
                if( searched )
                    cnt++;

                // if ( 탐색이 진행되지 않으면 ? ) ==> cnt값 그대로
            }
        }

        return cnt;
    }

    // Queue를 사용한 BFS
    private static boolean BFS( int start ) {
        boolean searched = false;

        Queue<Integer> q = new LinkedList<>();

        q.add( start );
        visited[ start ] = true;

        while ( !q.isEmpty() ) {
            int poll = q.poll();
            // System.out.printf("%d ", poll );
            for (int i = 1; i <= N; i++) {
                if( graph[poll][i] == 1 && visited[i] == false ) {
                    q.add(i);
                    visited[i] = true;
                    searched = true;
                }
            }
        }

        return searched;
    }

    // Stack을 사용한 DFS
    private static boolean DFS( int start ) {
        boolean searched = false;
        Stack<Integer> s = new Stack<>();

        s.push( start );
        visited[start] = true;

        while ( !s.isEmpty() ) {
            int pop = s.pop();
            // System.out.printf("%d ", pop );
            for (int i = 1; i <= N; i++) {
                if( graph[pop][i] == 1 && visited[i] == false ) {
                    s.push( i );
                    visited[i] = true;
                    searched = true;
                }
            }
        }
        return searched;
    }

}
