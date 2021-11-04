package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_1212 {
    // 8진수 -> 2진수
     static String[] octToBin = {"000", "001", "010", "011", "100", "101", "110", "111"};

    public static void main(String[] args)  throws IOException {
        Scanner sc  = new Scanner( System.in );
        char [] oct = sc.next().toCharArray();
       // BufferedReader br = new BufferedReader( new InputStreamReader( System.in) );
        ///////String input = br.readLine();
        StringBuilder sb = new StringBuilder("");

        if ( oct.length == 1 && oct[0] == '0') {
            System.out.println( 0 );
            return;
        }

        for ( int i = 0; i < oct.length; i++ ) {
            sb.append( octToBin[oct[i] -'0'] );
        }

        while ( sb.charAt(0) == '0' ) {
            sb.deleteCharAt(0);
        }

        // 8진수 -> 2진수 변환. 8진수 1자리 값을 -> 3자리 2진수 값으로 변환 가능.
/*
        for ( int i = 0; i < input.length(); i++ ) {
            String value = "";
            int a = Integer.parseInt(String.valueOf( input.charAt(i) ));
            System.out.println(a);
            if (a > 0 && a <= 7) {
                while ( a > 0 ) {
                    int rest = a % 2;
                    value = rest + value;
                    a /= 2;
                }
                sb.append( String.format("%03d",Integer.parseInt(value)) );
                while ( sb.charAt(0) == '0' ) {
                    sb.deleteCharAt(0);
                }

            }
            else if ( a == 0) {
                System.out.println(0);
                break;
            }

        }
*/
        System.out.println( sb );



        // 8진수 -> 10진수 -> 2진수 변환 (비효율적..)
        /*
        StringBuilder sb = new StringBuilder( input );
        int [] inputnum = new int[ input.length() ];
        int decimal = 0;

        for ( int i = 0; i < input.length(); i++ ){
           inputnum[i] = Integer.parseInt (String.valueOf(sb.charAt(i)) );
           decimal += inputnum[i] * square(8, inputnum.length - 1 -i );
        }
        // System.out.println(Arrays.toString( inputnum ));    // 입력 값을 배열에 받아옴.
        // System.out.println( decimal );                      // 10 진수로 변환한 값 decimal

        int cnt = 0;
        int temp = decimal;
        while ( temp > 0 ) {
            temp /= 2;
            cnt++;
        }
        //System.out.println( cnt );
        int [] result = new int[cnt];

        int share;
        while ( decimal > 0 ) {
            share = decimal / 2;
            int rest = decimal % 2;
            result[cnt-1] = rest;
            decimal /= 2;
            cnt--;
        }
        for ( int i = 0; i < result.length; i++ ) {
            System.out.print(result[i]);
        }
         //System.out.println( Arrays.toString( result ) );
    }

    private static int square(int a, int b) {
        if ( b == 0 )
            return 1;
        else {
            for ( int i = 1; i < b; i++ ){
                a *= a;
            }
            return a;
        }
*/

    }
}
