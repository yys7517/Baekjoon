package BOJ_1000_5000;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_2755 {
//    A+: 4.3, A0: 4.0, A-: 3.7
//
//    B+: 3.3, B0: 3.0, B-: 2.7
//
//    C+: 2.3, C0: 2.0, C-: 1.7
//
//    D+: 1.3, D0: 1.0, D-: 0.7
//
//    F: 0.0
    public static void main(String[] args) {
        HashMap<String,Double> map = new HashMap<>();
        PutValue(map);

        Scanner sc = new Scanner( System.in );
        int Case = sc.nextInt();
        int scoresum = 0;
        double sum = 0.0;
        for ( int i = 0; i < Case; i++ ) {
            String title = sc.next();
            int score = sc.nextInt();
            String grade = sc.next();

            sum += score * map.get(grade);
            scoresum += score;

        }
        System.out.printf("%.2f",  sum / scoresum );
    }

    private static void PutValue(HashMap<String, Double> map) {
        map.put("A+",4.3);
        map.put("A0",4.0);
        map.put("A-",3.7);
        map.put("B+",3.3);
        map.put("B0",3.0);
        map.put("B-",2.7);
        map.put("C+",2.3);
        map.put("C0",2.0);
        map.put("C-",1.7);
        map.put("D+",1.3);
        map.put("D0",1.0);
        map.put("D-",0.7);
        map.put("F",0.0);
    }
}
