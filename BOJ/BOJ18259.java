import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Queue {

    StringBuilder sb = new StringBuilder();
    LinkedList<Integer> list = new LinkedList<Integer>();

    public void push(int x) {
        list.add(x);
    }

    public void pop() throws IOException {
        //가장 앞에 있는 정수를 빼고 그 수를 출력한다
        //만일 큐에 들어있는 정수가 없으면 -1 출력
        sb.append(list.isEmpty() ? "-1" : list.poll());
        sb.append("\n");
    }

    public void size() throws IOException {
        //큐에 들어있는 정수의 개수를 출력한다
        sb.append(list.size() + "\n");

    }

    public void empty() throws IOException {
        //큐가 비어있으면 1, 아니면 0 출력
        sb.append(list.isEmpty() ? "1" : "0");
        sb.append("\n");
    }

    public void front() throws IOException {
        //가장 앞에 있는 정수를 출력
        //만약 큐에 들어있는 정수가 없으면 -1 출력
        sb.append(list.isEmpty() ? "-1" : list.getFirst());
        sb.append("\n");

    }

    public void back() throws IOException {
        //가장 뒤에 있는 정수를 출력
        //만약 큐에 들어있는 정수가 없는 경우 -1 출력
        sb.append(list.isEmpty() ? "-1" : list.getLast());
        sb.append("\n");

    }

    public void print() {
        System.out.print(sb);
    }
}

public class BOJ18259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue q = new Queue();
        String command[] = new String[n];

        for (int i = 0; i < n; i++) {
            command[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            String tmp = command[i];

            switch (tmp) {
                case "front":
                    q.front();
                    break;
                case "pop":
                    q.pop();
                    break;
                case "size":
                    q.size();
                    break;
                case "empty":
                    q.empty();
                    break;
                case "back":
                    q.back();
                    break;
                default:
                    String sx = tmp.substring(5);
                    int x = Integer.parseInt(sx);
                    q.push(x);
            }
        }

        q.print();
        br.close();
    }
}
