import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int M = sc.nextInt();
        int N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        int start = (int)Math.sqrt(M);
        int end = (int) Math.sqrt(N);

        if ( M == start ) {
            for ( int i = start; i <= end; i++ ) {
                list.add ( i * i );
            }
        }
        else if ( M > start ) {
            for ( int i = start + 1; i <= end; i++ ) {
                list.add( i * i );
            }
        }

        int sum = 0;
        for ( Integer value : list )
            sum += value;

        if ( list.isEmpty() ) {
            System.out.println(-1);
        }
        else {
            System.out.println( sum );
            System.out.println( list.get(0) );
        }

    }
}
