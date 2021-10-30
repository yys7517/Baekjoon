import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1292 {
    // 쉽게 푸는 문제

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int start = sc.nextInt() ; // 3
        int end = sc.nextInt() ;  // 7

        ArrayList<Integer> list = new ArrayList<>();
        int number = 1;
        loop : while ( true ) {
            for ( int i = 0; i < number; i++ ) {
                list.add( number );
                if ( list.size() == end )
                    break loop;
            }
            number++;
        }
        //System.out.println( list );
        int sum = 0;
        for (int i = start -1 ; i < end  ; i++) {
            sum += list.get(i);
        }
        System.out.println( sum );



    }
}
