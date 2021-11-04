package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1673 {
    // 치킨 한 마리를 주문할 수 있는 쿠폰 n 장
    // 1마리 주문하면 도장 1개씩
    // 도장 k개이면 쿠폰 1장으로 교환 가능
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = "";
        while ( (inputStr = br.readLine()) != null ) {
            StringTokenizer st = new StringTokenizer( inputStr , " ");
            int n = Integer.parseInt( st.nextToken() );
            int k = Integer.parseInt( st.nextToken() );

            int count = n;
            while( n/k != 0 ) {
                count += n/k;
                n = n%k + n/k;
            }
            System.out.println( count );
        }
    }
}
