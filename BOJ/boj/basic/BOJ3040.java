package boj.basic;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ3040 {
    static int[] arr = new int[9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        int a = 0; int b = 0;

        for (int i = 0; i < 9; i++) {
            int sum = Arrays.stream(arr).sum();
            sum -= arr[i];
            for (int j = i + 1; j < 9; j++) {
                sum -= arr[j];
                if (sum == 100) {
                    b = j; a = i; print(a,b);
                    return;
                }
                sum += arr[j];
            }
        }
    }

    private static void print(int a, int b) {
        for (int i = 0; i < 9; i++) {
            if (i == a || i == b) continue;
            System.out.println(arr[i]);
        }
    }
}
