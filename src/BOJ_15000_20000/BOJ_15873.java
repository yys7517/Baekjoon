package BOJ_15000_20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15873 {
    // 공백 없는 A+B
    // 102 = 10 + 2 = 12
    // 37 = 3 + 7

    //자연수 A, B (0 < A, B ≤ 10)

    // 두 수는 커봤자 10이 최대이다.

    // 11 ~ 1010이 모든 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int AB = Integer.parseInt( br.readLine() );
        // 입력받는 공백 없는 AB값은
        // 2자리, 3자리, 4자리 일 수 있다.

        int A;
        int B;
        // 두 자리 일때
        if ( AB < 100 ) {
            A = AB / 10;
            B = AB % 10;
            System.out.println( A+B );
        }
        // 세 자리 일때
        // A가 10인 경우 --> 101 ~ 109
        // B가 10인 경우 --> 110 ~ 910
        else if ( AB < 1000 ) {
            if ( AB < 110 ) {
                A = 10;
                B = AB % 10;
            }
            else {
                B = 10;
                A = AB / 100;
            }
            System.out.println( A+B );
        }
        // 네 자리 일때는 1010인 경우밖에 없다.
        else
            System.out.println( 20 );

//        String input = br.readLine();
//        if ( input.contains("0") ) {
//            int sep_idx = input.indexOf("0");
//            StringBuffer A = new StringBuffer();
//            StringBuffer B = new StringBuffer();
//
//            for (int i = 0; i <= sep_idx; i++) {
//                A.append(input.charAt(i));
//            }
//            for (int i = sep_idx + 1; i < input.length(); i++) {
//                B.append( input.charAt(i) );
//            }
//            System.out.println( Integer.parseInt( A.toString() ) + Integer.parseInt( B.toString() ));
//        }
//        else {
//            StringBuffer A = new StringBuffer();
//            StringBuffer B = new StringBuffer();
//            A.append( input.charAt(0) );
//            B.append( input.charAt(1) );
//            System.out.println( Integer.parseInt( A.toString() ) + Integer.parseInt( B.toString() ));
//        }
//        String [] token = br.readLine().split("");
//        // System.out.println(Arrays.toString(token) );
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < token.length; i++) {
//            list.add( token[i] );
//        }
//        // 0이 포함된다면 ? 입력받은 값은 3자리이거나 4자리이다.
//
//        if ( list.contains("0") ) {
//            int seperateidx = list.indexOf("0");
//            String A = "";
//            String B = "";
//            for (int i = 0; i <= seperateidx; i++) {
//                A += list.get(i);
//            }
//            for (int i = seperateidx + 1; i < list.size(); i++) {
//                B += list.get(i);
//            }
//            System.out.println( Integer.parseInt(A) + Integer.parseInt(B) );
//        }
//        // 0이 포함되지 않는다면 ? 입력받은 값은 2자리이다.
//        else {
//            System.out.println( Integer.parseInt( list.get(0) ) + Integer.parseInt( list.get(1) ));
//        }
    }

}
