package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_1032 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] fileName = new String[N];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            fileName[i] = br.readLine();
        }

        char temp;
        boolean question;

        for (int i = 0; i < fileName[0].length(); i++) {
            temp = fileName[0].charAt(i);
            question = false;
            for (int j = 1; j < N ; j++) {
                if ( temp != fileName[j].charAt(i)) {
                    question = true;
                    break;
                }
            }
            if ( question )
                sb.append("?");
            else
                sb.append(temp);
        }
        System.out.print(sb.toString().trim());
    }
}
        // 명령 프롬프트
        //이 문제는 검색 결과가 먼저 주어졌을 때, 패턴으로 뭘 쳐야 그 결과가 나오는지를 출력하는 문제이다.
        // 패턴에는 알파벳과 "." 그리고 "?"만 넣을 수 있다. 가능하면 ?을 적게 써야 한다.
        // 디렉토리에는 검색 결과에 나온 파일만 있다고 가정하고, 파일 이름의 길이는 모두 같다.

        // 첫째 줄에 파일 이름의 개수 N이 주어진다. 둘째 줄부터 N개의 줄에는 파일 이름이 주어진다.
        // N은 50보다 작거나 같은 자연수이고 파일 이름의 길이는 모두 같고 길이는 최대 50이다.
        // 파일이름은 알파벳 소문자, "." 그리고 "?"로만 이루어져 있다.



//            if ( i == 0 ) {
//                fileName[i] = br.readLine();
//                continue;
//            }
//            else  {
//                fileName[i] = br.readLine();
//                if (! ( fileName[i-1].length() == fileName[i].length() )  ) {
//                    System.out.println("파일 길이 동일하지 X");
//                    break;
//                }
//                else
//                    continue;
//
//            }
//        }
        // System.out.println(Arrays.toString( fileName ) );



//        for ( int i = 0 ; i < fileName[0].length(); i++ ) {
//            if ( fileName[0].charAt(i) == fileName[1].charAt(i) )
//                sb.append( fileName[0].charAt(i) );
//            else {
//                sb.append( "?" );
//            }
//        }


