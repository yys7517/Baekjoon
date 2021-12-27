package BOJ_15000_20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16199 {
    // 나이 계산하기
    // 생년월일
    // 기준날짜 순으로 입력이 주어진다..

    // 출력 :
    // 첫째 줄에 만 나이, 둘째 줄에 세는 나이, 셋째 줄에 연 나이를 출력한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

        // 입력 : 생년월일
        String [] token1 = br.readLine().split(" ");
        int birth_y = Integer.parseInt( token1[0] );
        int birth_m = Integer.parseInt( token1[1] );
        int birth_d = Integer.parseInt( token1[2] );

        // 입력 : 기준날짜
        String [] token2 = br.readLine().split(" ");
        int curr_y = Integer.parseInt( token2[0] );
        int curr_m = Integer.parseInt( token2[1] );
        int curr_d = Integer.parseInt( token2[2] );


        int man_y = 0;
        int count_y = 0;
        int yeon_y = 0;

        // 입력으로 주어지는 생년월일은 기준 날짜와 같거나 그 이전이다.

        // 만 나이 구하기

        // 기준 연도가 생년을 지났고,
        if ( curr_y > birth_y ) {
            count_y = curr_y - birth_y + 1;
            yeon_y = count_y - 1;
            // 기준 월일이 생년 월일과 같거나 크다면
            if ( curr_m > birth_m ) {
                man_y = curr_y - birth_y ;
            }
            else if ( curr_m == birth_m ) {
                if ( curr_d >= birth_d ) {
                    man_y = curr_y - birth_y ;
                }
                else {
                    man_y = curr_y - birth_y - 1;
                }
            }
            else { // curr_m < birth_m
                man_y = curr_y - birth_y - 1;
            }
        }
        else {
            man_y = 0;
            count_y = 1;
            yeon_y = 0;
        }

        System.out.println( man_y );
        System.out.println( count_y );
        System.out.println( yeon_y );



    }
}
