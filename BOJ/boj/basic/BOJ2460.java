package boj.basic;

import java.util.Scanner;

/**
 * @문제명 지능형 기차2
 */
public class BOJ2460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int count = 0;

        for (int i = 0; i < 10; i++) {
            int off = sc.nextInt();
            int on = sc.nextInt();
            sc.nextLine();

            count = count + on - off;
            if(max < count) max = count;
        }

        System.out.println(max);
    }
}
