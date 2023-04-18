package boj.basic;

import java.util.Scanner;

// 약수 구하기
// 두 개의 자연수 N과 K가 주어졌을 때, N의 약수들 중 K번째로 작은 수를 출력하는 프로그램
public class BOJ2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        int count = 0;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            // 약수를 구한다
            if (n % i == 0) count++;

            // k번째로 작은 약수 찾았을 경우 출력
            if (count == k) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
