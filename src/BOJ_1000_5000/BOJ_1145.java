package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1145 {
    // 적어도 대부분의 배수.
    // 다섯 개의 자연수.
    // 위의 수 중 적어도 세 개로 나누어지는 가장 작은 자연수.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int [] input = new int[5];

        int idx = 0;        // input 배열의 인덱스 값.
                            // 값을 담기위해 0부터 증가해가면 토큰을 Integer로 변환 후 담는다.
        while( st.hasMoreTokens() ) {
            input[idx++] = Integer.parseInt( st.nextToken() );
        }

        // ***********************************************************************
        // 최소값 구하자.
        // 최소값 구하는 이유.
        // 최소값을 구해서 배열을 돌며 계속 나눠지는지 확인한다.
        // 나눠지는 개수가 3개이상이 안될경우 (적어도 3개의 배수)
        // 최소값을 1씩 증가시켜가며 나눠가기 위함.
        // 최소값이 결국엔 적어도 3개 이상의 수의 공배수가 될 것.
        // *************************************************************************

        int min = input[0];

        for ( int i = 1; i < input.length; i++ ) {
            if ( min > input[i] )
                min = input[i];
        }

        //System.out.println(Arrays.toString(input));
        //System.out.println(min);
        // min = 30;    << 최소값이 30으로 구해졌다.

        int cnt = 0;    // 몇 개랑 나눠지는지 확인하기 위한 count
        int minmul;     // 공배수가 될 값 선언.

        while (true) {

            for (int i = 0; i < 5; i++) {       // 배열을 돌면서 나눠지는지 확인한다.
                if ( min % input[i] == 0 )
                    cnt++;
            }

            if( cnt >= 3 )   {  // 3개 이상이랑 나눠졌으면 break
                minmul = min;   // 3개 이상이랑 나눠졌을 때의 min 값은 결국 최소 세개의 수의 공배수가 된다.
                break;
            }

            else {          // 3개 이상이랑 안나눠졌다면
                cnt = 0;    // 값을 1 증가시키고 다시 나눠보기 위해 개수 초기화.
                min++;
            }
        }

        System.out.println( minmul );


    }
}
