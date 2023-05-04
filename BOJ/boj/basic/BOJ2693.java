package boj.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @문제명 N번째 큰 수
 * @문제 배열 A가 주어졌을 때, N번째 큰 값을 출력하는 프로그램
 * @풀이 소팅해서 세번째에 있는 값을 출력한다
 */

public class BOJ2693 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        int[]result = new int[n];

        for(int i = 0; i<n; i++) {
            int [] arr = new int[10];
            for(int j = 0; j<10; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            result[i] = arr[7];
        }

        for(int i = 0; i<n; i++) {
            System.out.println(result[i]);
        }
    }
}
