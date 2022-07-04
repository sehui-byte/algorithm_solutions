import java.util.Scanner;

public class BOJ1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int answer = 0;
        while (true) {
            int result = s1.indexOf(s2);
            if (result == -1)
                break;
            answer++;
            s1 = s1.substring(result + s2.length());

        }
        System.out.println(answer);
    }
}
