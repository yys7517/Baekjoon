package BOJ_1000_5000;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1246 {
    // 온라인 판매
    // 최대한 가지고 있는 달걀을 많이 파는 문제..
    // 총 N개의 달걀.. M명의 잠재적 구매자
    // M명의 잠재적 구매자가 구매하고자 하는 가격 Pi
    // 최대 수익을 올릴 수 있는 달갈의 가장 낮은 가격을 책정하자.
    /*
        5 4
        2
        8
        10
        7
     */
    //  1원에 팔면.. 4명이 다 사고.. 4원..
    //  2원에 팔면.. 4명이 다 사고.. 8원..
    //  3원에 팔면.. 3명이 사고.. 9원
    //  4원에 팔면 3명이 사고.. 12원..
    //  5원에 팔면 3명이 사고 15원
    //  6원에 팔면 3명이 사고 18원
    //  7원에 팔면 3명이 사고 21원
    //  8원에 팔면 2명이 사고 16원
    //  9원에 팔면 1명만 사고 10원
    //  10원에 팔면 1명만 사고 10원
    //  11원에 팔면 아무도 안삼.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] price = new int[M];
        int maxPrice = 0;
        for (int i = 0; i < M; i++) {
            price[i] = sc.nextInt();
            if (maxPrice < price[i])
                maxPrice = price[i];
        }
            /*
                5 4
                2
                8
                10
                7
            */
        // System.out.println( maxPrice );  10

        Arrays.sort(price);

        int[] result = new int[maxPrice + 1];
        int MinPrice = 1;
        int maxTotalPrice = 0;
        for (int i = MinPrice; i <= maxPrice; i++) {
            int temp = N;
            for (int j = 0; j < price.length; j++) {
                if (i <= price[j] && temp > 0) {
                    result[i] += i;
                    temp--;
                }
            }
            if (maxTotalPrice < result[i])
                maxTotalPrice = result[i];
        }
        // System.out.println( maxTotalPrice );
        // [0, 4, 8, 9, 12, 15, 18, 21, 16, 9, 10]
        // System.out.println( Arrays.toString( result ));
        for (int i = 1; i < result.length; i++) {
            if (result[i] == maxTotalPrice) {
                System.out.print(i + " " + maxTotalPrice);
                break;
            }
        }


    }
}
