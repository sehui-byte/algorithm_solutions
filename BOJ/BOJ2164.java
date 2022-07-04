import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            q.add(i + 1);
        }

        while (q.size() > 1) {
            q.remove();
            int head = q.poll();
            q.add(head);
        }

        System.out.println(q.poll());

    }
}
