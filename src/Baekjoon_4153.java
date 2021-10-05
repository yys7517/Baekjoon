import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_4153 {
    // 직각삼각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt( stringTokenizer.nextToken() );
            int y = Integer.parseInt( stringTokenizer.nextToken() );
            int z = Integer.parseInt( stringTokenizer.nextToken() );

            if ( x == 0 && y == 0 && z == 0 )
                break;

            if ( solve(x,y,z) )
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }

    public static boolean solve( int x, int y, int z ) {
        if((x * x + y * y) == z * z)
           return true;
        else if(x * x == (y * y + z * z))
            return true;

        else if(y * y == (z * z + x * x))
            return true;

        else
            return false;

    }
}
