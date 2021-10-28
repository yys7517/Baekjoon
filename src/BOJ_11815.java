import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in) );
        int N = Integer.parseInt( br.readLine() );
        ArrayList<Integer> result = new ArrayList<>();      // 결과를 담을 .. 리스트.. 약수의 개수가 짝수 ? 홀수 ? 인지 알 수 있게.
        StringTokenizer st = new StringTokenizer( br.readLine(), " ");
        ArrayList<String> numbers = new ArrayList<>();
        while ( st.hasMoreTokens() ) {
            numbers.add( st.nextToken() );
        }
        for ( String num : numbers ) {
            int X = Integer.parseInt( num );
            ArrayList<Integer> list = new ArrayList<>();    // 약수를 담을.. 리스트..
            for ( int i = 1; i <= X; i++ ) {
                if ( X % i == 0 )
                    list.add( i );
            }
            result.add ( list.size() % 2 );
        }

        Iterator<Integer> ir = result.iterator();
        while ( ir.hasNext() ) {
            System.out.printf("%d ", ir.next());
        }

    }
}
