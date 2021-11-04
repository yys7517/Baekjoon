package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_2775 {
    // 부녀회장이 될테야
    // a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다”
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int Testcase = Integer.parseInt( br.readLine() );
        ArrayList<Integer> resultlist= new ArrayList<>();

        for ( int i = 0; i < Testcase; i++ ) {
            // k층의 n호에는 몇 사람이 살고 있을까 ?
            int k = Integer.parseInt( br.readLine() );
            int n = Integer.parseInt( br.readLine() );
            int [][] result = new int[k+1][n];

            for ( int j = 0; j < n; j++ ) {
                result[0][j] = j+1;
            }
            //System.out.println( Arrays.toString( result[0] ));

            for ( int a = 1; a < result.length; a++ ) {
                for ( int b = 0; b < result[0].length; b++ ) {
                    int cnt = 0;
                    while ( cnt <= b ) {
                        result[a][b] += result[a-1][cnt];
                        cnt++;
                    }
                }
                //System.out.println(Arrays.toString( result[a] ) );
            }
            resultlist.add( result[k][n-1] );


        }
        for ( int resulti : resultlist )
            System.out.println( resulti );

        br.close();

    }
}
