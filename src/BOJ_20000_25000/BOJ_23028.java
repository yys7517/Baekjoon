package BOJ_20000_25000;

import java.util.Scanner;

public class BOJ_23028 {
    // 5학년은 다니기 싫어요
    // 아리가 졸업하려면 총 130학점 이상 들어야 하고, 그중 66학점 이상은 전공학점이어야 한다.

    //2022년 1학기부터는 한 학기에 전공 수업과 비전공 수업을 포함하여 최대 6과목을 수강할 수 있습니다.
    // 2022년 1학기부터 2026년 2학기까지 10개의 학기 동안 개설되는 과목의 수를 공지합니다.

    //한 과목을 수강하게 되면 3학점을 얻게 되고, 그러므로 한 학기에 최대 18학점을 이수할 수 있습니다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();      // 아리는 2021년 2학기까지 총 N학기를 마쳤다.
        int major = sc.nextInt();      // 전공학점을 A만큼 수강.
        int total = sc.nextInt();      // 전공학점을 포함한 총 학점 B

        int [] X = new int[10];
        int [] Y = new int[10];
        for (int i = 0; i < 10; i++) {
            X[i] = sc.nextInt();
            Y[i] = sc.nextInt();
        }

        if (major >= 66 && total >= 130)
            System.out.print("NICE");
            // 아리가 졸업하려면 총 130학점 이상 들어야 하고, 그중 66학점 이상은 전공학점이어야 한다.
        else {
            int cnt = 8 - N;
            int Ycnt = 12;   // 수강하는 비전공과목 개수.

            for (int i = 0; i < cnt; i++) {
                int Xcnt = 0;   // 수강하는 전공과목 개수.
                while (major < 66 && X[i] > 0) {
                    if (Xcnt == 6)
                        break;
                    major += 3;
                    total += 3;
                    Xcnt++;
                    Ycnt--;
                    X[i]--;
                }
            }

            for (int i = 0; i < cnt; i++) {
                while ( total < 130 && Y[i] > 0 ) {
                    if ( Ycnt == 0 ) break;
                    total += 3;
                    Ycnt--;
                    Y[i]--;
                }
                if ( Ycnt == 0 ) break;
            }
            System.out.println( major );
            System.out.println( total );

            if (major >= 66 && total >= 130)
                System.out.print("NICE");
            else
                System.out.print("Nae ga wae");
        }

    }
}




