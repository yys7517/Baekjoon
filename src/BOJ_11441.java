import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt();
        int[] numbers = new int[ N+1 ];
        int [] sum = new int[ N+1 ];
        for ( int i = 1; i <= N; i++ ) {
            numbers[i] = sc.nextInt();
            if ( i == 1 )
                sum[i] = numbers[i];
            else    // sum[i] - sum[i-1] = numbers[i]
                sum[i] = sum[i-1] + numbers[i];
                    // 다음 번째 합은 그 전까지의 합 + 그 숫자
        }
        int M = sc.nextInt();
        int [] result = new int[ M ];
        for (int i = 0; i < M ; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            // 합에 start의 값도 포함해야하기 때문에
            // end까지의 합에서 start - 1까지의 합을 빼주면 start부터 end까지의 합을 구할 수 있다 - 구간 합 알고리즘
            // prefix sum algorithm
            result[i] = sum[end] - sum[start - 1];

        }
        // System.out.println("sum = " + Arrays.toString( sum ));
        for ( int value : result )
            System.out.println( value );
    }
}
