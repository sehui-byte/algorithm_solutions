package boj.basic;


import java.util.Scanner;

/**
 * @date 2023.04.18
 * @문제명 : 이진수
 * @문제 : 양의 정수 n이 주어졌을 때, 이를 이진수로 나타냈을 때
 * 1의 위치를 모두 찾는 프로그램을 작성하시오.
 * 최하위 비트(least significant bit, lsb)의 위치는 0이다.
 */

public class BOJ3460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int[] k = new int[n];

        for (int i = 0; i < n; i++) {
            k[i] = sc.nextInt();
            sc.nextLine();
        }

        for(int i = 0; i<n; i++) {
            binary(k[i]);
        }
    }

    private static void binary(int k) {
        int p = 0;
        while(k > 0) {
            if (k%2 == 1) System.out.print(p + " ");
            k = k/2;
            p++;
        }
        System.out.println();
    }
}
