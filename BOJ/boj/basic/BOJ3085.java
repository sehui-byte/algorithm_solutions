package boj.basic;

import java.util.Scanner;

/**
 * @문제명 사탕 게임
 * @분류 완전탐색
 * @풀이 상하좌우를 전체 다 swap할 필요 없이 하단과 오른쪽만 swap해주면 된다.
 * 결국 arr[i][j-1]을 오른쪽 arr[i][j]와 swap == arr[i][j]을 왼쪽 arr[i][j-1]과 swap
 * 이기 때문이다.
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
        findMax();
    }

    static private void findMax() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // 인접한 사탕(오른쪽과 아래쪽) swap
                swap(i, j, i, j + 1);
                max = Math.max(findMaxCandyCount(), max);
                swap(i, j + 1, i, j); //swap했던걸 돌려놓음
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                swap(i, j, i + 1, j);
                max = Math.max(findMaxCandyCount(), max);
                swap(i + 1, j, i, j);
            }
        }
        System.out.println(max);
    }

    static int findMaxCandyCount() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            // row 체크
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) count++;
                else count = 1;
                max = Math.max(max, count);
            }

            // column 체크
            count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) count++;
                else count = 1;
                max = Math.max(max, count);
            }
        }
        return max;
    }

    static private void swap(int i, int j, int a, int b) {
        char tmp = arr[i][j];
        arr[i][j] = arr[a][b];
        arr[a][b] = tmp;
    }
}
