package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24040 {
    // 예쁜 케이크

    // 케이크는 높이가 1이고, 부피가 N인 직육면체 모양이다.
    // (부피) = (넓이) * (높이)
    // N = N * 1
    // 따라서 N 값이 주어지면, 이 N 값은 넓이 값이 된다.

    // 예쁜 케이크가 되기 위해서는
    // 띠를 딱 맞게 두를 수 있을 때, 예쁜 케이크가 된다.
    // 장식용 띠는 빨간색,초록색,하얀색이 번갈아 가면서 이루어진다.
    // 띠의 빨간색 초록색 하얀색은 같은 개수만큼 나와야 한다.
    // 적절히 칼질해서 한 변의 길이가 1인 정육면체 모양 조각 N개로 나눌 수 있어야 한다.

    // ex) N = 10 일때,
    // 가로 : 1, 세로 : 10 or 가로 : 2, 세로 : 5
    // 둘레 22 ( 빨초흰 빨초흰 빨초희 빨초흰 빨초흰 빨초흰 빨초흰 빨 )
    // 둘레 14 ( 빨초흰 빨초흰 빨초흰 빨초희 빨초 )

    // N = 8 일때,
    // 가로 : 1, 세로 : 8 or 가로 : 2, 세로 : 4
    // 둘레 18 ( 빨초흰 빨초흰 빨초흰 빨초흰 빨초흰 빨초흰 )
    // 둘레 12 ( 빨초흰 빨초흰 빨초흰 빨초흰 )


    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt( br.readLine() );

        // 테스트 케이스 수 만큼 반복. ( 1 <= T <= 1000 )
        for (int i = 0; i < T; i++) {
            // boolean bl = false;

            long N = Long.parseLong( br.readLine() );   // ( 1 <= N <= 10^18 )

            /*
            // 소수이면서
            if ( isPrime(N) ) {
                //1과 자기 자신의 합이 3으로 나눠질 때
                if (  N+1 % 3 == 0 )
                    sb.append("TAK").append('\n');
                else
                    sb.append("NIE").append('\n');
            }
            // 소수가 아닐 때는 진짜 약수를 사용하여 판별하자.
            // 진짜 약수란 ? 1과 자기 자신을 제외한 약수를 말한다.
            // 진짜 약수의 개수가 1개 일때 ? 그 값이 3으로 나눠지는 지 확인
            // 진짜 약수의 개수가 1개보다 많고 짝수 개일때 ? 1 2 3 4 6 12
            // 2랑 6, 3과 4
            // 진짜 약수의 개수가 1개보다 많고 홀수 개일때 ? 1 2 4 8 16
            // arr[mid] % 3 == 0 ? || 2와 8
            else {

            }
             */
            // long tmp = (long) Math.sqrt( N );
            if( N % 3 == 2 )
                sb.append("TAK").append('\n');
            else if ( N % 3 == 0  ) {
                // System.out.println( N/3 );
                if( (N/3) % 3 == 0 )
                    sb.append("TAK").append('\n');
                else
                    sb.append("NIE").append('\n');
            }
            else // N % 3 == 1
                sb.append("NIE").append('\n');

            // tmp : 가로 ?
            // N / tmp : 세로

//            if( tmp * ( N / tmp ) == N ) {
//                if (  ( tmp % 3  + ( N / tmp  ) % 3 ) % 3 == 0 )
//                    sb.append("TAK").append('\n');
//            }
//            else {
//                if ( N + 1 % 3 == 0 )
//                    sb.append("TAK").append('\n');
//                else
//                    sb.append("NIE").append('\n');
//            }

            /*
            for (long j = 1; j <= Math.sqrt(N) ; j++) {
                if( N % j == 0 ) {
                    if( j * j == N ) {
                        if ( j % 3 == 0 ) {
                            bl = true;
                            break;
                        }
                    }
                    else {
                        if ( ( j % 3 + (N/j) % 3 ) % 3 == 0 ) {
                            bl = true;
                            break;
                        }
                    }
                }
            }
             */

            /*
            for (long j = 1; j*j <= N; j++) {
                // j가 N의 약수 일 때, j * (N/j) 는 N이 된다.
                // 가로와 세로로 이루어진 직육면체의 둘레가 3으로 나눠지는가?
                if( N % j == 0 ) {
                    // long length = 2 * ( j + (N/j) )  ; // 둘레 ?
                    long result = j % 3 + (N/j) % 3 ;
                    if ( result == 0 ) {
                        bl = true;
                        break;
                    }
                }
            }
             */

            /*
            N = 1 일때, X  1
            N = 2 일때, O  1 2
            N = 3 일때, X  1 3
            N = 4 일때, X  1 2 4
            N = 5 일때, O  1 5
            N = 6 일때, X  1 2 3 6
            N = 7 일때, X  1 7
            N = 8 일때, O  1 2 4 8
            N = 9 일때, O  1 3 9
            N = 10일때, X  1 2 5 10


            N = 11일때, O  1 11
            N = 12일때, X  1 2 3 4 6 12
            N = 13일때, X  1 13
            N = 14일때, O  1 2 7 14
            N = 15일때, X  1 3 5 15
            N = 16일때, X  1 2 4 8 16
            N = 17일때, O  1 17
            N = 18일때, O  1 2 3 6 9 18
            N = 19일때, X  1 19
            N = 20일때, O  1 2 4 5 10 20

            N = 21일때, X  1 3 7 21
            N = 22일때, X  1 22
            N = 23일때, O  1 23
            N = 24일때, X  1 2 3 4 6 8 12 24
            N = 25일때, X  1 5 25
            N = 26일때, O  1 26
            N = 27일때, O  1 3 9 27
            N = 28일때, X  1 2 14 28
            N = 29일때, O  1 29
            N = 30일때, X  1 2 3 5 6 10 15 30

            N = 31일때, X  1 31
            N = 32일때, O  1 2 4 8 16 32
            N = 33일때, X  1 3 11 33
           */

            // 위를 통해 규칙을 찾아 낼 수 있다..
            // 1. N % 3 == 2 ? --> TAK, 예쁜 케이크를 만들 수 있다.
            // 2. N % 3 == 0 ? N이 3으로 나눠질 때, ( N / 3 )값이 3으로 또 나눠지는지 확인한다.
            //                  ( N / 3 ) % 3 == 0 -- > TAK
            //                  else --> NIE
            // 3. N % 3 == 1 --> NIE
        }
        System.out.println( sb );
    }

    /*
    private static boolean isPrime( long N ) {
        if ( N == 2 || N == 3 )
            return true;
        else {
            for (long i = 2 ; i <= Math.sqrt( N ) ; i++) {
                if ( N % i == 0 )
                    return false;
            }
            return true;
        }
    }
     */
}
