import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_10250 {
    // ACM 호텔
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int TestCase = Integer.parseInt( br.readLine() );
        ArrayList<String> list = new ArrayList<>();

        // 1 ≤ H, W ≤ 99, 1 ≤ N ≤ H × W).

        for ( int i = 0 ; i < TestCase; i++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H,W,N;      // H 층, W 길이, N 번째 손님
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int Hcount, Wcount;

            // N % H == 0
            // 꼭대기층에 위치한다는 것을 의미.

            // 12 24 36 48 60 72 84 96 108 120 132 144
            // 11			                   131 143
            // 10

            Hcount = N % H == 0 ? H :  N % H ;
            Wcount = N % H == 0 ? N / H : ( N / H ) + 1;

            StringBuffer sb = new StringBuffer("");

            String WString = String.format("%02d",Wcount);
            // System.out.println(WString);
            sb.append(Hcount).append(WString);
            list.add( sb.toString() );
            // 리스트에 추가해주고 StringBuffer . for문 돌면서 다시 초기화.
        }

        for ( String result : list ) {
            System.out.println( result );
        }


    }
}
