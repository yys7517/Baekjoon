package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
    // 촌수계산

    static BufferedReader br;

    static int n;   // 전체 사람 수
    static int m;   // 관계 수

    // a-b의 촌 수 값을 구하는 것이 문제.
    static int a;
    static int b;

    static int[][] relations;
    static boolean[] visited;

    static class People{
        int number; // 사람 번호
        int count;  // 촌 수 값.

        public People( int number, int count ) {
            this.number = number;
            this.count = count;
        }
    }
    static Queue<People> queue;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));

        n = Integer.parseInt( br.readLine() );

        // 사람 표기 : 번호 1 ~ n
        relations = new int[ n+1 ][ n+1 ];
        visited = new boolean[ n+1 ];

        StringTokenizer st;

        st = new StringTokenizer( br.readLine() ," ");
        a = Integer.parseInt( st.nextToken() );
        b = Integer.parseInt( st.nextToken() );

        // 관계 수 m
         m = Integer.parseInt( br.readLine() );
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer( br.readLine(), " ");
            int parent = Integer.parseInt( st.nextToken() );
            int child = Integer.parseInt( st.nextToken() );

            relations[parent][child] = relations[child][parent] = 1;
        }

        // DFS의 시작 점을 a,b 둘 중 하나로 하여
        // a와 b사이의 DFS 탐색 횟수가 촌 수 값이 된다.

        System.out.println( BFS(a,b) );
    }

    // V 번호를 시작으로 BFS
    // 촌 수를 구할 수 있으면 촌 수를 return
    // 아니면 -1 return
    private static int BFS( int start  , int end ) {
        queue = new LinkedList<>();

        // start 를 시작으로
        // 촌 수는 자기 자신이므로 0부터 시작.
        queue.add( new People( start,0) );
        visited[ start ] =true;

        while ( !queue.isEmpty() ) {
            People people = queue.poll();

            int number = people.number;
            int count = people.count;   // start를 시작으로 하여 책정된 촌 수

            // 찾는 사람일 경우, start로 부터 책정된 촌 수를 return
            if( number == end )
                return count;

            for (int i = 1; i <= n; i++) {
                if( relations[number][i] == 1 && visited[i] == false ) {
                    // 자기 자신 number와 i가 부모 자식 관계일 경우, i는 나랑 1촌 관계이다.
                    queue.add( new People( i , count+1 ) );     // 촌 수 +1
                    visited[i] =true;
                }
            }

        }
        // 관계가 없으면 while문을 다 돌아도 촌 수가 return되지 않음.
        // -1 return.
        return -1;

    }

}
