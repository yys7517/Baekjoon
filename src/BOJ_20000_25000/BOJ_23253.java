package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_23253 {
    // 자료구조는 정말 최고야

    // 과목명 : 1 ~ N
    // M 개의 더미만큼 , 더미의 개수만큼 스택을 생성.
    // M 개의 더미에서 pop한 과목번호 값이 1번,2번, ..., N-1번, N번 순으로 나열할 수 있는지 알려주는 프로그램
    // "Yes" or "No" 출력.

    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
    private static StringTokenizer st;

    static {
        try {
            st = new StringTokenizer( br.readLine() , " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt( st.nextToken() ); // 과목 수
        int M = Integer.parseInt( st.nextToken() ); // 더미 수

        String result = Solution( M );
        System.out.println( result );
    }

    private static String Solution( int M ) throws IOException{
        int repeat = M;

        boolean flag = true;

        while ( repeat-- > 0 ) {
            int dummy_size = Integer.parseInt(br.readLine());
            String [] Dummy = new String[ dummy_size ];
            Dummy = br.readLine().split(" ");

            for (int i = 0; i < Dummy.length - 1; i++) {
                // Dummy를 스택이라고 봤을 때, 먼저 pop되는 부분인 바깥쪽의 값..
                // i보다는 i+1이 바깥쪽의 값인데, 바깥쪽의 값이 안쪽의 값보다 크게 되면
                // 오름차순으로 과목이 뽑히지 않음.
                if ( Integer.parseInt( Dummy[i]) < Integer.parseInt( Dummy[i+1]) ) {
                    flag = false;
                }
            }
        }

        if ( flag )
            return "Yes";
        else
            return "No";
    }

}
