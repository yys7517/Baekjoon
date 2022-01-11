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
    // 간선이 하나도 없으면, 정점의 개수가 tree의 개수가 된다.

    // 접근법
    // 연결 요소의 개수를 어떻게 구할 수 있을까 ?
    // 1 ~ N 까지의 정점 중, 어떤 정점들은 연결되어 있을 수 있고, 아닐 수 있다.

    // 이를 판별하기 위해, 탐색을 진행한다. ( BFS 와 DFS 탐색 모두 가능하다. )
    // 만약 연결되어 있다면, 탐색을 통하여 연결된 정점들은 1개의 연결 요소로 볼 수 있다.

    // *** 나머지 연결되어 있지 않은 정점들 또한 1개의 연결 요소로 볼 수 있다. ***

    // 문제 해결 순서
    // 1.  1 ~ N 까지 정점들을 시작점으로 하여, 탐색을 진행한다.
    // 2.  이 과정에서 방문된 정점은 이미 어떤 연결 요소에 포함되어 있으므로 생략한다.
    // 3.  방문되지 않은 정점은 탐색을 진행하여 다른 정점과 연결 요소를 이루고 있는지 확인한다.


    // * 입력 *
    // 정점의 개수 N과 간선의 개수 M을 입력
    // M의 개수만큼 간선 정보 입력.

    // * 출력 *
    // 연결 요소의 개수 값

    private static int N;   // 정점의 개수 N
    private static int M;   // 간선의 개수 M

    // 1 <= N <= 1000
    // 0 <= M <= N * (N-1) / 2


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

        int cnt = 0;

        for (int i = 1; i <= N ; i++) {
            // 방문되지 않은 정점이라면
            // 탐색을 진행하고, 탐색 진행을 시작할 때, 연결 요소 1개가 어디 정점까지 연결되어 있는지
            // 찾는 것이므로, 탐색을 시작할 때, 연결 요소의 개수를 1 증가 시켜준다.

            // 방문되지 않은 정점이 아무 정점과도 연결되지 않은 독립된 정점이더라도
            // 방문 처리하고, 연결 요소 개수를 1 증가 시켜준다.
            // 탐색 메서드 과정에서는 방문 처리 외 다른 동작은 하지 않는다. ( 독립된 정점일 때 )
            if ( visited[i] == false ) {
                BFS(i);
                // DFS(i);
                // RecursiveDFS(i);
                cnt++;
            }
        }

        System.out.println( cnt );
    }

    // 재귀형 DFS
    private static void RecursiveDFS( int V ) {
        if( visited[ V ] )  // 정점이 방문되었다면 탐색 종료.
            return;

        else {              // 정점이 방문되지 않았다면.
            visited[ V ] = true;    // 방문처리

            for (int i = 1; i <= N ; i++) {
                if( graph[V][i] == 1 )
                    DFS(i);
            }
        }
    }

    // 스택을 사용한 DFS
    private static void DFS( int V ) {
        Stack<Integer> s = new Stack<>();

        s.push( V );
        visited[ V ] = true;

        while ( !s.isEmpty() ) {
            int pop = s.pop();

            for (int i = 1; i <= N ; i++) {
                if( graph[pop][i] == 1 && visited[i] == false ) {
                    s.push( i );
                    visited[ i ] = true;
                }
            }
        }
    }


    // BFS ==> Queue를 사용.
    private static void BFS( int V ) {
        Queue<Integer> q = new LinkedList<>();

        q.add( V );
        visited[ V ] = true;

        while ( !q.isEmpty() ) {
            int poll = q.poll();

            for (int i = 1; i <= N ; i++) {
                if( graph[poll][i] == 1 && visited[i] == false ) {
                    q.add( i );
                    visited[ i ] = true;
                }
            }
        }
    }
}
