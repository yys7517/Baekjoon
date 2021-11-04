package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4101 {
    // 크냐 ?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        ArrayList<String> list = new ArrayList<>();
        while ( true )  {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt( st.nextToken() );
            int b = Integer.parseInt( st.nextToken() );

            if ( a == 0 && b == 0 )
                break;

            if ( a - b > 0 ) {
                list.add("Yes");
            }
            else
                list.add("No");

        }
        for ( String result : list) {
            System.out.println( result );
        }

    }
}
