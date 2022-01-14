package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {
    // 섬의 개수

    static int w;
    static int h;

    static int[][] map;
    static boolean[][] visited;

    // 한 칸에서 가로 세로 대각선으로 인접하면 같은 섬으로 취급한다.

    static int[] dx = { 1,-1,0,0,-1,-1,1,1 };
    static int[] dy = { 0,0,1,-1,-1,1,-1,1 };

    static BufferedReader br;
    static StringBuilder sb;

    static class Dot{
        int x;
        int y;

        public Dot( int x, int y ){
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Dot> queue;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        sb = new StringBuilder();
        br = new BufferedReader( new InputStreamReader( System.in ));

        while ( true ) {
            st = new StringTokenizer( br.readLine(), " ");
            w = Integer.parseInt( st.nextToken() );
            h = Integer.parseInt( st.nextToken() );

            if ( w == 0 && h == 0 )
                break;

            map = new int[ h ][ w ];    // 높이 : 행의 개수
                                        // 너비 : 열의 개수

            visited = new boolean[ h ][ w ];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer( br.readLine() , " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt( st.nextToken() );
                }
            }

            int count = 0;      // 섬의 개수

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if( map[i][j] == 1 && !visited[i][j] ) {
                        count++;
                        BFS( i,j );
                    }
                }
            }
            sb.append( count ).append("\n");
        }
        System.out.println( sb.toString().trim() );
    }

    private static void BFS(int i, int j) {
        queue = new LinkedList<>();

        queue.add( new Dot( i,j ));
        visited[i][j] = true;

        while ( ! queue.isEmpty() ) {
            Dot dot = queue.poll();

            int x = dot.x;
            int y = dot.y;

            for (int k = 0; k < 8 ; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if ( nx >= 0 && nx < h && ny >= 0 && ny < w ) {
                    if( map[nx][ny] == 1 && ! visited[nx][ny] ) {
                        visited[nx][ny] = true;
                        queue.add( new Dot( nx,ny ));
                    }
                }
            }
        }
    }


}


