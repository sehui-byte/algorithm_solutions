package boj;

import java.util.Scanner;

// 폭발 문자열
public class BOJ9935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String blast = sc.nextLine();

        while(true) {
            if(s.length() == 0) {
                System.out.println("FRULA");
            }

            if(s.indexOf(blast) == -1) {
                System.out.print(s);
                break;
            }

            s = s.replaceAll(blast, "");
        }
    }
}
