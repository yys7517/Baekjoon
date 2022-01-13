package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184 {
    // 양

    // 직사각형의 행과 열로 이루어진 마당 모양이 주어진다.

    // . 은 빈 필드, #은 울타리, o는 양, v는 늑대를 의미한다.
    // 수평 수직만으로 이동, 울타리를 지나지 않고 다른 칸으로 이동할 수 있다면, 그 칸들은 같은 영역
    // 영역 안의 양의 수가 늑대보다 많다면, 늑대를 쫓아낼 수 있고,
    // 양의 수가 더 적다면, 모든 양이 늑대에게 죽임을 당한다.

    // 남은 양과 늑대의 수를 공백을 두고 출력하라.

    static int R;   // 행의 수
    static int C;   // 열의 수

    static String[][] ground;
    static boolean[][] visited;

    static BufferedReader br;
    static StringBuilder sb;

    static class Point {
        int x;
        int y;

        public Point( int x, int y ) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Point> queue;

    static int[] dx = { 1,-1,0,0 };
    static int[] dy = { 0,0,1,-1 };

    static int res_sheep = 0;
    static int res_wolf = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader(System.in ));
        sb = new StringBuilder();

        StringTokenizer st;
        st = new StringTokenizer( br.readLine() ," ");

        R = Integer.parseInt( st.nextToken() );
        C = Integer.parseInt( st.nextToken() );

        ground = new String[ R ][ C ];
        visited = new boolean[ R ][ C ];

        for (int i = 0; i < R; i++) {
            String[] token = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                ground[i][j] = token[j];
                //System.out.printf("%s ", ground[i][j] );
            }
            //System.out.println();
        }



        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if( visited[i][j] == false && !ground[i][j].equals("#") )
                    BFS(i,j);
            }
        }

        sb.append(res_sheep).append(" ").append(res_wolf);
        System.out.println( sb );
    }

    private static void BFS( int px,int py ) {
        queue = new LinkedList<>();

        int sheep = 0;
        int wolf = 0;

        queue.add( new Point( px,py ) );
        visited[px][py] =true;

        while ( ! queue.isEmpty() ) {
            Point p = queue.poll();

            int x = p.x;
            int y = p.y;

            // System.out.printf("현재 위치 : (%d,%d)\n",x,y);

            if( ground[x][y].equals("o") )
                sheep++;
            else if( ground[x][y].equals("v") )
                wolf++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[ i ];   // 세로 길이
                int ny = y + dy[ i ];   // 가로 길이

                if( nx >= 0 && nx < R && ny >= 0 && ny < C ) {
                    // 방문한 지점이 울타리가 아니고, 방문한 적이 없을 때
                    if( !ground[nx][ny].equals("#") && ! visited[nx][ny] ) {
                        queue.add( new Point(nx,ny) );
                        visited[nx][ny] = true;
                    }

                }
            }
        }
        // while문 한 번에 한 영역을 탐색하게 된다.
        // 한 영역의 양의 수랑 늑대의 수를 비교한다.
        if( sheep > wolf )
            res_sheep += sheep;
        else
            res_wolf += wolf;

        // System.out.printf("sheep : %d, wolf : %d\n",sheep,wolf);
    }
}
