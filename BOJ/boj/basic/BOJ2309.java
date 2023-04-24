package boj.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @문제명 일곱 난쟁이
 * @문제 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성
 * @분류 브루트포스, 조합(combination)
 */
public class BOJ2309 {
    static int[] height;
    static boolean[] visited;
    static int[] res;
    static final int n = 9;
    static final int r = 7;
    static boolean printed;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        height = new int[n];
        visited = new boolean[n];
        res = new int[r];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        comb(0, 0);
    }

    private static void comb(int start, int depth) {
        if (depth == r) {
            if (Arrays.stream(res).sum() == 100) {
                printArr(res);
                printed = true;
                return;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[depth] = height[i];
                comb(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void printArr(int[] res) {
        if (!printed) {
            Arrays.sort(res);
            for (Integer i : res) {
                System.out.println(i);
            }
        }
    }
}
