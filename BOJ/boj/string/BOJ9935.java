package boj.string;

import java.util.Scanner;
import java.util.Stack;

/**
 * 1. replaceAll() -> 메모리초과
 * 2. stack을 활용하여 다시 풂.
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
