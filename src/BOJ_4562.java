import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_4562 {
    // No Brainer
    // 테스트케이스 수 N
    // 좀비가 먹는 뇌의 수 X
    // 좀비가 생존에 필요한 뇌의 수 Y
    //  좀비가 먹는 뇌의 수가 좀비가 생존하는 데 필요한 뇌의 수보다 크거나 같으면 MMM BRAINS
    // 아니면 NO BRAINS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        int N = Integer.parseInt( br.readLine() );
        ArrayList<String> list = new ArrayList<>();
        while ( N-- > 0 )  {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int X = Integer.parseInt( st.nextToken() );
            int Y = Integer.parseInt( st.nextToken() );

            if ( X - Y >= 0 ) {
                list.add("MMM BRAINS");
            }
            else
                list.add("NO BRAINS");

        }
        for ( String result : list) {
            System.out.println( result );
        }

    }
}
