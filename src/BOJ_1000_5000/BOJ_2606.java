package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2606 {
    // 바이러스

    private static BufferedReader br;

    private static int N;   // 컴퓨터의 수

    private static int count = 0;   // 1번 컴퓨터를 통해 바이러스에 걸린 컴퓨터 수

    private static int [][] graph;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));

        N = Integer.parseInt( br.readLine() );          // 컴퓨터의 수

        graph = new int[ N+1 ][ N+1 ];
        visit = new boolean[ N+1 ];

        int Connect_N = Integer.parseInt( br.readLine() );  // 연결된 쌍의 수

        StringTokenizer st;
        // 컴퓨터 A - B 연결. (간선 정보 연결)
        for (int i = 0; i < Connect_N; i++) {
            st = new StringTokenizer( br.readLine() , " ");
            int A = Integer.parseInt( st.nextToken() );
            int B = Integer.parseInt( st.nextToken() );

            // 두 쌍 연결
            graph[A][B] = graph[B][A] = 1;
        }

        // 1. BFS로 해결
        // count = BFS(1);

        // 2. DFS로 해결
        //      1. 재귀
        // DFS(1);

        //      2. 명시적 스택 사용.
        count = DFS( 1 );

        System.out.println( count );
    }

    // 정점 V에서 시작하는 BFS 탐색
    // BFS ==> Queue
    private static int BFS( int V ) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer( V );       // 시작점 q에 삽입.
        visit[ V ] = true;  // 시작점 방문 처리

        while ( !q.isEmpty() ) {
            int temp = q.poll();

            // temp의 인접정점이 있고 ? 방문이 안됬으면 ?
            // 바이러스에 걸린 컴퓨터 수 count++

            for (int i = 1; i <= N ; i++) {
                if( graph[temp][i] == 1 && visit[i] == false ) {
                    q.offer( i );
                    visit[i] = true;
                    count++;
                }
            }

        }
        return count;
    }

    // 정점 V에서 시작하는 DFS 탐색
    // 재귀 or 스택

    // 1. 재귀 DFS
    /*
    private static void DFS( int V ) {

        // 방문 처리
        visit[ V ] = true;

        for (int i = 1; i <= N ; i++) {
            if( graph[V][i] == 1 && visit[ i ] == false ) {
                count+= 1;    // 인접한 컴퓨터가 있다면 count++
                DFS( i );     // 인접한 컴퓨터를 시작으로 DFS 재귀호출
            }
        }
    }
     */

    // 2. 명시적 스택 사용 DFS
    private static int DFS ( int V ) {
        int count = 0;  // 시작점 V로 인해 바이러스에 걸린 컴퓨터 수

        Stack<Integer> s = new Stack<>();
        s.push( V );    // 시작점 push
        visit[V] = true;

        while ( !s.isEmpty() ) {
            int temp = s.pop();
            // 인접 정점이 존재하고 방문되지 않았다면
            for (int i = 1; i <= N ; i++) {
                if( graph[temp][i] == 1 && !visit[i] ) {
                    count++;
                    s.push( i );
                    visit[i] = true;
                }
            }
        }

        return count;
    }

}
