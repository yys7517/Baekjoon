package BOJ_15000_20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17608 {
    // 막대기
    // 오른쪽에서 봤을 때 보이는 막대기의 수.
    // 보이는 막대기의 수는 보는 방향의 첫 번째에 있는 막대기보다 뒤에있고, 높이가 높아야 한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int length = Integer.parseInt( br.readLine() );
        // 막대기들이 배치된 열의 길이..

        int [] sticks = new int[ length ];
        for (int i = 0; i < length; i++) {
            sticks[i] = Integer.parseInt( br.readLine() );
        }
        int count = 1;                  // 막대기는 최소 1개 보일 것.
        int height = sticks[length-1];  // 초기 높이 값.

        for (int i = length - 2 ; i >= 0  ; i-- ) {
            // 초기 높이 값 보다 높은 막대기를 만나게 되면..
            // 다음부터는 그 막대기보다 높은 막대기만 보이게 된다.
            if( height < sticks[i] ) {
                count++;
                height = sticks[i];
            }

        }
        System.out.println( count );

    }
}
