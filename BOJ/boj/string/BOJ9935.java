package boj.string;

import java.util.Scanner;
import java.util.Stack;

public class BOJ9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String bomb = sc.nextLine();

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            // stack에서 폭발문자열 길이만큼 꺼내서 비교
            if (stack.size() >= bomb.length()) {
                boolean isSame = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (bomb.charAt(j) != stack.get(stack.size() - bomb.length() + j)) {
                        isSame = false;
                        break; //시간초과 발생 안하도록 break문 넣어준다
                    }
                }

                if (isSame) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }

    }
}