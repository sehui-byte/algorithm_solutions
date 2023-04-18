package boj.basic;

import java.util.Scanner;

/**
 * @문제명 : 피보나치 수 5
 * @주의 n이 2보다 작은 경우가 존재한다는 점.
 * @분류 재귀
 */
public class BOJ10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 0 <= n <= 20
        System.out.println(fibo(n));
    }

    private static int fibo(int n) {
        if(n < 2) return n;
        return fibo(n-1) + fibo(n-2);
    }
}
