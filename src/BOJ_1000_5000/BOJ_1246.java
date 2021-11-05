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

        // M명의 고객이 제시한 가격 배열.
        int[] price = new int[M];

        // 고객이 제시한 가격의 최대값을 구하는 이유 ?
        // 1원부터 하여 그 가격까지 옥션에서 판매를 할 때, 그 때의 총 수익을 확인하기 위해서.
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
        // 정렬을 굳이 하지 않아도 되더라..


        // 총 수익을 담는 배열 totalPrice
        // totalPrice의 i번째 값은 i 원에 판매를 할 때의 총 수익 값이 들어가게 된다.
        // 1원부터 maxPrice의 가격에 판매하게 될 때 수익들이 배열에 저장된다.
        // 0번 인덱스는 사용하지말자.
        int[] totalPrice = new int[maxPrice + 1];
        int MinPrice = 1;

        // 최대 수익을 구하자.
        int maxTotalPrice = 0;
        // 1원에 판매됬을 때 총 수익부터
        // maxPrice에 판매할 때 총 수익을 구하자.
        for (int i = MinPrice; i <= maxPrice; i++) {
            int temp = N;               // 계란의 개수만큼 판매할 수 있기 때문에
            for (int j = 0; j < price.length; j++) {
                if (i <= price[j] && temp > 0) {        // 판매하는 가격 i가 고객이 제시한 가격보다 작거나 같을 때, 고객은 구입한다.
                    totalPrice[i] += i; // 수익 i 만큼 증가. ( 판매가격 : i )
                    temp--;             // 달걀 개수 -1
                }
            }
            if (maxTotalPrice < totalPrice[i])
                maxTotalPrice = totalPrice[i];
        }
        // System.out.println( maxTotalPrice );
        // [0, 4, 8, 9, 12, 15, 18, 21, 16, 9, 10]
        // System.out.println( Arrays.toString( totalPrice ));

        // 0번 인덱스를 사용하지 않았으므로 1번 인덱스부터 확인.
        // 1원에 판매됬을 때 총 수익 부터 2원..3원.. 확인한다는 뜻.
        // 최대 수익과 같을 때의, 그 때 가격 i와, 최대 수익 값을 출력.
        // 최대 수익과 같을 때의 달걀 한 개당 최소의 가격을 구하는 것이기 때문에, 1부터 for문

        for (int i = 1; i < totalPrice.length; i++) {
            if (totalPrice[i] == maxTotalPrice) {
                System.out.print(i + " " + maxTotalPrice);
                break;                  // 달걀 한 개의 최소의 가격을 구하는 것이기 때문에, 출력하고 break 반복을 중지.
            }
        }


    }
}
