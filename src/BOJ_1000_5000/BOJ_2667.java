package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667 {
    // 단지번호붙이기

    // 한 변의 길이가 N인 정사각형 크기의 지도

    // N을 입력
    // ( 5 ≤ N ≤ 25 )
    // N줄에는 지도 정보를 입력

    // 단지 -> 연결되어 있는 집 ( 연결 = 상하좌우에 집이 있을 경우 두 집은 연결되었다 라고 함. )

    // 총 단지의 수를 출력
    // 그 다음 줄에는 단지 내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력
    private static BufferedReader br;

    private static int N;

    private static int [][] map;
    // 값 : 0 -> 집이 없다.
    // 값 : 1 -> 집이 있다.


    private static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));

        N = Integer.parseInt( br.readLine() );
        map = new int[ N ][ N ];
        visited = new boolean[ N ][ N ];

        String[] token;

        for (int i = 0; i < N; i++) {
            token = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt( token[j] );
            }
        }

        int dcount = 0; // 총 단지의 수
        ArrayList<Integer> hcounts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문되지 않았고, 집이 있다면
                if( visited[i][j] == false && map[i][j] == 1 ) {
                    int hcount = BFS( i, j );   // 단지 내 집의 수
                                                // 단지 내 집의 수는 탐색에서 정점을 발견할 때 마다 증가.
                    // 단지 수는 탐색을 시작할 때 증가.
                    dcount++;
                    hcounts.add( hcount );
                }
            }
        }
        Collections.sort( hcounts );    // 단지 내 집의 수를 담은 리스트 오름차순 정렬
        System.out.println( dcount );
        for ( int value : hcounts ) {
            System.out.println( value );
        }

    }

    // map[i][j] 부터 탐색을 시작하여
    // 단지 내에 있는 집의 개수를 반환한다.
    private static int BFS(int i, int j) {
        int hcount = 0;

        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        xQueue.add(i);
        yQueue.add(j);

        while ( !xQueue.isEmpty() && !yQueue.isEmpty() ) {
            int x = xQueue.poll();
            int y = yQueue.poll();

            // 정점이 방문되지 않았고, 집이 있을 때
            if( map[x][y] == 1 && visited[x][y] == false ) {
                visited[x][y] = true;
                hcount++;

                // 상하좌우 인접 정점 값을 삽입.

                if( checkIdx(x-1,y) ) {
                    xQueue.add(x-1);
                    yQueue.add(y);
                }

                if( checkIdx(x+1,y) ) {
                    xQueue.add(x+1);
                    yQueue.add(y);
                }

                if( checkIdx(x,y+1) ) {
                    xQueue.add(x);
                    yQueue.add(y+1);
                }

                if( checkIdx(x,y-1) ) {
                    xQueue.add(x);
                    yQueue.add(y-1);
                }
            }


        }

        return hcount;
    }

    private static boolean checkIdx( int i, int j ) {
        if( i >= 0 && i < N && j >=0 && j < N )
            return true;
        else
            return false;
    }
}
