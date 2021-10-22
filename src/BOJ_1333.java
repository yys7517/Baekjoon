
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class BOJ_1333 {
    // 부재중 전화
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt( st.nextToken() );       // 노래 개수 N                 2
        int L = Integer.parseInt( st.nextToken() );       // 노래 길이 L                 5
        int D = Integer.parseInt( st.nextToken() );       // 전화벨이 D초에 1번씩 울림.  7

        // 노래가 나오는 동안은 true
        // 노래가 안나오는 동안은 false로 해보자.

        int term = 5; // 노래 사이 간격.

        Vector<Boolean> v = new Vector<Boolean>( 20);

        for ( int i = 0 ; i < N; i++ ) {
            // 노래 길이 만큼     true ( 노래 나온다. )
            for ( int j = 0; j < L; j++ ) {
                v.add(true);
            }

            // 마지막 곡이 아니라면.
            if ( i != N-1 ) {
                // 노래 사이 간격만큼 false ( 노래 안나온다. )
                for ( int k = 0; k < term; k++ ) {
                    v.add(false);
                }
            }
        }
        /* Vector 출력해서 확인해보자.
        Iterator<Boolean> ir = v.iterator();

        while ( ir.hasNext() ) {
            Boolean b = ir.next();
            System.out.printf("[%b] ", b );
        } */

        int result = 0;

        // Vector의 인덱스를 시간으로 할 수 있음.
        int size = v.size();
        while ( result < size ) {
            if (v.get(result) == false) {
                break;
            } else
                result += D;        // 전화벨 간격 D만큼 증가..
        }
        System.out.println( result );
    }
}
