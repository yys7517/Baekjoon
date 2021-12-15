package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {
    // DFS와 BFS
    // 주어진 그래프를
    // DFS로 탐색한 결과와
    // BFS로 탐색한 결과를 출력하는 문제이다.

    // 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
    // 더 이상 방문할 수 있는 점이 없는 경우 종료한다


    // 입력 처리
    static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
    static StringTokenizer st;

    static {
        try {
            st = new StringTokenizer( br.readLine(), " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static int N = Integer.parseInt( st.nextToken() ); // 그래프 정점의 개수
    // 정점의 번호 : 1 ~ N
    static int M  =Integer.parseInt( st.nextToken() ); // 그래프 간선의 개수
    static int V = Integer.parseInt( st.nextToken() ); // 탐색을 시작할 정점 번호.

    static int [][] map = new int[1001][1001];          // 그래프 간선 연결 정보.
    // ex ) map[1][2] == 1 ?  정점 1과 2가 연결되어 있다는 것.
    //      map[1][2] = map[2][1] = 1
    static boolean[] visit = new boolean[1001];         // 정점 방문 정보.
    //  visit[1] == true ?
    // 정점 1이 방문되었다는 것.


    // 경로를 담을 ArrayList
    static ArrayList<Integer> DFS_route = new ArrayList<>();
    static ArrayList<Integer> BFS_route = new ArrayList<>();

    // DFS, 재귀, 인접 행렬, v 정점 부터 시작한다.
    private static void DFS( int v ) {
        visit[ v ]= true;   // v를 방문.
        DFS_route.add( v ); // 경로에 v를 추가.

        for (int i = 1; i <= N; i++) {
            // 1번 정점부터 N번 정점 중에
            if( map[v][i] == 1 && visit[i] == false ) {
                // v에 인접한 정점인 i가 있고, i를 방문하지 않았으면,
                // 그 정점 i를 시작점으로 다시 탐색.
                DFS( i );
                // 재귀하여, i를 방문처리하고, i에 인접하고, 방문되지 않은 정점으로
                // 다시 재귀 ( 이 과정 반복 )
            }
        }
    }

    private static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer( v );       // 시작점을 q에 넣어준다.
        visit[ v ] = true;  // 시작점 방문 처리.

        while ( !q.isEmpty() ) {
            int temp = q.poll();        // q에서 꺼낸 값을 temp에 넣어준다.

            // 탐색 경로에 temp 정점을 삽입..
            BFS_route.add( temp );

            for (int i = 1; i <= N ; i++) {
                // 1번 정점부터 N번 정점 중에
                if( map[temp][i] == 1 && visit[i] == false ){
                    // q에서 꺼낸 정점 temp의 인접 정점인 i가 있고, 그 정점 i가 방문이 되지 않았다면,
                    q.offer( i );   // 큐에 i 정점을 삽입.
                    visit[ i ] = true;  // 큐에 정점을 삽입할 때, 방문 처리.
                }
            }
            // System.out.println( q );
        }
    }

    public static void main(String[] args) throws IOException {

        int repeat_count = M;
        // 간선의 개수 만큼 반복한다.
        // 그래프의 정점 간 연결된 간선들을 간선의 개수만큼 입력 받는다.

        while ( repeat_count-- > 0 ) {
            StringTokenizer edgeinput = new StringTokenizer( br.readLine(), " ");
            // 입력받은 간선의 정보를 어디에 저장할까 ??
            // 2차원 배열..
            int start = Integer.parseInt( edgeinput.nextToken() );
            int end = Integer.parseInt( edgeinput.nextToken() );

            // 1과 4가 연결되어 있다는 간선의 정보
            // ==
            // 4와 1이 연결되어 있다는 간선의 정보
            map[start][end] = map[end][start] = 1;
            // 연결되어 있음을 1로 표시한다. 배열은 기본값 0을 가지고 초기화된다.
        }


        // DFS, 재귀, 인접 행렬, V 정점 부터 시작한다.
        // V : 탐색을 시작할 정점 번호.
        DFS( V );
        for ( int V : DFS_route ) {
            System.out.printf("%d ", V );
        }

        System.out.println();

        // BFS, 큐 사용, 인접 행렬, V 정점 부터 시작한다.
        // V : 탐색을 시작할 정점 번호.
        visit = new boolean[1001];  // 방문 정보 초기화.
        BFS( V );
        for ( int V : BFS_route ) {
            System.out.printf("%d ", V );
        }

    }




}
