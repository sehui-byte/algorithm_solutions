import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
방향 그래프
 * 모든 간선의 가중치는 10 이하의 자연수.
 * V: 정점의개수, E: 간선의 개수  (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
 *  시작 정점의 번호 K(1 ≤ K ≤ V)
 *
 * */
public class BOJ1753 {
    static int V, E;
    static final int MAX_WEIGHT = 10; // 최대 가중치
    //    static int[][] Graph;
    // 메모리초과로 인해 2차원 배열에서 수정함
    static ArrayList<Node>[] graph;
    static int[] cost = new int[MAX_WEIGHT]; // K에서 V로 가는 최단경로 비용 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt(); // 정점의 개수
        E = sc.nextInt(); // 간선의 개수
        sc.nextLine();
        int startV = sc.nextInt(); // 시작 정점의 번호 (1<=K<=V)
        cost = new int[V + 1];

        // graph 초기화
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<Node>();
        }
        for (int i = 1; i <= E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            // u 에서 v로 가는 가중치 w인 간선이 존재
            graph[u].add(new Node(w, v));
        }

        for (int v = 1; v <= V; v++) {
            int cost = dijkstra(startV, v);
            // 경로가 없는 경우 INF를 출력한다
            if (cost == -1) {
                System.out.println("INF");
            } else {
                System.out.println(cost);
            }
        }
    }

    private static int dijkstra(int src, int dst) {
        if (src == dst) return 0;

        // weight가 가장 적은 것부터 꺼내기 위해 우선순위큐 사용
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[V + 1];

        // 일단 최댓값으로 초기화
        for (int i = 1; i <= V; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        // 시작점이므로 비용 0으로 설정
        cost[src] = 0;
        pq.add(new Node(0, src));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int to = current.destination;
            if (to == dst) return current.weight;
            if (visited[to]) continue; //이미 방문한 정점인 경우 패스

            // 다음 노드 방문
            visited[to] = true;
            for (int i = 0; i < graph[to].size(); i++) {
                Node next = graph[to].get(i);
                if (cost[next.destination] > cost[to] + next.weight) {
                    cost[next.destination] = cost[to]  + next.weight;
//                    pq.add(new int[]{dist[v], v + 1});
                    pq.add(new Node(cost[next.destination], next.destination));
                }
            }
        }
        return -1;
    }

    private static class Node implements Comparable<Node> {
        int weight;
        int destination;

        public Node(int weight, int destination) {
            this.weight = weight;
            this.destination = destination;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }


}

