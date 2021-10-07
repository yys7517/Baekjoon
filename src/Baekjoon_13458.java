import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_13458 {
    // 시험 감독
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

        int N = Integer.parseInt( br.readLine() );          // 시험장 개수.

        // 시험장 별 응시자 수.
        int [] Tester = new int[N];
        StringTokenizer st = new StringTokenizer( br.readLine(), " ");
        for ( int i = 0; i < N; i++ ) {
            Tester[i] = Integer.parseInt( st.nextToken() );
        }
        // 응시자 수 배열 출력해보기.
        //System.out.println(Arrays.toString(Tester) );

        //  감시할 수 있는 응시자 수.
        StringTokenizer st1 = new StringTokenizer( br.readLine()," ");

        int chong = Integer.parseInt( st1.nextToken() );         // 총 감독관이 감시할 수 있는 응시자 수.
        int boo = Integer.parseInt( st1.nextToken() );           // 부 감독관이 감시할 수 있는 응시자 수.

       // System.out.println( "총 감독관이 감시할 수 있는 응시자의 수 : " + chong );
        //System.out.println( "부 감독관이 감시할 수 있는 응시자의 수 : " + boo);
         // 각각의 시험장에 총감독관은 오직 1명만 있어야 하고, 부감독관은 여러 명 있어도 된다.

        // **** long으로 해야되는 이유 ****
        // 감독자의 수가 int의 범위를 넘을 수 있으므로.. long으로.
        // 시험장의 개수 100만개까지
        // 응시자의 수 100만명 까지..
        // 감독관 수의 최소값을 구하려면.
        long count = N;             // 최소 시험장에는 총 감독관 1명씩은 무조건 있어야 한다.

        for ( int i = 0; i < Tester.length; i++ ) {
            Tester[i] -= chong;     // 총 감독관이 1명씩 있다는 전제 하에. 응시자 수를 총 감독관이 감시할 수 있는 응시자 수 만큼 빼준다.

                                    // 그 후에도 응시자 수가 남아있다면. 부 감독관을 추가해준다.
            if ( Tester[i] > 0 ) {
                count += Tester[i] / boo;       // 부 감독관이 감시할 수 있는 수만큼 나눠주면 부 감독관 수를 구할 수 있다.
                if ( Tester[i] % boo > 0 )      // 그럼에도 나머지 값이 0이 아니면, 부 감독관 1명이 그 인원들을 감시하면 된다.
                    count += 1;
            }

        }
        System.out.println( count );

    }
}
