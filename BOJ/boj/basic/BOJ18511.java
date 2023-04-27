package boj.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @문제명 큰 수 구성하기
 * @문제 N보다 작거나 같은 자연수 중에서 집합 K의 원소로만 구성된 가장 큰 수를 출력
 * K의 원소의 개수 ≤ 3
 * N=657, K={1,5,7} => 답: 577
 * @풀이
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

        int result = find_max(String.valueOf(n).length(), 0, n, k);
        System.out.println(result);

    }

    private static int find_max(int digit, int currentMax, int n, int[] arr) {
        if (digit == 0 && currentMax <= n) return currentMax;

        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = currentMax * 10 + arr[i];
            if (num <= n) {
                int tmp = find_max(digit - 1, num, n, arr);
                max = Math.max(tmp, max);
            }
        }

        return max;
    }
}
