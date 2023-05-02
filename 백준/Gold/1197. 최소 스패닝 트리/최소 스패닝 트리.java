import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Edge {
    int next, value;

    public Edge(int next, int value) {
        this.next = next;
        this.value = value;
    }
}

public class Main {

    private static Queue<Edge>[] que;
    private static int V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        V = Integer.parseInt(line[0]); // 정점 개수
        E = Integer.parseInt(line[1]); // 간선 개수
        que = new Queue[V];
        for (int i = 0; i < V; i++) {
            que[i] = new LinkedList<>();
        }
        // 간선 추가
        for (int i = 0; i < E; i++) {
            line = br.readLine().split(" ");
            int node1 = Integer.parseInt(line[0]) - 1;
            int node2 = Integer.parseInt(line[1]) - 1;
            int value = Integer.parseInt(line[2]);
            que[node1].add(new Edge(node2, value));
            que[node2].add(new Edge(node1, value));
        }
        br.close();
        // 풀이 ( 정점의 수가 더 적으므로 프림 알고리즘 적용)
        long answer = prim();
        System.out.println(answer);

    }

    private static long prim() {
        // 선택한 정점들에 연결된 간선중 가장 가중치가 낮은 간선 선택
        PriorityQueue<Edge> primQue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        boolean[] visited = new boolean[V];
        long result = 0;
        // 0번점에서부터 항상 찾기
        visited[0] = true;
        primQue.addAll(que[0]);
        while (!primQue.isEmpty()) {
            Edge now = primQue.poll();
            // 이미 방문한 정점의 경우 pass
            if (visited[now.next]) continue;
            result += now.value;
            visited[now.next] = true;
            primQue.addAll(que[now.next]);
        }
        return result;
    }
}