import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_3009 {
    // 네 번째 점
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] v1  = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        st = new StringTokenizer(br.readLine(), " ");
        int[] v2  = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        st = new StringTokenizer(br.readLine(), " ");
        int[] v3  = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

        int x,y;

        if ( v1[0] == v3[0] )
            x = v2[0];
        else if ( v1[0] == v2[0] )
            x = v3[0];
        else
            x = v1[0];

        if ( v1[1] == v3[1] )
            y = v2[1];
        else if ( v1[1] == v2[1] )
            y = v3[1];
        else
            y = v1[1];

        System.out.println(x +" "+ y);

    }
}
