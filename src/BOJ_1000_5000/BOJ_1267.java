package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1267 {
    // 핸드폰 요금
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        int N = Integer.parseInt( br.readLine() );
        int [] sec = new int[ N ];
        int Yfee = 0;       // 영식 요금제로 했을 때 총 요금.
        int Mfee = 0;       // 민식 요금제로 했을 때 총 요금.

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for ( int i = 0 ; i < N; i++ ) {
            sec[i] = Integer.parseInt( st.nextToken() );
        }
        // System.out.println(Arrays.toString(sec) );

        // 영식 요금제 : 0 ~ 29초 10원, 30초 왜 20원 ?
        // 민식 요금제 : 0 ~ 59초 15원, 60초 왜 30원 ?
        for ( int i = 0; i < N; i++ ) {
            Yfee += ( ( sec[i] / 30 ) + 1)  * 10;
            Mfee += ( ( sec[i] / 60 ) + 1)  * 15;
        }

        //System.out.println(Yfee);
        //System.out.println(Mfee);

        // 민식요금제로 계산한 총 요금이 비쌀 때...
        if ( Yfee < Mfee )
            System.out.println("Y "+ Yfee);
        else if ( Yfee > Mfee )
            System.out.println("M "+ Mfee);
        else
            System.out.println("Y M "+Yfee);
    }
}
