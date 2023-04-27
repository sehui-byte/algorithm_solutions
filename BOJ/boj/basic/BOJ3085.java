package boj.basic;

import java.util.Scanner;

/**
 * @문제명 사탕 게임
 * @분류 완전탐색
 */
public class BOJ3085 {
    static char[][] arr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //  (3 ≤ N ≤ 50)
        sc.nextLine();
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        find_max();
    }

    static private void find_max() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = countMaxCandyCount(swap(i, j, i, j - 1));
                int b = countMaxCandyCount(swap(i, j, i, j + 1));
                int c = countMaxCandyCount(swap(i, j, i + 1, j));
                int d = countMaxCandyCount(swap(i, j, i - 1, j));

                if (max < a) max = a;
                if (max < b) max = b;
                if (max < c) max = c;
                if (max < d) max = d;
            }
        }

        System.out.println(max);
    }

    static int countMaxCandyCount(char[][] clone) {
        if (clone == null) return -1;
        int max = 0;
        // row 체크
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (clone[i][j] == clone[i][j + 1]) count++;
                else count = 1;
                max = Math.max(max, count);
            }
        }

        // column 체크
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n-1; j++) {
                if (clone[j][i] == clone[j + 1][i]) count++;
                else count = 1;
                max = Math.max(max, count);
            }
        }
        return max;
    }

    static private char[][] swap(int i, int j, int a, int b) {
        if (a < 0 || a > n - 1 || b < 0 || b > n - 1) {
            return arr;
        }
        // deep copy
        char[][] clone = new char[n][n];
        for(int x = 0; x<n; x++) {
            clone[x] = arr[x].clone();
        }

        char tmp = clone[i][j];
        clone[i][j] = clone[a][b];
        clone[a][b] = tmp;

        return clone;
    }
}
