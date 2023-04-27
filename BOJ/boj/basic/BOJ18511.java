package boj.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @문제명 큰 수 구성하기
 * @문제 N보다 작거나 같은 자연수 중에서 집합 K의 원소로만 구성된 가장 큰 수를 출력
 * K의 원소의 개수 ≤ 3
 * N=657, K={1,5,7} => 답: 577
 * @분류 완전탐색, 재귀
 */
public class BOJ18511 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = sc.nextInt();
        sc.nextLine();
        int[] k = new int[count];
        for (int i = 0; i < count; i++) {
            k[i] = sc.nextInt();
        }

        Arrays.sort(k);

        int result = find_max(n, k, 0);
        System.out.println(result);

    }

    private static int find_max(int n, int[] k, int currentMax) {
        if(currentMax > n) return 0;
        int max = currentMax;
        for (int i = k.length - 1; i >= 0; i--) {
            int tmp = currentMax * 10 + k[i];
            max = Math.max(max, find_max(n, k, tmp));
        }
        return max;
    }
}
