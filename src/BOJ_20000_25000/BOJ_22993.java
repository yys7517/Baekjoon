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

        // 전체공격력의 합을 구하자.
        long powersum = 0;
        for (int i = 0; i < power.length; i++) {
            powersum += power[i];
        }
        // 전체 공격력의 합을 구하는 이유는 최종 생존자는 전체 공격력의 합에 해당하는 공격력을 가지게 된다.

        // 준원이를 제외한 사람들의 공격력을 배열로 만든다.
        // power 1번 인덱스부터 N-1번 인덱스까지의 배열을 복사한다.
        int [] others = Arrays.copyOfRange( power , 1 , N);
        // System.out.println( powersum );
        // System.out.println( Arrays.toString( others ));

        // 준원이는 어떤 순서로든 이기기만 하면되므로, 제일 약한 상대와 싸워가면서 최종 생존하게 될 것이다.
        // others 배열을 정렬시키면, 가장 낮은 공격력부터 높은 공격력 순서대로 정렬이 되므로 낮은 공격력의 상대와 비교해간다.
        Arrays.sort( others );
        for (int i = 0; i < others.length; i++) {
            // 준원이가 공격력이 더 높고, 그 사람이 죽지 않았으면.
            if ( jw > others[i] && others[i] != 0 ) {
                jw += others[i];        // 준원이는 승리하고, 그 사람의 공격력만큼을 가져간다.
                others[i] = 0;          // 죽은사람은 공격력을 0으로 바꿔준다.
            }
            else
                break;              // 오름차순 정렬을 하였으니, 준원이보다 공격력이 높은 상대를 만난다면 반복문을 진행할 필요 X
        }

        // 준원이를 제외한 다른 사람들의 배열을 출력하여 죽었는 지( 값 : 0 ? ) 확인하였다.
        // System.out.println( Arrays.toString( others ));

        // 준원이의 공격력이 전체 공격력 합과 같다면 최종 생존
        if ( jw == powersum ) {
            System.out.print("Yes");
        }
        // 아니라면 준원이는 생존하지 못했다.
        else
            System.out.println("No");

    }
}
