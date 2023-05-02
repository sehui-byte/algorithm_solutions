package boj.string;

import java.util.Scanner;
import java.util.Stack;

/**
 * 1. replaceAll() -> 메모리초과 (Pattern객체가 계속 새로 생성되기 때문)
 * 2. stack을 활용하여 다시 풂 :
 *          스택에 문자열을 넣고 폭발 문자열 길이만큼 꺼내서 비교한다.
 *          폭발 문자열과 일치하면 스택에서 문자열을 꺼낸다.
 *          최종적으로 스택에 남은 문자열을 꺼내서 이어붙이면 결과값이 된다.
 */
public class BOJ9935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String bomb = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean isSame = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    for (int k = 0; k < bomb.length(); k++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
    }
}
