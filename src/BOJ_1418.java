import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1418 {
    // 소인수의 개념 = 어떤 수의 약수이자 소수.
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Integer> result = new ArrayList<>();

        for ( int i = 1; i <= N; i++ ) {
            int temp = i;

            for ( int j = 2; j <= K; j++ ) {
                while ( temp % j == 0 ) {
                    temp /= j;
                }
                // 36 = 2^2 * 3^2 이다. 이 때의 소인수는 2,3
                // 따라서 2로 나눠질 때까지 계속 나누고 K까지 나눠질 때까지 계속 나눈다.
                // 2부터 K 만큼 나눠지는 만큼 나눈다.
            }
            // 2 ~ K 까지 나눈 후의 값이 1이면 K-세준수이다.
            // 2부터 K의 수로만 N을 표현할 수 있다.
            // K의 값이 소인수의 최대가 되는 것을 뜻한다.
            if ( temp == 1 )
                result.add( i );
        }

        // 시간초과 코드.........
        // 1부터 N 사이의 자연수를 X라고 할 때,
        // X의 약수 및 자연수를 모두 구했다..
        // 그리고 X가 소수인지 비교도 하였다.
        /*
        for ( int i = 1; i <= N; i++ ) {


            for ( int j = 1; j <= i; j++ ) {
                if ( i % j == 0 )
                    Yaksoo.add( j );
            }
            // System.out.println( "Yaksoo = " + Yaksoo.toString() );

            boolean flag = true;

            // 소수이면서 약수에 해당되는 값이 소인수이다

            for ( int j = 1; j <= i; j++ ) {
                // i 값이 약수가 아니라면 indexOf() 함수가 -1을 반환한다.
                //                          Yaksoo 리스트에서 찾지 못했다는 뜻. ( Yaksoo = 약수가 담긴 리스트 )
                if ( isPrime( j ) && Yaksoo.indexOf( j ) != -1 ) {      // 소수이면서 약수에 해당되는가 ?
                    if ( j > K ) {
                        flag = false;
                        break;
                    }
                    else
                        Soinsoo.add( j );      // list는 소인수를 담는 리스트.
                }
            }
            // System.out.println( "Soinsoo = " + Soinsoo.toString() );
            if ( Soinsoo.get( Soinsoo.size() - 1 ) <= K && flag )
                result.add( i );
            else if ( ! flag ) {
                continue;
            }
        }*/
        //System.out.println( "result = " + result.toString() );
        System.out.println( result.size() );
    }
    // 소수 구하는 함수 정의..
    // Number가 소수인지 확인할 수 있는 메서드이다.
    // 소수란, 약수가 1과 자기 자신으로만 이루어지는 수이다.
    // 이 때, 2부터 자신의 제곱근 까지의 수만 확인해도 된다.
    // 2부터 자신의 제곱근 까지의 수로 자신이 나누어지는지 확인한다.
    // 나누어진다면, 소수가 아니므로 false를 리턴한다.
    // 2 ~ 제곱근 까지의 수로 나누어지지 않는다면, 소수이다. return true.
/*
    private static boolean isPrime(int Number) {
        for ( int i = 2; i*i <= Number; i++ ) {
            if ( Number % i == 0 )
                return false;
        }
        return true;
    }
 */
}
