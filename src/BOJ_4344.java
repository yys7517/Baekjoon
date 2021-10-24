import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in) );

        // 결과를 담기 위한 리스트 선언.
        // 평균을 넘는 학생의 퍼센티지 값이 담김.
        ArrayList<Double> result = new ArrayList<>();

        int TestCase = Integer.parseInt( br.readLine() );
        for (int i = 0; i < TestCase; i++) {
            int count = 0;          // 평균이 넘는 학생 수.
            int sum = 0;            // 평균을 구하기 위한 총합 값.
            double avg = 0;         // 평균 변수 선언.

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt( st.nextToken() );     // 첫 번째 토큰 = 학생 수

            ArrayList<Integer> list = new ArrayList<>( N );     // 학생 수의 크기의 점수를 담는 list

            while( st.hasMoreTokens() ) {
                int temp = Integer.parseInt( st.nextToken() );
                list.add( temp ) ;
                sum += temp;
            }
            avg = (double)sum / N;

            Iterator<Integer> ir = list.iterator();
            while (ir.hasNext()) {
                if ( ir.next() > avg )
                    count++;                // list를 돌면서 그 점수가 평균보다 클 경우
                                            // 평균보다 높은 학생 수인 count 값 1 증가.
            }

            result.add( ( (double)count / N )  * 100 );     // 결과 리스트인 result 에 퍼센트 값 add
        }
        for ( double value : result ) {
            System.out.printf("%.3f",value);
            System.out.println("%");
        }
    }
}
