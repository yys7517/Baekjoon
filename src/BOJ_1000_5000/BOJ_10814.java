package BOJ_1000_5000;

import java.util.*;

public class BOJ_10814 {
    // 나이순 정렬..
    // 인원 수를 입력받고
    // "나이 이름" 꼴로 입력을 받아서
    // 나이 순으로 "나이 이름" 꼴로 출력하는 문제..


    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt(); // 인원 수..
        /*

        // HashMap
        // 생각해보니까 키 값이 중복이 되면 안된다..
        // 이름을 Key 값으로 나이를 Value 값으로
        HashMap<String, Integer> map = new HashMap<>( N );

        for (int i = 0; i < N; i++) {
            int Value = sc.nextInt();
            String Key = sc.next();
            map.put ( Key, Value );
        }
        // Map 을 정렬할 때
        // 1단계. Map의 EntrySet을 리스트에 담는다.
        // **************************
        List< Map.Entry<String, Integer> > entryList = new ArrayList<>( map.entrySet() );

        // 회원을 나이 순, 나이가 같으면 가입한 순
        // 나이 오름차순 정렬..
        Collections.sort( entryList , new Comparator< Map.Entry<String, Integer> >() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {


                // 오름차순 정렬..
                 return o1.getValue().compareTo( o2.getValue() );

                // 내림차순 정렬.
                // return o2.getKey().compareTo( o1.getKey() );
            }
        });

        for( Map.Entry<String, Integer> entry : entryList)
            System.out.println(entry.getValue() + " " + entry.getKey());

         */
        String [][] arr = new String[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.next();  // 나이
            arr[i][1] = sc.next();  // 이름
        }

        // 나이를 오름차순
        // [0]
        Arrays.sort(arr, new Comparator< String[] >() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt( o1[0] ) - Integer.parseInt( o2[0] );
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println( arr[i][0] + " " + arr[i][1] );
            //  "나이 이름"
        }

    }
}
