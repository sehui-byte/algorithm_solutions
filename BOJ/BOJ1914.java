/*
재귀- 하노이탑 문제
*/

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ1914 {
	public static void Hanoi1(int n, int x, int y) {	

		if(n == 0) {
			return;
		}
		Hanoi1(n-1, x, 6-x-y); //n-1개의 원반을 중간 기둥으로 옮긴다
		System.out.println(x + " " + y);
		Hanoi1(n-1, 6-x-y, y); //n-1개의 원반을 중간기둥에서 목표지점 기둥으로 옮긴다
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //원판 개수
		BigInteger count = BigInteger.valueOf(2).pow(n); //2
		//BigInteger tmp = count.pow(n); //2의 n승
		BigInteger result = count.subtract(BigInteger.ONE); //빼기1
		
		System.out.println(result);
		
		if(n<=20) {
			Hanoi1(n,1,3);
		}
	}
}
