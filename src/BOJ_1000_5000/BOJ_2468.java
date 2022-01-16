package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2468 {
    // 안전 영역

    // 어떤 지역의 높이 정보를 파악.
    // 그 지역에 많은 비가 내렸을 때, 물에 잠기지 않는 영역을 안전 영역
    // 안전 영역이 최대로 몇 개가 만들어지나?

    // 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다.

    // 지역의 높이 정보는 행과 열의 크기가 모두 N인 정사각형 크기의 2차원 배열로 받는다.
    // 배열의 각 원소는 각 지역의 높이를 표시한다.

    // 영역은 위 아래 오른쪽 왼쪽으로 인접해있는 지역들의 모임이다.

    // 입력
    // 첫째 줄 -> N 값.( 행과 열의 크기 )
    // 둘째 줄부터는 N행 N열에 대한 배열의 값( 지역의 높이 값 )을 입력 받는다.


    // 추가 정보 : 아무 지역도 물에 잠기지 않을 수도 있다.

    // 비가 오는 양이 주어지지 않는다 -> 브루트포스

    // 비가 오는 높이를 0부터 시작하자.
    // 비가 오는 높이를 몇 까지 브루트포스 해야하나 ? 모든 지역의 최대 값?

    // 모든 지역의 높이는 1이상 100이하의 정수.

    // 높이 0 -> 아무 지역도 잠기지 않는다.  안전 영역 개수 1
    // 높이 MAX -> 전체 지역이 잠긴다. 안전 영역 개수 0


    // 1트. MAX까지 브루트포스 해보자. --> 정답.

    static int N;
    static BufferedReader br;

    static int[][] map;
    static boolean[][] visited;

    static int height = 0; // 비가 오는 높이.
    static int max = Integer.MIN_VALUE;

    static ArrayList<Integer> countlist;

    static class Dot {
        int x;
        int y;

        public Dot( int x, int y ) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = { 1,-1,0,0 };
    static int[] dy = { 0,0,-1,1 };

    static Queue<Dot> queue;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader( new InputStreamReader( System.in ));
        N = Integer.parseInt( br.readLine() );

        map = new int[ N ][ N ];


        StringTokenizer st;

        // 지역 높이 정보( 배열 정보 ) 입력.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer( br.readLine() , " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt( st.nextToken() );
                max = map[i][j] > max ? map[i][j] : max;    // 모든 지역들 중 최대 높이
            }
        }

        //System.out.println( max );


        countlist = new ArrayList<>(); // 안전 영역의 수들이 모두 담겨있다.

        while ( height != max ) {
            int count = 0;  // height 이하인 지점이 모두 잠길 때 안전 영역의 수 count

            // 높이가 height 이하인 지점은 모두 잠긴다.
            // 지역의 높이와 비가 오는 높이가 같을 때도 잠긴다.

            // while문이 돌 때마다 방문 정보를 초기화 해줘야 한다.
            // height 값이 변경되므로, 그에 따라 방문되는 지점도 달라질 것.
            visited = new boolean[ N ][ N ];

            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N; j++) {
                    // 따라서 비가 오는 높이보다 높은 지역이라면 안전 지역이다.
                    if( map[i][j] > height && visited[i][j] == false ) {
                        count++;
                        BFS(i,j);
                    }
                }
            }

            // height이하인 지점이 다 잠겼을 때, 구한 안전 영역의 수
            countlist.add( count );

            height++;
        }

        //System.out.println( countlist );

        // 오름차순 정렬
        Collections.sort( countlist );

        // 안전 영역 개수 리스트 중 마지막 인덱스 값
        System.out.println( countlist.get( countlist.size() - 1 ) );

    }

    private static void BFS(int i, int j) {
        queue = new LinkedList<>();

        queue.add( new Dot(i,j) );
        visited[i][j] = true;

        while ( !queue.isEmpty() ) {
            Dot dot = queue.poll();

            int x = dot.x;
            int y = dot.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 인덱스가 유효한 지 ?
                if( nx >= 0 && ny >= 0 && nx < N && ny < N ) {
                    if( map[nx][ny] > height && visited[nx][ny] == false ) {
                        visited[nx][ny] = true;
                        queue.add( new Dot(nx,ny) );
                    }
                }
            }
        }
    }
}
