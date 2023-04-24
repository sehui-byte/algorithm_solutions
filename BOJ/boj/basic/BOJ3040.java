package boj.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @문제명 백설공주와 일곱난쟁이
 * @분류 브루트포스
 * @풀이 9명의 난쟁이 중에서 가짜 난쟁이 2명을 골라야 함.
 *      2중 for문 돌려서 난쟁이 둘을 제거했을 때 합이 100이 나오는지 체크
 */
public class BOJ3040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        int a = 0;
        int b = 0;

        int total = Arrays.stream(arr).sum();

        for (int i = 0; i < 9; i++) {
            int sum = total;
            for (int j = i + 1; j < 9; j++) {
                sum = total - (arr[i] + arr[j]);
                if (sum == 100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == a || i == b) {
                continue;
            }
            System.out.println(arr[i]);
        }
    }
}
