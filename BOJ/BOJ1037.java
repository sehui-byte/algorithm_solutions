/*
  n의 진짜 약수(1, n 제외)가 주어질 때 n을 구하는 문제.
  약수들을 정렬한 담에 가장 작은 값과 가장 큰 값을 곱한다. 
  ex) n = 12
  2,3,4,6 이니까 2*6 이런식으로.
*/

import java.util.Scanner;
import java.util.Arrays;

public class BOJ1037 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();//약수의 개수
        int factors[] = new int[count];//약수
        for (int i = 0; i < factors.length; i++) {
            factors[i] = sc.nextInt();
        }

        if (factors.length == 1) {
            System.out.println(factors[0] * factors[0]);
        } else {
            Arrays.sort(factors);
            System.out.println(factors[0] * factors[factors.length - 1]);
        }
    }
}
