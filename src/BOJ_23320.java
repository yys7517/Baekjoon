import java.util.Arrays;
import java.util.Scanner;

public class BOJ_23320 {
    // 홍익 절대평가
    // N명의 학생
    // 상대평가 시 A 학점의 비율 X %
    // 절대평가 시 A 학점은 Y점 이상인 사람들.
    // 출력 - 상대평가 시 A학점을 받는 학생 수, 절대평가 시 A학점을 받는 학생 수
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt(); // 학생 수

        int [] scores = new int[ N+1 ];     // 점수 배열
        for (int i = 1; i <= N; i++) {
            scores[i] = sc.nextInt();
        }
        int X = sc.nextInt();       // 상대 평가 시 A학점의 비율.
        int Y = sc.nextInt();       // 절대 평가 시 A학점의 점수

        //System.out.println( "X = "+X+" Y = " + Y);


        // N의 X %
        int cntX = Math.floorDiv( N * X , 100 ) ;  // 상대평가 시 A 학점 학생 수.
        int cntY = 0;   // 절대평가 시 A 학점 학생 수.

        Arrays.sort( scores );
        for (int i = 1; i <= N; i++) {
            if ( scores[i] >= Y )
                cntY++;
        }
        System.out.print(cntX +" " +cntY);
    }
}
