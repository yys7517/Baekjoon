package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        int N = Integer.parseInt( br.readLine() );
        int [] time = new int[ N ];

        for (int i = 0; i < time.length; i++) {
            time[i] = Integer.parseInt( br.readLine() );
        }

        int studytime = 30;
        int count = 0;

        for (int i = 0; i < time.length; i++) {
            if ( studytime > time[i] ) {
                System.out.println( "남은 공부시간 : " + studytime );
                System.out.println( "챕터 공부시간 : " + time[i] );
                System.out.println();
                studytime -= time[i];
                count++;
            }
            else if ( studytime == time[i] ) {
                System.out.println( "남은 공부시간 : " + studytime );
                System.out.println( "챕터 공부시간 : " + time[i] );
                System.out.println();
                count++;
                studytime = 30;
            }
            else {
                if ( studytime >= (double)time[i] / 2 ) {
                    System.out.println( "남은 공부시간 : " + studytime );
                    System.out.println( "챕터 공부시간 : " + time[i] );
                    System.out.println();
                    count++;
                    studytime = 30;
                }
                else {
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
