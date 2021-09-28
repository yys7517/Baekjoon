import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1번 데이터는 1번 컴퓨터, 2번 데이터는 2번 컴퓨터, 3번 데이터는 3번 컴퓨터, ... ,
//10번 데이터는 10번 컴퓨터, 11번 데이터는 1번 컴퓨터, 12번 데이터는 2번 컴퓨터, ...
// 데이터의 개수가 a의 b승 개가 있을 때, 마지막 번째의 데이터는 몇번 컴퓨터가 처리하는지 출력하는 문제.

public class Baekjoon_1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];

        for ( int i = 0; i < N; i++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            result[i] = solve(a,b);
        }
        for ( int a : result ) {
            System.out.println( a );
        }

    }

    public static int solve(int a, int b) {
        int answer = 0;

        // 1 ~ 10의 지수승의 규칙을 찾아낸 배열.
        // 0번 인덱스는 인덱스의 값을 1 ~ 10에 맞추기 위해서 하나 더 선언을 해두었다.
        // 1 ~ 10의 지수승의 경우, 마지막 일의 자리 규칙은 이러하다.
        // 규칙과 같이 일의자리가 반복된다.
        String[] rule = {"0", "1", "2486", "3971", "46", "5", "6", "7931", "8426", "91", "0"};

        // 정수의 일의 자리를 구한다.
        // 일의 자리가 1 : 1번 컴퓨터 ~ 9 : 9번 컴퓨터
        // 일의 자리가 0 : 10번 컴퓨터.
        int a_1 = a % 10;

        // a의 일의 자리가 0
        // 문제에서 a는 0보다 크기 때문에 밑이 10인 지수승의 개수만큼 데이터가 주어진다.
        // 따라서 마지막 데이터는 10번 컴퓨터가 처리하게 된다.
        if ( a_1 == 0 ) {
            answer = 10;

            return answer;
        }
        // 데이터의 개수가 1과 5와 6의 지수승일 경우,
        // 1 : 데이터 1개 첫 번째이자 마지막 데이터 ( 1번 컴퓨터가 처리 )
        // 5 : 데이터 xx5개 ex) 5, 25, 125, 625     ( 5번 컴퓨터가 처리 )
        // 6 : 데이터 xx6개 ex) 6, 36, 216          ( 6번 컴퓨터가 처리 )
        else if ( a_1 == 1 || a_1 == 5 || a_1 == 6 ) {       // 1 5 6
            answer = a_1;

            return answer;
        }

        // 데이터의 개수가 4와 9의 지수승일 경우...
        // 4가 밑일 경우 : 데이터의 개수는 xx4개,xx6개 둘 중 하나이다. ex) 4, 16, 64, 256, 1024 ..... (4번 또는 6번 컴퓨터가 처리)
        //                                                                                             이 때, 지수승이 홀수일 경우, 4번 컴퓨터가 마지막 데이터 처리
        //                                                                                             이 때, 지수승이 짝수일 경우, 6번 컴퓨터가 마지막 데이터 처리.

        // 9가 밑일 경우 : 데이터의 개수는 xx4개,xx6개 둘 중 하나이다. ex) 9, 81, 729, 6561.....      (9번 또는 1번 컴퓨터가 처리)
        //                                                                                             이 때, 지수승이 홀수일 경우, 9번 컴퓨터가 마지막 데이터 처리
        //                                                                                             이 때, 지수승이 짝수일 경우, 1번 컴퓨터가 마지막 데이터 처리.
        // String[] rule = {"0", "1", "2486", "3971", "46", "5", "6", "7931", "8426", "91", "0"};
        else if ( a_1 == 4 || a_1 == 9) {
            if ( b % 2 == 1 )       // 지수승이 홀수이면 첫번째 값.
                answer = Integer.parseInt(rule[a_1].charAt(0) + "");
            else if ( b % 2 == 0 )   // 지수승이 짝수이면 두번째 값.
                answer = Integer.parseInt(rule[a_1].charAt(1) + "");


            return answer;
        }

        // 데이터의 개수가 2,3,7,8의 지수승일 경우....
        // 2,3,7,8의 지수승의 데이터 개수가 있다면, 마지막데이터의 일의 자리는 이 4자리로 반복된다.
        // 2 - "0486"
        // 3 - "3971"
        // 7 - "7931"
        // 8 - "8426"
        // 이하 설명 생략........
        // String[] rule = {"0", "1", "2486", "3971", "46", "5", "6", "7931", "8426", "91", "0"};

        else if( a_1 == 2 || a_1 == 3 || a_1 == 7 || a_1 == 8 ) {      // 20  40  60  80  100 200
            // 2 3 7 8
            if (  b % 4 == 0 ) {    // 지수승이 4로 나눠지면 규칙의 마지막 값 번의 컴퓨터가 마지막 데이터를 처리.
                answer = Integer.parseInt( rule[a_1].charAt( 3 ) +"");
            }
            else                    // 지수승이 4로 나눠지지 않을 경우, 4로 나눈 나머지 값 번째 인덱스에 위치하는 번의 컴퓨터가 마지막 데이터를 처리.
                answer = Integer.parseInt( rule[a_1].charAt( (b % 4) - 1 ) +"");


            return answer;
        }


        return answer;
    }
}
