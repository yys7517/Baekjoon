import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_23278 {
    // 영화 평가
    // 가장 낮은 평가 L개와 가장 높은 평가 H개를 뺀 나머지 평점의 평균.
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int N,L,H;
        N = sc.nextInt(); L = sc.nextInt(); H = sc.nextInt();
        //  평점 개수     // 낮은 점수 L개   // 높은 점수 H개

        int [] Scores = new int[ N ];
        int sum = 0;
        for ( int i = 0; i < Scores.length; i++ ) {
            Scores[i] = sc.nextInt();
            sum += Scores[i];
        }
        // 배열을 오름차순으로 정렬하면..
        // 가장 낮은 점수 몇개
        // 가장 높은 점수 몇 개를 순서대로 생략하기 편하다.
        Arrays.sort( Scores );
        //System.out.println( Arrays.toString( Scores ));


        // 정렬이 되어있기 때문에
        // 배열 앞에서 부터 낮은 점수 L개 만큼 합을 빼주고, 점수 총 개수 N을 1씩 감소
        for ( int i = 0 ; i < L; i++ ) {
            sum -= Scores[i];
            N--;
        }
        // 정렬이 되어있기 때문에
        // 배열 뒤에서 부터 높은 점수 H개 만큼 합을 빼주고, 점수 총 개수 N을 1씩 감소
        for ( int i = Scores.length - 1; i > Scores.length - 1 - H; i-- ) {
            sum -= Scores[i];
            N--;
        }
        double Avg = (double)sum / N;
        System.out.println( Avg );
    }
}
