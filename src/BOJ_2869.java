import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 낮에 A미터 올라감
        // 밤에 B미터 미끄러짐
        // 높이 V
        // 정상에 도달할 시 미끄러지지 않는다.

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt( st.nextToken());
        int B = Integer.parseInt( st.nextToken());
        int V = Integer.parseInt( st.nextToken());


        int days = (V-B) / (A-B);

        if ( (V-B) % (A-B) != 0 ) {
            days++;
        }

        System.out.println(days);
    }
}
