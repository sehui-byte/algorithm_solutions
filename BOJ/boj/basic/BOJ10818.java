package boj.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @문제명 최소, 최대
 * @시간복잡도 for문 사용하여 구현시 -> O(n)
 * @보완 더 빨리 풀기 위해서는 java에서 제공하는 Arrays.sort() 메서드를 사용
 * 해당 메서드는 Dual-Pivot Quicksort를 사용하여
 * 최악의 경우에도 O(n log n)의 속도를 보장.
 */
public class BOJ10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();

        // 시간복잡도 O(n)의 간단한 풀이
//        loop(arr);
        sort(arr);

        sc.close();

    }

    private static void loop(int[] arr) {
        int max = -1000000;
        int min = 1000000;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        System.out.println(min + " " + max);
    }

    private static void sort(int[] arr) {
        Arrays.sort(arr); // Dual-Pivot Quicksort를 사용
        System.out.println(arr[0] + " " + arr[arr.length - 1]);
    }
}
