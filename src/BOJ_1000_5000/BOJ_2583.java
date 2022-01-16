package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2583 {
    // 영역 구하기

    // M x N 크기의 모눈종이가 주어진다.
    // K개의 직사각형을 그릴 때, K개의 직사각형을 제외한 나머지 부분이
    // 몇 개의 영역으로 분리되는지, 분리되는 각 영역들의 넓이는 몇 인지 구한다.

    // 입력
    // 첫 줄 - M N K
    // 두 번째 줄부터 K개의 직사각형의 왼쪽 아래 꼭짓점 x1,y1와 오른쪽 위 꼭짓점 x2,y2좌표 값이
    // 빈칸을 사이에 두고 차례대로 주어진다. x1 y1 x2 y2

    // K개의 직사각형들이 모눈종이의 전체를 채우는 경우는 없다.

    // 모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다.

    static int M;
    static int N;
    static int K;

    static int[][] paper;
    static boolean[][] visited;

    static StringBuilder sb;
    static BufferedReader br;

    static Queue<Dot> queue;

    static class Dot{
        int x;
        int y;

        public Dot( int x, int y ) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = { 1,-1,0,0 };
    static int[] dy = { 0,0,1,-1 };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));
        sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer( br.readLine(), " ") ;
        M = Integer.parseInt( st.nextToken() );
        N = Integer.parseInt( st.nextToken() );
        K = Integer.parseInt( st.nextToken() );

        paper = new int[ M ][ N ];
        visited = new boolean[ M ][ N ];

        // M = 5, N = 7
        // y좌표가 오르면, 행의 인덱스가 줄어들고
        // x좌표가 오르면, 열의 인덱스가 오른다.
        // 0,0 => [4][0]   [][]
        // 0,1 => [3][0]
        // 0,2 => [2][0]   [ 5-2 ][]
        // 4,4 => [1][3]   [ 5-4 ][ 4 - 1 ]

        // K줄에 걸쳐 입력받는다.
        for (int i = 0; i < K; i++) {
            int x1,y1,x2,y2;
            st = new StringTokenizer( br.readLine(), " ");
            x1 = Integer.parseInt( st.nextToken() );
            y1 = Integer.parseInt( st.nextToken() );
            x2 = Integer.parseInt( st.nextToken() );
            y2 = Integer.parseInt( st.nextToken() );

            // 0 2 4 4
            for (int y = y1; y < y2 ; y++) {    // 세로 for
                for (int x = x1; x < x2 ; x++) {    // 가로 for
                    paper[y][x] = 1;
                }
            }
        }
        // 출력해서 확인.
        // 문제에 칠해진 값과 다르지만 상하반전만 되어있으므로
        // 똑같은 영역을 구분할 수 있는 모눈종이라고 볼 수 있음.
        /*
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%d ", paper[i][j]);
            }
            System.out.println();
        }
         */


        int count = 0;  // 영역의 수
        ArrayList<Integer> WidthList = new ArrayList<>();

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                // 색칠된 부분이 아닌 색칠이 안된 빈 공간을 세야 함.
                if( paper[y][x] == 0 && visited[y][x] == false ) {
                    count++;
                    int width = BFS( x,y );
                    WidthList.add( width );
                }
            }
        }

        // 넓이 오름차순 정렬.
        Collections.sort( WidthList );
        // 영역 개수 + 개행
        sb.append( count ).append('\n');

        for ( int width : WidthList) {
            sb.append( width ).append(" ");
        }


        System.out.println( sb.toString().trim() );

    }


    private static int BFS(int px, int py) {
        queue = new LinkedList<>();
        // 색칠이 안된 부분이 있다면, 그 좌표를 시작으로 탐색을 시작.
        queue.add( new Dot( px,py ) );
        visited[py][px] =true;

        // 색칠이 안된 부분이 있다면, 이미 1칸이 있다는 것이므로 넓이는 1부터 시작.
        int width = 1;

        while ( !queue.isEmpty() ) {
            Dot dot = queue.poll();

            int x = dot.x;
            int y = dot.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if( nx >= 0 && nx < N && ny >= 0 && ny < M ) {
                    if( paper[ny][nx] == 0 && visited[ny][nx] == false ) {
                        width++;
                        visited[ny][nx] = true;
                        queue.add( new Dot( nx,ny ));
                    }
                }
            }

        }
        // 탐색을 시작한 곳 부터, 끝나는 곳 까지가 1개의 영역, 그 영역의 넓이 값 반환.
        return width;
    }
}
