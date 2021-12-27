package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_23305 {
    // 수강변경
    // 첫 번째 배열은 신청한 수업 (= i번 학생이 가지고 있는 수업 )
    // 두 번째 배열은 듣고싶어하는 수업 ( = i번 학생이 듣고 싶어하는 수업 )
    // 조율해서 교환했을 때, 원하고 싶은 수업을 못 듣는 학생의 수를 구하는 문제.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int N = Integer.parseInt( br.readLine() );
        int [] have = new int[ 1000001 ];
//        ArrayList<Integer> have = new ArrayList<>();

        int cnt = 0;    // 원하는 과목을 수강하지 못하는 학생의 수.

        StringTokenizer st;

        st = new StringTokenizer( br.readLine() , " ");

        while ( st.hasMoreTokens() )
            have[ Integer.parseInt( st.nextToken() ) ]++;

        // System.out.println( Arrays.toString( have ));
//        ArrayList<Integer> want = new ArrayList<>();

        st = new StringTokenizer( br.readLine(), " ");

        while ( st.hasMoreTokens() ) {
            int want = Integer.parseInt( st.nextToken() );   // 원하는 과목.
            for (int i = 1; i <= N ; i++) {
                if( have[ want ] >= 1 ) {
                    have[ want ] -= 1;
                    break;
                }
                // 원하는 과목을 가진 학생이 있다면 교환. 원래 과목을 가지고 있던 학생 수 - 1

                else {
                    cnt += 1;
                    break;
                }
                // 원하는 과목을 가지고 있는 학생이 없다면, 원하는 과목을 수강하지 못하는 학생 수 + 1
            }
        }

        System.out.println( cnt );


//        Set<Integer> wantSet = new HashSet<>( want );
        // System.out.println( wantSet );



//        int wantfreq = 0;
//        int havefreq = 0;
//
//        for (Integer value : wantSet) {
//            wantfreq = Collections.frequency( want, value);
//            havefreq = Collections.frequency( have, value);
//
//            if ( wantfreq == 0 || havefreq == 0 )
//                continue;
//            else if ( wantfreq < havefreq )
//                cnt += wantfreq;
//            else if ( wantfreq == havefreq )
//                cnt += wantfreq;
//            else if ( wantfreq > havefreq )
//                cnt += havefreq;
//        }

        //System.out.println( N - cnt );

    }
}
