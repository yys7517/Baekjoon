package BOJ_10000_15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_11104 {
    // Fridge of Your Dreams
    // 그냥 2진수를 10진수 값으로 변환하는 문제
    // 맨 처음 테스트 케이스가 주어짐. N
    // 24비트 길이의 2진수를 10진수를 변환.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
        int N = Integer.parseInt( br.readLine() );
        String [] Testcase = new String[N];
        int j = 0;

        // N번 반복.
        while ( N-- > 0 ) {
            Testcase[j] = br.readLine();
            j++;
        }

        ArrayList<Integer> list = new ArrayList<>(Testcase.length );

        for( int i = 0; i < Testcase.length; i++ ) {
            int result = 0;
            for ( int k = 0; k < 24; k++ ) {
                result += Integer.parseInt( String.valueOf(Testcase[i].charAt(k)) ) * square( 2, 23-k );
            }
            // k = 0 , 2^23
            // k = 1, 2^22
            list.add( result );
        }

        for ( int a : list ) {
            System.out.println( a );
        }
    }


    public static int square(int a,int b) {
        int sum = 1;
        for ( int i = 0 ; i < b; i++ ) {
            sum *= a;
        }
        return sum;
    }
}
