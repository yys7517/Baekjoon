package BOJ_5000_10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int cost = Integer.parseInt( br.readLine() );
        int count = 0;
        int change = 1000 - cost;

        while ( change > 0 ) {
            if ( change >= 500 ) {
                count += change / 500;
                change = change % 500;
            }
            else if ( change >= 100 ) {
                count += change / 100;
                change = change % 100;
            }
            else if ( change >= 50 ) {
                count += change / 50;
                change = change % 50;
            }
            else if ( change >= 10 ) {
                count += change / 10;
                change = change % 10;
            }
            else if ( change >= 5 ) {
                count += change / 5;
                change = change % 5;
            }
            else if ( change >= 1 ) {
                count += change / 1;
                change = change % 1;
            }
        }
        System.out.println( count );
    }
}
