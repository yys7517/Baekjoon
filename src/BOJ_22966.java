import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_22966 {
    // 제일 쉬운 문제를 찾는 문제

    public static void main(String[] args) throws IOException {
        // LinkedHashMap 이 키 값을 오름차순으로 자동으로 정렬해주는 줄 알고 선언했다.
        // LinkedHashMap은 넣은 순서대로 값을 담는다.
        // 그냥 HashMap을 사용해도 무방하다.
        HashMap<String,Integer> map =  new HashMap<>();
        // 문제를 키 값으로 사용..

        // 문제와 난이도를 매치하기 위해 HashMap 인터페이스를 사용한다.

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

        int TestCase = Integer.parseInt( br.readLine() );

        for ( int i = 0 ; i < TestCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String problem = st.nextToken();
            int hard = Integer.parseInt( st.nextToken() );
            map.put( problem, hard );
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String, Integer>>( map.entrySet() );

        // 비교함수 Comparator를 사용하여 오름차순으로 정렬
        // Value = 난이도 값, 난이도 값을 기준으로 오름차순 정렬..

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            // compare로 값을 비교
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                // 오름 차순 정렬
                return obj1.getValue().compareTo(obj2.getValue());
            }
        });

        System.out.println( list.get(0).getKey() );

        /*
        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Map.Entry<String,Integer>> ir= map.entrySet().iterator();
        while (ir.hasNext()) {
            Map.Entry<String,Integer> entry = ir.next();
            int value = entry.getValue();
            list.add( value );
        }
        Collections.sort( list );
        // 컬렉션 정렬을 통해 ArrayList 를 오름차순으로 정렬.
        // 제일 앞에있는 값이 난이도가 젤 낮은 값.
        System.out.println( map.get( list.get(0) ) );
        */




    }
}

