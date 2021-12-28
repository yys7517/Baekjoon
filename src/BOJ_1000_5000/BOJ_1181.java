package BOJ_1000_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1181 {
    // 단어정렬

    // 정렬 우선순위
    // 1. 길이가 짧은 것 부터
    // 2. 길이가 같다면, 사전순으로

    // 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        int N = Integer.parseInt( br.readLine() );
        Set<String> wordsSet= new HashSet<>();
        for (int i = 0; i < N; i++) {
            wordsSet.add( br.readLine() );
        }

        ArrayList<String> words = new ArrayList<>(wordsSet);

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if( o1.length() != o2.length() )
                    return o1.length() - o2.length();
                else
                    return o1.compareTo(o2);
            }
        });
        Iterator<String> ir = words.iterator();
        while ( ir.hasNext() ) {
            System.out.println( ir.next() );
        }

    }
}
