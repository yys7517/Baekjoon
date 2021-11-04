package BOJ_20000_25000;

import java.util.*;

public class BOJ_23305 {
    // 수강변경
    // 첫 번째 배열은 신청한 수업 (= i번 학생이 가지고 있는 수업 )
    // 두 번째 배열은 듣고싶어하는 수업 ( = i번 학생이 듣고 싶어하는 수업 )
    // 조율해서 교환했을 때, 원하고 싶은 수업을 못 듣는 학생의 수를 구하는 문제.
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in ) ;
        int N = sc.nextInt();
        ArrayList<Integer> have = new ArrayList<>();
        for ( int i = 0 ; i < N; i++ )
            have.add( sc.nextInt() );

        ArrayList<Integer> want = new ArrayList<>();

        for ( int i = 0 ; i < N; i++ )
            want.add( sc.nextInt() );

        Set<Integer> wantSet = new HashSet<>( want );
        // System.out.println( wantSet );

        int cnt = 0;

        int wantfreq = 0;
        int havefreq = 0;

        for (Integer value : wantSet) {
            wantfreq = Collections.frequency( want, value);
            havefreq = Collections.frequency( have, value);

            if ( wantfreq == 0 || havefreq == 0 )
                continue;
            else if ( wantfreq < havefreq )
                cnt += wantfreq;
            else if ( wantfreq == havefreq )
                cnt += wantfreq;
            else if ( wantfreq > havefreq )
                cnt += havefreq;
        }

        System.out.println( N - cnt );

    }
}
