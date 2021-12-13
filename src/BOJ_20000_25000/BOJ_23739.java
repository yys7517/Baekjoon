package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        int N = Integer.parseInt( br.readLine() );  // 챕터의 수.
        int [] time = new int[ N ];                 // 챕터 공부 소요시간 배열.

        for (int i = 0; i < time.length; i++) {
            time[i] = Integer.parseInt( br.readLine() );
        }

        int studytime = 30;                         // 공부 시간.
        int count = 0;                              // 절반 이상 공부한 챕터의 수.

        for (int i = 0; i < time.length; i++) {
            if ( studytime > time[i] ) {            // 공부시간 > 챕터 시간
                System.out.println( "남은 공부시간 : " + studytime );
                System.out.println( "챕터 공부시간 : " + time[i] );
                System.out.println();
                studytime -= time[i];
                count++;                            //
            }
            else if ( studytime == time[i] ) {      // 공부시간 == 챕터 시간
                System.out.println( "남은 공부시간 : " + studytime );
                System.out.println( "챕터 공부시간 : " + time[i] );
                System.out.println();
                count++;
                studytime = 30;
            }
            else {                                   // 공부시간 < 챕터시간
                if ( studytime >= (double)time[i] / 2 ) {   // 그 챕터를 절반 이상 공부했다.
                    System.out.println( "남은 공부시간 : " + studytime );
                    System.out.println( "챕터 공부시간 : " + time[i] );
                    System.out.println();
                    count++;
                    studytime = 30;
                }
                else {                                      // 그 챕터를 절반도 공부 못 했다.
                    System.out.println( "남은 공부시간 : " + studytime );
                    System.out.println( "챕터 공부시간 : " + time[i] );
                    System.out.println();
                    studytime = 30;
                }
            }
        }
        System.out.print( count );
    }
}
