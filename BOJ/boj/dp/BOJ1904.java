package boj.dp;

import java.util.Scanner;


//      n=1 result = 1 1
//      n=2 result = 2 00, 11
//      n=3 result = 3 001, 100, 111
//      n=4 result = 5 0011, 0000, 1001, 1100, 1111
//      n=5 reuslt = 8 00001, 00111 , 00100, 10000, 10011, 11001, 11100, 11111

public class BOJ1904 {

    static int[] arr = new int[1000000];

    public static int fibo(int n) {
        //
        if (n == 1) {
            return arr[0];
        } else if (n == 2) {
            return arr[1];
        }

        arr[n-1] =  arr[n - 1] == 0 ? (fibo(n - 1) + fibo(n - 2)) % 15746 : arr[n - 1];
        return arr[n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        System.out.println(fibo(n));

    }
}
