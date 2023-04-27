import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] dis;
    private static boolean[] visited;
    private static List<Node>[] arr;
    private static int V, E, start;

    public static void main(String[] args) throws IOException {
        read();
        solution();
        print();
    }

    private static void print() {
        for (int i = 1; i < V + 1; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dis[i]);
            }
        }
    }

    private static void solution() {
        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        que.add(new Node(start, 0));
        dis[start]= 0;
        // 다익스트라
        // 더이상 방문하지 못할때까지 탐색
        while (!que.isEmpty()) {
            Node nowNode = que.poll();
            if(visited[nowNode.destiny]) continue;
            visited[nowNode.destiny] = true;
            // 2. 해당 거점을 공유하여 갔을떄 더짧은지 파악 및 갱신
            for (Node next : arr[nowNode.destiny]) {
                if (dis[next.destiny] > nowNode.weight + next.weight) {
                    dis[next.destiny] = nowNode.weight + next.weight;
                    que.add(new Node(next.destiny, dis[next.destiny]));
                }
            }
        }
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        V = Integer.parseInt(line[0]);
        E = Integer.parseInt(line[1]);
        visited = new boolean[V + 1];
        arr = new List[V + 1];
        for (int i = 0; i < V + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        start = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            String[] InputV = br.readLine().split(" ");
            int node1 = Integer.parseInt(InputV[0]);
            int node2 = Integer.parseInt(InputV[1]);
            int weight = Integer.parseInt(InputV[2]);
            arr[node1].add(new Node(node2, weight));
        }
        // 정렬
        for (List<Node> l : arr) {
            Collections.sort(l, (o1, o2) -> {
                if (o1.destiny == o2.destiny) {
                    return o1.weight - o2.weight;
                }
                return o1.destiny - o2.destiny;
            });
        }
        dis = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
    }

    private static class Node {
        int destiny;
        int weight;

        public Node(int destiny, int weight) {
            this.destiny = destiny;
            this.weight = weight;
        }

        public String toString() {
            return "[" + destiny + " " + weight + "]";
        }
    }
}