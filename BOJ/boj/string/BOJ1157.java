package boj.string;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @문제명 단어 공부
 * @문제 알파벳 대소문자로 된 단어가 주어지면,
 *       이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램 구현
 * @분류 문자열
 * @풀이 나는 HashMap을 이용해서 풀었음.
 *      다른 사람들 풀이를 보니 new int[26] 으로 알파벳 배열을 만들어서
 *      char을 숫자로 바꿔서 (char - 'A') 카운팅값을 위 배열에 저장해서 풂.
 */
public class BOJ1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i<s.length(); i++) {
            char c = Character.toUpperCase(s.charAt(i));
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        char result = 0;
        for(Character key : hm.keySet()) {
            if(hm.get(key) > max) {
                max = hm.get(key);
                result = key;
            }
        }

        // 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력
        int count = 0;
        for(Integer value : hm.values()) {
            if(max == value) {
                count++;
            }
        }

        if(count > 1) result = '?';

        System.out.println(result);
    }
}
