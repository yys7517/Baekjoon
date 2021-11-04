package BOJ_20000_25000;

import java.util.Scanner;

public class BOJ_23037 {
    // 5의 수난
    // 각 자릿수의 5제곱을 하여 합을 구하라.
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        int number = sc.nextInt();

        int sum = 0;
        while ( number > 0 ) {
            int temp = number % 10;
            int a = 1;
            for ( int i = 0; i < 5; i++ ) {
                a *= temp;
            }
            number /= 10;
            sum += a;
        }
        System.out.print(sum);
    }
}
