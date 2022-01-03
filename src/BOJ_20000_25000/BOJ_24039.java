package BOJ_20000_25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_24039 {
    // 2021은 무엇이 특별할까 ?

    // 특별한 수 ?
    // 연속된 소수의 곱으로 이루어진 수를 이 문제에서는 특별한 수라고 한다.

    // 예를 들면 값
    // 주어진 수 보다 큰 특별한 수 중 가장 작은 수를 구하는 프로그램
    // 주어진 수 N : 1 <= N <= 10000

    // 1이 입력되었을 때 : 6
    // 10000이 입력되었을 때 : 10403까지의 연속된 소수들의 곱만 구하면된다.

    // p와 q가 소수이며 p 초과, q 미만의 소수가 존재하지 않을 때, p와 q를 연속한 소수라고 한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

        int N = Integer.parseInt( br.readLine() );

        // 연속된 소수들의 곱을 담을 list
        ArrayList<Integer> mulList = new ArrayList<>();

        for (int p = 2; p < 199 ; p++) {
            if( isPrime(p) ) {  // p가 소수이고
                for (int q = p + 1 ; q < 200 ; q++) {
                    // p,q가 소수이고, p와 q가 연속된 소수이면.
                    if( isPrime( q ) && ContinuousPrime( p , q ) ) {
                        mulList.add( p*q );     // 두 수의 곱을 리스트에 담는다.
                        // System.out.println( p + " , " + q + " : " + p*q);
                        break;      // q를 증가시키는 for문을 break 하여 p를 증가시키고
                                    // q=p+1 부터해서 다시 반복문에 진입한다.
                    }
                }
            }
        }
        //System.out.println( mulList );

        for (int i = 0; i < mulList.size(); i++) {
            if( mulList.get(i) > N ) {  // N 보다 큰 값이 있을 때, 그 값을 출력하고 반복문을 종료한다.
                // 값이 담길 때 오름차순으로 담겨있어서 그 값이 N보다 크면서 가장 작은 두 연속된 소수의 곱이된다.
                System.out.println( mulList.get(i) );
                break;
            }
        }

    }


    // p와 q가 소수이며 p 초과, q 미만의 소수가 존재하지 않을 때, p와 q를 연속한 소수라고 한다.
    // 연속된 소수인지 판별하는 메서드
    private static boolean ContinuousPrime(int p, int q) {
        if( isPrime( p ) && isPrime( q ) ) {
            for (int i = p+1 ; i < q; i++) {
                if ( isPrime(i) )
                    return false;
            }
            return true;
        }
        else
            return false;
    }

    // 소수인지 판별하는 메서드
    public static boolean isPrime( int number ) {
        if( number == 2 || number == 3 )   // 2와 3은 소수이다.
            return true;
        else {
            // 소수를 나눌 때, 1과 자기 자신을 제외한 수로 나눠지는 지 확인해본다.
            // 2부터 자기 자신 number 까지 나눠지는 지 확인을 해봐도 되긴하는데,
            // 2부터 number의 제곱근까지의 수로 나눠지는지만 확인해도 된다.
            for (int i = 2; i <= Math.sqrt( number ) ; i++) {
                if( number % i == 0 )
                    return false;
            }
        }
        return true;
    }
}
