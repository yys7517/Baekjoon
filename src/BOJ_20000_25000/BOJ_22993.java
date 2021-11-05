package BOJ_20000_25000;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_22993 {
    // 서든어택 3
    // 공격력이 X인 플레이어 A가 공격력이 Y인 플레이어 B를 공격
    // 공격력이 낮은 사람은 죽고, 높은 사람이 이기게되며, 높은 사람의 공격력은 X+Y가 된다.
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt(); // 플레이어 수
        int [] power = new int[ N ];
        for (int i = 0; i < N; i++) {
            power[i] = sc.nextInt();
        }
        // 준원이의 공격력은 power[0]
        long jw = power[0];
        long powersum = 0;
        for (int i = 0; i < power.length; i++) {
            powersum += power[i];
        }

        int [] others = Arrays.copyOfRange( power , 1 , N);
        // System.out.println( powersum );
        // System.out.println( Arrays.toString( others ));

        Arrays.sort( others );
        for (int i = 0; i < others.length; i++) {
            if ( jw > others[i] && others[i] != 0 ) {
                jw += others[i];
                others[i] = 0;
            }
            else
                break;
        }
        System.out.println( Arrays.toString( others ));
        if ( jw == powersum ) {
            System.out.print("Yes");
        }
        else
            System.out.println("No");

    }
}
