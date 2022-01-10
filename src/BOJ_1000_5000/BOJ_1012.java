package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
    // 유기농 배추
    // 그래프 탐색 문제
    // BFS

    private static BufferedReader br;
    private static StringBuilder result;

    private static int T ;  // 테스트 케이스 수
    private static int M ;  // 농장 가로 길이
    private static int N ;  // 농장 세로 길이
    private static int K ;  // 심어진 배추 개수
    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader(System.in));

        T = Integer.parseInt( br.readLine() );
        StringTokenizer st;
        result = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer( br.readLine(), " ");
            M = Integer.parseInt( st.nextToken() ); // 가로 길이    == 열의 개수
            N = Integer.parseInt( st.nextToken() ); // 세로 길이    == 행의 개수
            K = Integer.parseInt( st.nextToken() ); // 심어진 배추 개수

            // 2차원 배열 선언 꼴 - [ 행 개수 ][ 열 개수 ]


            int [][] farm = new int[ N ][ M ];
            boolean [][] check = new boolean[ N ][ M ];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer( br.readLine(), " " );
                int x = Integer.parseInt( st.nextToken() );
                int y = Integer.parseInt( st.nextToken() );

                // farm[행 번호][열 번호]
                // 행 번호는 y좌표를 의미
                // 열 번호는 x좌표를 의미.

                farm[ y ][ x ] = 1;

            }
            int count = Solution( farm, check );
            result.append( count ).append('\n');
        }
        System.out.println( result.toString().trim() );

    }

    // 인접한 배추가 있다면, BFS 탐색
    private static int Solution(int[][] farm, boolean[][] check) {
        int count = 0;

        for (int i = 0; i < N; i++) {       // 세로번호 == x좌표
            for (int j = 0; j < M; j++) {   // 가로번호 == y좌표
                // 방문했다면 ?
                if( check[i][j] )
                    continue;
                // 방문하지 않았다면 ?
                else {
                    // 방문하지 않았고 배추가 없다면 ?
                    if( farm[i][j] == 0 )
                        check[i][j] = true;

                    // 방문하지 않았고 배추가 있다면 ?
                    else {
                        count++;        // 지렁이 한마리 추가.

                        // 지렁이 한 마리는 인접한 배추들이 있다면
                        // 인접한 배추들까지 이동하여 해충들을 처리할 수 있다.

                        // 따라서 지렁이 한 마리가 있다면, 인접한 배추들을 모두 방문 처리 해줘야 한다.

                        Queue<Integer> xQueue = new LinkedList<>();
                        Queue<Integer> yQueue = new LinkedList<>();

                        // 시작점 추가.
                        xQueue.add( j );    // j는 가로를 반복하는 번호이다.
                        yQueue.add( i );    // i는 세로를 반복하는 번호이다.

                        int x;
                        int y;

                        while ( !xQueue.isEmpty() && !yQueue.isEmpty() ) {
                            x = xQueue.poll();
                            y = yQueue.poll();

                            // 인접 배추가 있고, 방문되지 않은 배추라면 ?
                            if( farm[y][x] == 1 && check[y][x] == false ) {
                                // 1. 방문처리 한다.
                                check[y][x] = true;

                                // 2. 인접정점을 찾아서 Queue에 삽입.
                                    // 1. 인접정점이 존재하는 지 부터 확인
                                    // 2. 인접정점이 존재한다면, 그 x와 y값을 Queue에 삽입.
                                if( checkXY( M , N , x-1, y ) ) {
                                    xQueue.add( x-1 );
                                    yQueue.add( y ) ;
                                }

                                if( checkXY( M , N , x+1, y ) ) {
                                    xQueue.add( x+1 );
                                    yQueue.add( y ) ;
                                }

                                if( checkXY( M , N , x, y-1 ) ) {
                                    xQueue.add( x );
                                    yQueue.add( y-1 ) ;
                                }

                                if( checkXY( M , N , x, y+1 ) ) {
                                    xQueue.add( x );
                                    yQueue.add( y+1 ) ;
                                }
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

    // 인접점이 존재하는지 확인하는 여부
    private static boolean checkXY( int width, int height, int x, int y ) {
        if( x >= 0 && y >= 0 && x < width && y < height )
            return true;
        else
            return  false;
    }
}
