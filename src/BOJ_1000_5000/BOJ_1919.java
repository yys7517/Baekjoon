package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1919 {
    // 에너그램 만들기..
    // 두 단어의 문자열이 에너그램이 되게끔 할 때,
    // 제거해야하는 최소 문자의 개수를 구하라.
    // 두 단어가 어떤 순서가 되든 같게끔 하면 된다.
    // 두 단어가 구성된 알파벳의 종류와 개수가 똑같아야 한다.
    // bcb
    // cbb 등..
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int [] a = new int[26];
        for (int i = 0; i <s1.length(); i++) {
            a[ s1.charAt(i) - 'a']++;
        }
        int [] b = new int[26];
        for (int i = 0; i <s2.length(); i++) {
            b[ s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs( a[i] - b[i] );
        }
        System.out.print( count );
//        char[] a = br.readLine().toCharArray();
//        char[] b = br.readLine().toCharArray();
//        int total_length = a.length + b.length ;
//        int count = 0;
//
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < b.length; j++) {
//                if ( a[i] == b[j] && a[i] != '\0' && b[j] != '\0' ) {
//                    a[i] = '\0';
//                    b[j] = '\0';
//                    count++;
//                }
//
//            }
//        }
//
//        System.out.print( total_length - count );

    }
}
